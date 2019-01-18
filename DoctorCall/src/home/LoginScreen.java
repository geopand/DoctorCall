
package home;

import DBActions.DatabaseActions;
import DBActions.UserDBActions;
import dao.UserDAO;
import java.sql.SQLException;
import java.util.Scanner;
import menu.Menu;
import util.DoctorCallException;


public class LoginScreen {
    
    public static void login() throws DoctorCallException, SQLException{
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Welcome to Doctor Call: The best point of contact between your doctor and you");
        System.out.println("---------------------------");
        System.out.println("Please provide your credentials");
        System.out.print("Enter your username:  ");
        String username = sc.next().toLowerCase().trim();
        System.out.print("Enter your password:  ");
        String password = sc.next().toLowerCase().trim();
        
        
        UserDBActions userDBActions = new UserDBActions();
        User user = userDBActions.getUser(username, password);
        if (user!=null){
            Menu menu = new Menu(user);
            menu.menu();
        }else {
            System.out.println("Wrong username or password");
            LoginScreen.login();}
       
     
    
    
    }
    
}
