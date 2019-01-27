package home;

import DBActions.DatabaseActions;
import DBActions.UserDBActions;
import home.LoginScreen;
import entities.User;
import java.sql.SQLException;
import java.util.Scanner;
import util.DoctorCallException;
import util.Validation;

public class Menu {
    User user;

//Constructor
    public Menu(User user) {
        this.user = user;
    }

    public void showMenu() throws DoctorCallException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome dear " + user.getUsername());

        if (user.getRoleId() == 1) {
            System.out.println("--- ADMIN MENU ---");
            System.out.println("[1] View all users");
            System.out.println("[2] Create new user");
            System.out.println("[3] Edit existing user");
            System.out.println("[4] Delete a user");
            System.out.println("______________________________");
            System.out.println("---Admin's Messages---");
            System.out.println("[5] View all inbox messages");
            System.out.println("[6] View all sent messages");
            System.out.println("[7] Delete an inbox message");
            System.out.println("[8] Delete a  sent message");
            System.out.println("______________________________");
            System.out.println("---User's Messages---");
            System.out.println("[9]  View messages from all users");
            System.out.println("[10]  Edit a user message");
            System.out.println("[11] Delete a user message");
            System.out.println("[12] Log out");
//        System.out.print("\nEnter your choice >> ");

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = Validation.validateIntInput(sc);
                switch (choice) {
                    case 1:
                        System.out.println("These are of the people using the application\n");
                        DatabaseActions.printAllUsers();
                        break;
                    case 2:
                        UserDBActions.createUserInDB();
                        System.out.println();
                        showMenu();
                        break;
                    case 3:
                        UserDBActions.editUser();
                        showMenu();
                        break;
                    case 4:
                        UserDBActions.deleteUser();
                        showMenu();
                        break;
                    case 5:
                        System.out.println("View all sent messages");
                        break;
                    case 6:
                        System.out.println("Delete an inbox message");
                        break;
                    case 7:
                        System.out.println("Delete a  sent message");
                        break;
                    case 8:
                        System.out.println("View messages from all users");
                        break;
                    case 9:
                        System.out.println(" Edit a user's message");
                        break;
                    case 10:
                        System.out.println("Delete a user message");
                        break;
                    case 11:
                        System.out.println();
                        LoginScreen.login();
                        break;
                    case 12:
                        System.out.println();
                        LoginScreen.login();
                        break;
                    default:
                        System.out.println("Please use the options above...");
                        break;
                }//switch, exit
            } //while loop, exit
        }//if (choose role), exit

        else if (user.getRoleId() == 2) {
            System.out.println("\n---USER MENU---");
            System.out.println("What do you want to do?");
            System.out.println("[1]. View all inbox messages");
            System.out.println("[2]. View all sent messages");
            System.out.println("[3]. Delete an inbox message");
            System.out.println("[4]. Delete a  sent message");
            System.out.println("[5]. Log out");
            System.out.println("------------------------");

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = Validation.validateIntInput(sc);
                switch (choice) {
                    case 1:
                        System.out.println("all inbox messages");
                        break;
                    case 2:
                        System.out.println("all sent messages");
                        break;
                    case 3:
                        System.out.println("delete an inbox messages");
                        break;
                    case 4:
                        System.out.println("delete an sent messages");
                        break;
                    case 5:
                        System.out.println();
                        LoginScreen.login();
                        break;
                    default:
                        System.out.println("Please use the options above...\n");
                }

            } //while exit
        } //second if to choose role exit
        else if (user.getRoleId() == 3) {
            System.out.println("--- State Authority  MENU ---");
            System.out.println("[1] View all users");
            System.out.println("[2] View messages from all users");
            System.out.println("______________________________");
            System.out.println("---State authority representative's Messages---");
            System.out.println("[3] View all inbox messages");
            System.out.println("[4] View all sent messages");
            System.out.println("[5] Delete an inbox message");
            System.out.println("[6] Delete a  sent message");
            System.out.println("[7] Log out");

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = Validation.validateIntInput(sc);

                switch (choice) {
                    case 1:
                        System.out.println("all inbox messages");
                        break;
                    case 2:
                        System.out.println("all sent messages");
                        break;
                    case 3:
                        System.out.println("delete an inbox messages");
                        break;
                    case 4:
                        System.out.println("delete an sent messages");
                        break;
                    case 5:
                        System.out.println("all inbox messages");
                        break;
                    case 6:
                        System.out.println("all sent messages");
                        break;
                    case 7:
                        System.out.println();
                        LoginScreen.login();
                        break;
                    default:
                        System.out.println("Please use the options above...\n");
                }

            } //while loop exit
        }// third if to choose user role exit
    }//menu method exit;
}  //class exit

