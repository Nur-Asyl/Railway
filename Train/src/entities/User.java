package entities;

import Management.Ticket;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;
    private boolean gender;
    private boolean disabled;
    private Ticket ticket = new Ticket(-1);

    public User() {

    }

    public User(String name, String surname, int age, boolean gender, boolean disabled) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
        setDisabled(disabled);
    }

    public User(int id, String name, String surname, int age, boolean gender, boolean disabled) {
        setId(id);
        setName(name);
        setSurname(surname);
        setAge(age);
        setGender(gender);
        setDisabled(disabled);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "User{" +
                "\n\tid=" + id +
                ", \n\tname='" + name + '\'' +
                ", \n\tsurname='" + surname + '\'' +
                ", \n\tage=" + age +
                ", \n\tgender=" + (gender ? "Male" : "Female") +
                ", \n\tdisabled=" + disabled +
                ", \n\tticket='" + (ticket.getTrain_id() != -1 ? "No ticket'" : ticket.getTicket_id()) +
                "\n}";
    }
}
