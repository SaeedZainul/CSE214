import java.util.Scanner;
public class Line {
    public Person head;
    private Person tail;
    private int size;
    public Person cursor;
    public Line() {
        head = null;
        size = 0;
        tail = null;
    }


    public void addPerson(String name, int ticketNo) {
        if(head == null) {
            Person newNode = new Person(name, ticketNo);
            head = newNode;
            tail = newNode;
        }
        else {
            Person newNode = new Person(name, ticketNo);
            tail.setNextPerson(newNode);
            newNode.setPrevPerson(tail);
            tail = newNode;
        }
        size++;
    }
    public int size() {
        return size;
    }
    public String toString() {
        cursor = head;
        String returned = "";
        returned += cursor;
        cursor = cursor.getNextPerson();
        while(cursor != null) {
            returned += "," + cursor;
            cursor = cursor.getNextPerson();
        }
        return returned;
    }
    public String printReverse() {
        cursor = tail;
        String returned = "";
        returned += cursor;
        cursor = cursor.getPrevPerson();
        while(cursor != null) {
            returned += "," + cursor;
            cursor = cursor.getPrevPerson();
        }
        return returned;
    }
    public void sort() {
        boolean done = false;
        cursor = head;
        Person trailing = null;
        if(cursor == null) {
            return;
        }
        else if (cursor.getNextPerson() == null) {
            return;
        }

        else {
            while(!done) {
                cursor = head;
                done = true;
                while(cursor !=  tail) {
                    if(cursor.getNextPerson().getTicketNo() < cursor.getTicketNo()) {
                        swap(cursor.getNextPerson(), cursor);
                        done = false;
                    }
                    cursor = cursor.getNextPerson();
                }
            }
        }
    }
    public void swap(Person node1, Person node2){
        String nameTempA;
        int ticketNoTempA;
        nameTempA = node1.getName();
        ticketNoTempA = node1.getTicketNo();
        node1.setName(node2.getName());
        node1.setTicketNo(node2.getTicketNo());
        node2.setName(nameTempA);
        node2.setTicketNo(ticketNoTempA);
    }

    void removePerson(String name) throws personNotFoundException {
        boolean deleted = false;
        cursor = head; //starts the pointer at the head
        while(!(cursor == null)){
            if(cursor.getName().equals(name)){ //checks for the name equivalency

                if(cursor ==head){
                    head = head.getNextPerson();
                    head.setPrevPerson(null);
                    deleted = true;
                }
                else if (cursor == tail) {
                    cursor = cursor.getPrevPerson();
                    cursor.setNextPerson(null);
                    System.out.println(cursor.getName());
                    deleted = true;

                }
                else{
                    cursor.getPrevPerson().setNextPerson(cursor.getNextPerson());  //sets the next pointer for cursors previous node to the node after cursor
                    cursor.getNextPerson().setPrevPerson(cursor.getPrevPerson());  //sets the previous pointer for cursors next node to the node before cursor
                    deleted = true;
                }
            }
            else {
                cursor = cursor.getNextPerson();
            }
        }
        if(deleted == false) {
            throw new personNotFoundException("Person was not found in line");  // throws exception if the person is not in the line using the class
        }
        else {
            size--;
        }
    }
    public void removePerson(int ticketNo) throws personNotFoundException {
        cursor = head;
        boolean deleted = false;
        while(cursor != null) {
            if(cursor.getTicketNo() == ticketNo) {

                if(cursor == head) {
                    if(cursor.getNextPerson() == null) {
                        cursor = null;
                    }
                    cursor = cursor.getNextPerson();
                    cursor.setPrevPerson(null);
                    deleted = true;
                }
                else if(cursor == tail) {
                    cursor = cursor.getPrevPerson();
                    cursor.setNextPerson(null);
                    deleted = true;
                }
                else {
                    cursor.getPrevPerson().setNextPerson(cursor.getNextPerson());
                    cursor.getNextPerson().setPrevPerson(cursor.getPrevPerson());
                    deleted = true;
                }
            }
            cursor = cursor.getNextPerson();
        }
        if (deleted = false) {
            throw new personNotFoundException("that person is not in the list");
        }
        else{
            size--;
        }

    }
    public void removePerson1(int ticketNo) {
        cursor = head;

    }
    public void balance() {
        cursor = tail;
        String name;
        int ticketNo;
        Person temp = new Person();
        boolean flag = true;
        while(flag) {

        }

    }
    public boolean duplicate(int ticket) {
        boolean flag = false;
        cursor = head;
        while(cursor != head) {
            if(cursor.getTicketNo() == ticket) {
                flag = true;
            }
            cursor = cursor.getNextPerson();
        }
        return flag;
    }
    public boolean contains(int ticketNo) {
        cursor = head;
        while (!(cursor == null)) {
            if (cursor.getTicketNo() == ticketNo) { //checks for the ticket number equivalency
                return true;
            } else {
                cursor = cursor.getNextPerson();
            }
        }
        return false;
    }
}
