package controllers;

import Management.Ticket;
import Train.Train;
import repositories.interfaces.ITrainRepository;

import java.util.List;


public class TrainController {
    private final ITrainRepository trepo;

    public TrainController(ITrainRepository repo) {
        this.trepo = repo;
    }

    public String createTrain(String name, String locomotive, int cars) {
        Train train = new Train(name, locomotive, cars);

        boolean created = trepo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrain(int id) {
        Train train = trepo.getTrain(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = trepo.getAllTrains();

        return trains.toString();
    }

    public String getAllTickets() {
        List<Ticket> tickets = trepo.getAllTickets();

        return tickets.toString();
    }

    public String updateTrain(int id, String columnName, String newValue){
        Train train = trepo.getTrain(id);

        if (trepo.updateTrain(train, columnName, newValue)){
            if(columnName.equals("name")){
                train.setName(newValue);
            } else if(columnName.equals("locomotive")){
                train.setLocomotive(newValue);
            } else if(columnName.equals("cars")){
                train.setNumberOfCars(Integer.parseInt(newValue));
            } else {
                return "Train was not updated! \n There is no such a property.";
            }
            return "Train was updated!";
        }else{
            return "Train was not updated!";
        }
    }
}
