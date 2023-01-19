package repositories.interfaces;

import Management.Ticket;
import entities.User;
import Train.*;

import java.util.List;

public interface ITrainRepository {
    boolean createTrain(Train train);
    boolean updateTrain(Train train, String columnName, String newValue);
    Train getTrain(int id);
    List<Train> getAllTrains();
    List<Ticket> getAllTickets();
}
