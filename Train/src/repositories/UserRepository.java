package repositories;

import Management.Ticket;
import data.interfaces.IDB;
import entities.User;
import repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static repositories.proporties.UserDBProporties.*;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(" +
                    USER_DB_NAME + "," +
                    USER_DB_SURNAME + "," +
                    USER_DB_AGE + "," +
                    USER_DB_GENDER + "," +
                    USER_DB_DISABLED + ") VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setInt(3, user.getAge());
            st.setBoolean(4, user.getGender());
            st.setBoolean(5, user.getDisabled());

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
    public boolean updateUser(User user, String columnName, String newValue){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE users SET " + columnName + " = ? WHERE id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            if(columnName.equals(USER_DB_NAME) || columnName.equals(USER_DB_SURNAME))
            {
                stmt.setString(1, newValue);
            } else if(columnName.equals(USER_DB_GENDER) || columnName.equals(USER_DB_DISABLED)) {
                stmt.setBoolean(1, Boolean.parseBoolean(newValue));
            } else if(columnName.equals(USER_DB_AGE)) {
                stmt.setInt(1,Integer.parseInt(newValue));
            } else if(columnName.equals(USER_DB_TICKET)) {
                stmt.setInt(1,Integer.parseInt(newValue));
            } else{
                System.out.println("User rep error");
                return false;
            }
            stmt.setInt(2, user.getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " +
                    USER_DB_ID + "," +
                    USER_DB_NAME + "," +
                    USER_DB_SURNAME + "," +
                    USER_DB_AGE + "," +
                    USER_DB_GENDER + "," +
                    USER_DB_DISABLED + " FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"),
                        rs.getBoolean("disabled"));

                return user;
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
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " +
                    USER_DB_ID + "," +
                    USER_DB_NAME + "," +
                    USER_DB_SURNAME + "," +
                    USER_DB_AGE + "," +
                    USER_DB_GENDER + "," +
                    USER_DB_DISABLED + " FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user = new User(rs.getInt(USER_DB_ID),
                        rs.getString(USER_DB_NAME),
                        rs.getString(USER_DB_SURNAME),
                        rs.getInt(USER_DB_AGE),
                        rs.getBoolean(USER_DB_GENDER),
                        rs.getBoolean(USER_DB_DISABLED));

                users.add(user);
            }

            return users;
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
