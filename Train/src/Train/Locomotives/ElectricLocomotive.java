package Train.Locomotives;

import Train.Details.ElectricEngine;

public class ElectricLocomotive extends Locomotive{
    private ElectricEngine engine;
    public ElectricLocomotive(double speed, double fuelCapacity, double power, double weight, String model, String serialNumber, String manufacturer, ElectricEngine engine) {
        super(speed, fuelCapacity, power, weight, model, serialNumber, manufacturer);
        this.engine = engine;
    }

    public ElectricEngine getEngine() {
        return engine;
    }

    public void setEngine(ElectricEngine engine) {
        this.engine = engine;
    }
}
