import java.util.*;
public class SecurityCheckDriver {
    public static void main(String[] args) throws personNotFoundException {
        Scanner input = new Scanner(System.in);
        SecurityCheck obj = new SecurityCheck();
        String chosen = "z";
        System.out.println("Please enter one of the following \n A: add person \n R: remove person \n P: print lines \n w: print the lines in reverse \n Q: quit");
        chosen = input.nextLine().toLowerCase();
        while (chosen != "q") {
            switch (chosen) {
                case "a":
                    System.out.println("enter the amount of people you want to add");
                    int n = input.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.println("please enter the name of the person you would like to add & their ticket number");
                        String nameA = input.next();
                        int ticketNoA = input.nextInt();
                        Person added = new Person(nameA, ticketNoA);
                        obj.addPerson(added);
                        System.out.println("person has been successfully added");

                    }
                    break;
                case "r":
                    System.out.println("please enter the ticket number that you would like to remove");
                    int ticket = input.nextInt();
                    Person remove = new Person();
                    remove.setTicketNo(ticket);
                    obj.removePerson(remove);
                    System.out.println("Person has been successfully removed from the line");
                    break;

                case "p":
                    obj.printSecurityCheck();
                    break;
                case "pr":
                    obj.printSecurityCheckReverse();
                    break;
                case "q":
                    System.out.println("GoodBye");
                    System.exit(0);
                    break;
            }
            System.out.println("Please enter one of the following \n A: add person \n R: remove person \n P: print lines \n w: print the lines in reverse \n Q: quit");
            chosen = input.nextLine().toLowerCase();
        }
    }
}
