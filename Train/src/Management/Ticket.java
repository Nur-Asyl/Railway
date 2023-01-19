package Management;

public class Ticket {
    private int ticket_id;
    private int car_id;
    private int train_id;

    public Ticket(int ticket_id, int car_id, int train_id) {
        this.ticket_id = ticket_id;
        this.car_id = car_id;
        this.train_id = train_id;
    }
    public Ticket(int train_id){
        this.train_id = train_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "\n\ttrain_id=" + train_id +
                "\n\tticket_id=" + ticket_id +
                "\n\ttrain_id=" + car_id +
                "\n}";
    }
}
