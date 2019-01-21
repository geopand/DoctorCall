package home;

import DBActions.DatabaseActions;
import DBActions.UserDBActions;
import java.sql.SQLException;
import java.util.Scanner;
import menu.Menu;
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
            System.out.println("The best point of contact between your doctor and you");
            System.out.println("---------------------------");
            count++;
        }

        System.out.println("Please provide your credentials or press [q] to quit the application");
        System.out.print("\tEnter your username:  ");
        String username = sc.next().toLowerCase().trim();
        if (username.equals("q".toLowerCase())) {
            System.out.println("\nThank you for using our apllication!");

            System.exit(0);
        }
        System.out.print("\tEnter your password:  ");
        String password = sc.next().toLowerCase().trim();
        if (password.equals("q".toLowerCase())) {
            System.out.println("\nThank you for using our apllication!");
            System.exit(0);
        }

        
//Authenticating User and showing the right menu
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
