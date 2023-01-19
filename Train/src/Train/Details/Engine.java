package Train.Details;

public abstract class Engine {
    private double power;
    private boolean state;

    public Engine(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}
