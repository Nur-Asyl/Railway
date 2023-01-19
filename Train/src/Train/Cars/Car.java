package Train.Cars;

public abstract class Car {
    // fields
    private double carryingCapacity;

    //constructor
    public Car(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    //getters and setters
    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
