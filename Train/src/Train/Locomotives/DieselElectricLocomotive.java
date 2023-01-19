package Train.Locomotives;

import Train.Details.DieselEngine;

public class DieselElectricLocomotive extends Locomotive{
    private DieselEngine engine;
    public DieselElectricLocomotive(double speed, double fuelCapacity, double power, double weight, String model, String serialNumber, String manufacturer, DieselEngine engine) {
        super(speed, fuelCapacity, power, weight, model, serialNumber, manufacturer);
        this.engine = engine;
    }

    public DieselEngine getEngine() {
        return engine;
    }

    public void setEngine(DieselEngine engine) {
        this.engine = engine;
    }
}
