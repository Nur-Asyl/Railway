import controllers.TrainController;
import controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

import Train.Train.*;

import static repositories.proporties.UserDBProporties.*;

public class MyApplication {
    private final UserController controller;
    private final TrainController trainController;
    private final Scanner scanner;

    public MyApplication(UserController controller, TrainController trainController) {
        this.controller = controller;
        this.trainController = trainController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("*************************");
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("4. Update user");
            System.out.println(("5. Buy ticket"));

            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-5): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllUsersMenu();
                } else if (option == 2) {
                    getUserByIdMenu();
                } else if (option == 3) {
                    createUserMenu();
                } else if (option == 4) {
                    updateUserMenu();
                } else if (option == 5) {
                    buyTicketMenu();
                    add person = new add();
                    person.startAdd();

                } else {
                    scanner.close();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + ": Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getAllTrainsMenu() {
        String response = trainController.getAllTrains();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.print("Please enter id: ");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.print("Please enter id: ");

        int id = scanner.nextInt();
        String response = trainController.getTrain(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter " + USER_DB_NAME);
        String name = scanner.next();
        System.out.println("Please enter " + USER_DB_SURNAME);
        String surname = scanner.next();
        System.out.println("Please enter " + USER_DB_AGE);
        int age = scanner.nextInt();
        System.out.println("Please enter " + USER_DB_GENDER + " (male/female)");
        String gender = scanner.next();
        System.out.println("Please enter " + USER_DB_DISABLED + " (true/false)");
        Boolean disabled = scanner.nextBoolean();

        String response = controller.createUser(name, surname, age, gender, disabled);
        System.out.println(response);
    }

    public void buyTicketMenu() {
        System.out.println("Tickets:");
        System.out.println(trainController.getAllTickets());
        System.out.print("Please user enter id: ");
        int id = scanner.nextInt();
        System.out.println(trainController.getAllTrains());
        System.out.print("Choose train by id: ");
        String response = controller.updateUser(id, "ticket_id", scanner.next());
        System.out.println(response);
    }

    public void updateUserMenu(){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        while(true) {
            controller.getUser(id).toString();
            System.out.print("Edit:" +
                    "\n1. " + USER_DB_NAME +
                    "\n2. " + USER_DB_SURNAME +
                    "\n3. " + USER_DB_AGE +
                    "\n4. " + USER_DB_GENDER +
                    "\n5. " + USER_DB_DISABLED +
                    "\n9. back" +
                    "\nEnter option(1-5): ");
            try {
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.print("Edit Name: ");
                    System.out.println("\t" + controller.updateUser(id, USER_DB_NAME ,scanner.next()));
                } else if (option == 2) {
                    System.out.print("Edit Surname: ");
                    System.out.println("\t" + controller.updateUser(id, USER_DB_SURNAME ,scanner.next()));
                } else if (option == 3) {
                    System.out.print("Edit age: ");
                    System.out.println("\t" + controller.updateUser(id, USER_DB_AGE ,scanner.next()));
                } else if (option == 4) {
                    System.out.print("Edit gender (male/female): ");
                    System.out.println("\t" + controller.updateUser(id, USER_DB_GENDER ,scanner.next()));
                } else if (option == 5) {
                    System.out.print("Edit disability (true/false): ");
                    System.out.println("\t" + controller.updateUser(id, USER_DB_DISABLED ,scanner.next()));
                } else if (option == 6) {
                    System.out.print("Edit ticket: " +
                            "\n1. " + USER_DB_TRAIN_ID +
                            "\n2. " + USER_DB_CAR_ID +
                            "\n3. ticket number" +
                            "\nEnter option(1-3): ");
                    option = scanner.nextInt();
                    if(option == 1){
                        System.out.println("\t" + controller.updateUser(id, USER_DB_TRAIN_ID ,scanner.next()));
                    } else if(option == 2){
                        System.out.println("\t" + controller.updateUser(id, USER_DB_CAR_ID ,scanner.next()));
                    } else if(option == 3){
                        System.out.println("\t" + controller.updateUser(id, USER_DB_TRAIN_ID ,scanner.next()));
                    } else{
                        break;
                    }

                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + ": Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
