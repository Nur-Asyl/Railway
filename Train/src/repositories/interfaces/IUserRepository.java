package repositories.interfaces;

import entities.User;

import java.util.List;

public interface IUserRepository {
    boolean createUser(User user);
    boolean updateUser(User user, String columnName, String newValue);
    User getUser(int id);
    List<User> getAllUsers();
}
