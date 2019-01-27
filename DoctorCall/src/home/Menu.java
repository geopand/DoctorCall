package home;

import DBActions.DatabaseActions;
import DBActions.MessageDBActions;
import DBActions.UserDBActions;
import entities.User;
import java.sql.SQLException;
import java.util.Scanner;
import util.DoctorCallException;
import util.InputHelper;

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
            adminTextMenu();

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = InputHelper.validateIntInput(sc);
                switch (choice) {
                    case 1:
                        System.out.println("These are the people using the application\n");
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
                        MessageDBActions.printAllMessages();
                        MessageDBActions.messageActionMenuAdmin();
                        break;
                    case 10:
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
            System.out.println("[1]. Send a message");
            System.out.println("[1]. Inbox folder");
            System.out.println("[3]. Sent folder");
            System.out.println("[4]. Log out");
            System.out.println("------------------------");

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = InputHelper.validateIntInput(sc);
                switch (choice) {
                    case 1:

                        break;
                    case 2: MessageDBActions.readUserInbox(user);
                    showMenu();
                        break;
                    case 3:

                        break;
                    case 4:
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
            System.out.println("What do you want to do?");
            System.out.println("[1]. Send a message");
            System.out.println("[1]. Inbox folder");
            System.out.println("[3]. Sent folder");
            System.out.println("[4]. Log out");
            System.out.println("______________________________");
            System.out.println("[5] View all users in the system");
            System.out.println("[6] View messages from all users");
            System.out.println("[7] Log out");

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = InputHelper.validateIntInput(sc);

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

    public static void adminTextMenu() {
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
        System.out.println("[9]  View/Edit/Delete messages from all users");
        System.out.println("[10] Log out");
    }
}  //class exit

