import java.util.*;
import java.io.*;
public class Person {
    String name;
    int ticketNo;
    public Person prevPerson;
    public Person nextPerson;

    public Person() {
        prevPerson = null;
        nextPerson = null;
        name = " ";
        ticketNo = 0;
    }
    public Person(String name, int ticketNo) {
        this.name = name;
        this.ticketNo = ticketNo;
    }
    public void setPrevPerson(Person before) {
        this.prevPerson = before;
    }
    public void setNextPerson(Person after) {
        this.nextPerson = after;
    }
    public Person getPrevPerson() {
        return prevPerson;
    }
    public Person getNextPerson() {
        return nextPerson;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }
    public String getName() {
        return name;
    }
    public int getTicketNo() {
        return ticketNo;
    }
    public String toString() {
        return "["  + getName() + " , " + getTicketNo() + "]";
    }
}
