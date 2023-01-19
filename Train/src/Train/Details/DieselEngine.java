package Train.Details;

public class DieselEngine extends Engine{
    private double capacity;

    public DieselEngine(double power, double capacity) {
        super(power);
        this.capacity = capacity;
    }

    public double getCapasity() {
        return capacity;
    }

    public void setCapasity(double capasity) {
        this.capacity = capasity;
    }

    @Override
    public void turnOn() {
        this.setState(true);
    }

    @Override
    public void turnOff() {
        this.setState(false);
    }
}
