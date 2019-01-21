package menu;

import DBActions.DatabaseActions;
import home.LoginScreen;
import home.User;
import java.sql.SQLException;
import java.util.Scanner;
import util.DoctorCallException;

public class Menu {

    User user;

    //Constructor
    public Menu(User user) {
        this.user = user;
    }

    //method
    public void showMenu() throws DoctorCallException, SQLException {
        Scanner sc = new Scanner(System.in);
        Boolean isNumber = true;
        int choice = 0;
        System.out.println("\nWelcome dear " + user.getUsername());

        if (user.getRoleId() == 1) {
            System.out.println("--- ADMIN MENU ---");
            System.out.println("[1] View all users");
            System.out.println("[2] Create new user");
            System.out.println("[3] Edit existing user");
            System.out.println("______________________________");
            System.out.println("---Admin's Messages---");
            System.out.println("[4] View all inbox messages");
            System.out.println("[5] View all sent messages");
            System.out.println("[6] Delete an inbox message");
            System.out.println("[7] Delete a  sent message");
            System.out.println("______________________________");
            System.out.println("---User's Messages---");
            System.out.println("[8]  View messages from all users");
            System.out.println("[9]  Edit a user message");
            System.out.println("[10] Delete a user message");
            System.out.println("[11] Log out");
//        System.out.print("\nEnter your choice >> ");

            while (true) {
                System.out.print("\nEnter your choice >> ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
//                    isNumber = true;

                    switch (choice) {
                        case 1:
                            System.out.println("These are of the people using the application\n");
                            DatabaseActions.printAllUsers();
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
                            System.out.println("delete an inbox messages");
                            break;
                        case 8:
                            System.out.println("delete an sent messages");
                            break;
                        case 9:
                            System.out.println("all sent messages");
                            break;
                        case 10:
                            System.out.println("delete an inbox messages");
                            break;
                        case 11:
                            System.out.println();
                            LoginScreen.login();
                            break;
                        default:
                            System.out.println("Please use the options above...");
                            break;
                    }
                } else {
                    isNumber = false;
                    if (isNumber == false) {
                        sc.next();
                    }
                    System.out.println("ATTENTION! Not a valid input, please enter a number\n");

                }
            } //while loop exit
        }//first if exit
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
                System.out.print("Enter your choice>>: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    isNumber = true;

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
                } else {
                    isNumber = false;
                    if (isNumber == false) {
                        sc.next();
                    }
                    System.out.println("ATTENTION! Not a valid input, please enter a number\n");
                }
            }
        }//else if exit
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
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
//                    isNumber = true;

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
                } else {
                    isNumber = false;
                    if (isNumber == false) {
                        sc.next();
                    }
                    System.out.println("ATTENTION! Not a valid input, please enter a number\n");
                }
            } //while loop exit
        }//first if exit

    }//method exit
}//class exit

