package repositories;

import Management.Ticket;
import Train.Locomotives.DieselElectricLocomotive;
import Train.Locomotives.Locomotive;
import data.interfaces.IDB;
import entities.User;
import repositories.interfaces.ITrainRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import Train.*;

import static repositories.proporties.UserDBProporties.*;
import static repositories.proporties.UserDBProporties.USER_DB_DISABLED;

public class TrainRepository implements ITrainRepository {
    private final IDB db;

    public TrainRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTrain(Train train) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO train(" +
                    "name" + "," +
                    "locomotive" + "," +
                    "cars" + ") VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, train.getName());
            st.setString(2, train.getLocomotive().toString());
            st.setInt(3, train.getNumberOfCars());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateTrain(Train train, String columnName, String newValue) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE train SET " + columnName + " = ? WHERE train_id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            if (columnName.equals("name") || columnName.equals("locomotive")) {
                stmt.setString(1, newValue);
            } else if (columnName.equals("cars")) {
                stmt.setInt(1, Integer.parseInt(newValue));
            } else {
                System.out.println("A mistake in repository");
                return false;
            }
            stmt.setInt(2, train.getTrain_id());

            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Train getTrain(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " +
                    "name" + "," +
                    "locomotive" + "," +
                    "cars" + " FROM train WHERE train_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Train train = new Train(rs.getString("name"),
                        rs.getString("locomotive"),
                        rs.getInt("cars"));

                return train;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Train> getAllTrains() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " +
                    "train_id" + "," +
                    "name" + "," +
                    "locomotive" + "," +
                    "cars" + " FROM train";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Train> trains = new LinkedList<>();
            while (rs.next()) {
                Train train = new Train(rs.getInt("train_id"),
                        rs.getString("name"),
                        rs.getString("locomotive"),
                        rs.getInt("cars"));

                trains.add(train);
            }

            return trains;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Ticket> getAllTickets() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " +
                    "train_id" + "," +
                    "car_id" + "," +
                    "ticket_id" + " FROM ticket";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Ticket> tickets = new LinkedList<>();
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getInt("train_id"),
                        rs.getInt("car_id"),
                        rs.getInt("ticket_id"));

                tickets.add(ticket);
            }

            return tickets;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}
