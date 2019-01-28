package home;

import entities.User;
import DBActions.DatabaseActions;
import DBActions.UserDBActions;
import java.sql.SQLException;
import java.util.Scanner;
import util.DoctorCallException;

public class LoginScreen {

    static int count = 0;

    public static void login() throws DoctorCallException, SQLException {
        Scanner sc = new Scanner(System.in);

//the app title is only shown one time
        if (LoginScreen.count == 0) {
            System.out.println("  _____             _              _____      _ _ \n"
                    + " |  __ \\           | |            / ____|    | | |\n"
                    + " | |  | | ___   ___| |_ ___  _ __| |     __ _| | |\n"
                    + " | |  | |/ _ \\ / __| __/ _ \\| '__| |    / _` | | |\n"
                    + " | |__| | (_) | (__| || (_) | |  | |___| (_| | | |\n"
                    + " |_____/ \\___/ \\___|\\__\\___/|_|   \\_____\\__,_|_|_|\n"
                    + "                                                  \n"
                    + "                                                  ");
            System.out.println("The best point of contact between your doctor and you !");
            System.out.println("-------------------------------------------------------\n");
            count++;
        }

//Here the user enter his credentials
        System.out.println("Please provide your credentials or press [q] to quit the application");
        System.out.print("\t  Enter your username:  ");
        String username = sc.next().toLowerCase().trim();
        if (username.equals("q".toLowerCase())) {
            System.out.println("\nThank you for using our apllication!");

            System.exit(0);
        }
        System.out.print("\t  Enter your password:  ");
        String password = sc.next().toLowerCase().trim();
        if (password.equals("q".toLowerCase())) {
            System.out.println("\nThank you for using our apllication!");
            System.exit(0);
        }

        
//Authenticating User and showing the right menu if user exists
        UserDBActions userDBActions = new UserDBActions();
        User user = userDBActions.getUser(username, password);
        if (user != null) {
            Menu m = new Menu(user);
            m.showMenu();
        } else {
            System.out.println("ATTENTION! Wrong username or password\n\n");
            LoginScreen.login();
        }

    }

}
