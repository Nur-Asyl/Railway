package Train.Cars;

public class PassengerCar extends Car{
    private int numberOfPassengers;
    public PassengerCar(double carryingCapacity, int numberOfPassengers) {
        super(carryingCapacity);
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
