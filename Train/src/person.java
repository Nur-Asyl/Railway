public class person {
    private String name;
    private int date;
    private String ticketName;

    public void setDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
    public person(String name,int date ,String ticketName){
        this.name = name;
        this.date= date;
        this.ticketName= ticketName;
    }
}