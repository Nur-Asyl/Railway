package Train.Locomotives;

public abstract class Locomotive {
    private double speed, fuelCapacity, power, weight;
    private String model, serialNumber, manufacturer;

    public Locomotive(double speed, double fuelCapacity, double power, double weight, String model, String serialNumber, String manufacturer) {
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
        this.power = power;
        this.weight = weight;
        this.model = model;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
