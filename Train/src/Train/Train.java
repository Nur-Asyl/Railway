package Train;

import Train.Cars.*;
import Train.Locomotives.*;

import java.util.ArrayList;

public class Train {
    private int train_id;
    private String name;
    private String locomotive;
    private ArrayList<Car> cars = new ArrayList<>();
    private int numberOfCars;

    public Train(String name, String locomotive, int numberOfCars) {
        this.name = name;
        this.locomotive = locomotive;
        this.numberOfCars = numberOfCars;
    }

    public Train(int train_id, String name, String locomotive, int numberOfCars) {
        this.train_id = train_id;
        this.name = name;
        this.locomotive = locomotive;
        this.numberOfCars = numberOfCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(String locomotive) {
        this.locomotive = locomotive;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public void addCar(Car c){
        this.cars.add(c);
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }
    @Override
    public String toString() {
        return "Train{" +
                "\n\ttrain_id=" + train_id +
                ", \n\tname='" + name + '\'' +
                ", \n\tlocomotive='" + locomotive + '\'' +
                ", \n\tcars=" + cars +
                "\n}";
    }
}
