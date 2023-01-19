package Passengers;

import Management.Ticket;

public class Passenger {
    private String fullName;
    private int age, id;
    private Ticket ticket;

    public Passenger(String fullName, int age, int id) {
        this.fullName = fullName;
        this.age = age;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
