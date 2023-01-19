package controllers;

import Management.Ticket;
import entities.User;
import repositories.interfaces.*;

import java.util.List;

import static repositories.proporties.UserDBProporties.*;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String createUser(String name, String surname, int age, String gender, boolean disabled) {
        boolean male = (gender.toLowerCase().equals("male"));
        User user = new User(name, surname, age, male, disabled);

        boolean created = repo.createUser(user);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getUser(int id) {
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        return users.toString();
    }

    public String updateUser(int id, String columnName, String newValue){
        User user = repo.getUser(id);
        if (repo.updateUser(user, columnName, newValue)){
            if(columnName.equals(USER_DB_NAME)){
                user.setName(newValue);
            } else if(columnName.equals(USER_DB_SURNAME)){
                user.setSurname(newValue);
            } else if(columnName.equals(USER_DB_AGE)){
                user.setAge(Integer.parseInt(newValue));
            } else if(columnName.equals(USER_DB_GENDER)){
                user.setGender(Boolean.parseBoolean(newValue));
            } else if(columnName.equals(USER_DB_DISABLED)){
                user.setDisabled(Boolean.parseBoolean(newValue));
            } else if(columnName.equals(USER_DB_TICKET)){
                user.setTicket(new Ticket(Integer.parseInt(newValue)));
            } else {
                return "User was not updated! \n There is no such a property.";
            }
            return "User was updated!";
        }else{
            return "User was not updated!";
        }
    }
}
