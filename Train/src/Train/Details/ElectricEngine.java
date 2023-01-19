package Train.Details;

public class ElectricEngine extends Engine{
    private double charge;
    public ElectricEngine(double power, double charge) {
        super(power);
        this.charge = charge;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
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
