public class SecurityCheck {
    Line lineA = new Line();
    Line lineB = new Line();
    public SecurityCheck( ) {

    }
    public void addPerson(Person person) {
        if(lineA.size() > lineB.size()) {
            lineB.addPerson(person.getName(), person.getTicketNo());
            lineB.sort();
        }
        else if (lineB.size() > lineA.size()) {
            lineA.addPerson(person.getName(), person.getTicketNo());
            lineA.sort();
        }
        else {
            lineA.addPerson(person.getName(), person.getTicketNo());
            lineA.sort();
        }
    }
    public void removePerson(Person person) throws personNotFoundException {
        if(lineA.contains(person.getTicketNo())) {
            lineA.removePerson(person.getTicketNo());
            if(lineA.size() - 1 < lineB.size()) {
                lineA.balance();
                lineA.sort();
            }
        }
        else if(lineB.contains(person.getTicketNo())) {
            lineB.removePerson(person.getTicketNo());
            if(lineB.size() - 1 < lineA.size()) {
                lineB.balance();
                lineB.sort();
            }

        }
        else {
            throw new personNotFoundException("that person is not in either of the lines");
        }
    }
    public void printSecurityCheck() {
        System.out.println("Line A:" + lineA);
        System.out.println("Line B:" + lineB);
    }
    public void printSecurityCheckReverse() {
        System.out.println("Line A:" + lineA.printReverse());
        System.out.println("Line B:" + lineB.printReverse());
    }
}
