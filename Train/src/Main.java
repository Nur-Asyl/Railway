import controllers.TrainController;
import controllers.UserController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.TrainRepository;
import repositories.UserRepository;
import repositories.interfaces.ITrainRepository;
import repositories.interfaces.IUserRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IDB db = new PostgresDB();
        IUserRepository repo = new UserRepository(db);
        ITrainRepository trepo = new TrainRepository(db);
        UserController controller = new UserController(repo);
        TrainController trainController = new TrainController(trepo);
        MyApplication app = new MyApplication(controller, trainController);
        app.start();

    }
}