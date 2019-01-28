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
        System.out.println("\nWelcome dear " + user.getUsername() + "!");

//Depending on the user role the app shows a different Menu: 1=admin, 2=plain user, 3=stateauthority
        if (user.getRoleId() == 1) {

//Each text menu is added as a void method at the end of the class for better UX experience
            adminTextMenu();

            while (true) {
                System.out.print("\nEnter your choice >> ");
                //this validates the user input accepting only integer type
                int choice = InputHelper.validateIntInput(sc);
                switch (choice) {
                    case 1:
                        System.out.println("These are the people using the application\n");
                        DatabaseActions.printAllUsersPasswordsRoles();
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
                        MessageDBActions ma = new MessageDBActions();
                        ma.sendMessage(user);
                        showMenu();
                        break;
                    case 6:
                        MessageDBActions.readUserInbox(user);
                        MessageDBActions.inboxMessageActionMenuUser(user);
                        break;
                    case 7:
                        MessageDBActions.readUserSentFolder(user);
                        MessageDBActions.sentMessageActionMenuUser(user);
                        break;
                    case 8:                        
                        MessageDBActions.printAllMessages();
                        MessageDBActions.messageActionMenuAdmin();
                        break;
                    case 9:
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
            userTextMenu();

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = InputHelper.validateIntInput(sc);
                switch (choice) {
                    case 1:
                        MessageDBActions ma = new MessageDBActions();
                        ma.sendMessage(user);
                        showMenu();
                        break;
                    case 2:
                        MessageDBActions.readUserInbox(user);
                        MessageDBActions.inboxMessageActionMenuUser(user);
//                    userTextMenu();
                        break;
                    case 3:
                        MessageDBActions.readUserSentFolder(user);
                        MessageDBActions.sentMessageActionMenuUser(user);
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
            stateAuthorityMenu();

            while (true) {
                System.out.print("\nEnter your choice >> ");
                int choice = InputHelper.validateIntInput(sc);

                switch (choice) {
                    case 1:
                        MessageDBActions ma = new MessageDBActions();
                        ma.sendMessage(user);
                        showMenu();
                        break;
                    case 2:
                        MessageDBActions.readUserInbox(user);
                        MessageDBActions.inboxMessageActionMenuUser(user);
                        break;
                    case 3:
                        MessageDBActions.readUserSentFolder(user);
                        MessageDBActions.sentMessageActionMenuUser(user);
                        break;
                    case 4:
                        System.out.println("These are the people using the application\n");
                        DatabaseActions.printAllUsers();
                        break;
                    case 5:
                        System.out.println("These are all the messages in the db");
                        MessageDBActions.printAllMessages();
                        break;
                    case 6:
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
        System.out.println("[5] Send a message");
        System.out.println("[6] Inbox folder");
        System.out.println("[7] Sent folder");
        
        System.out.println("______________________________");
        System.out.println("---User's Messages---");
        System.out.println("[8]  View/Edit/Delete messages from all users");
        System.out.println("[9] Log out");
    }

    public static void userTextMenu() {
        System.out.println("\n---USER MENU---");
        System.out.println("What do you want to do?");
        System.out.println("[1] Send a message");
        System.out.println("[2] Inbox folder");
        System.out.println("[3] Sent folder");
        System.out.println("[4] Log out");
    }

    public static void stateAuthorityMenu() {
        System.out.println("--- STATE AUTHORITY MENU ---");
        System.out.println("[1] Send a message");
        System.out.println("[2] Inbox folder");
        System.out.println("[3] Sent folder");
        System.out.println("______________________________");
        System.out.println("[4] View all users in the system");
        System.out.println("[5] View messages from all users");
        System.out.println("[6] Log out");
    }

}  //class exit

