package Passengers;

public class DisabledPassenger extends Passenger{
    private int discount;
    public DisabledPassenger(String fullName, int age, int id, int discount) {
        super(fullName, age, id);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
