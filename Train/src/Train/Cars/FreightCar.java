package Train.Cars;

public class FreightCar extends Car{
    private String cargo;
    public FreightCar(double carryingCapacity, String cargo) {
        super(carryingCapacity);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
