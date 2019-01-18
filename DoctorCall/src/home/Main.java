package home;

import java.sql.SQLException;
import util.DoctorCallException;

public class Main {

    public static void main(String[] args) throws DoctorCallException, SQLException {
        
        //Creating the text file that will be used as a central log not visible
        //directly from the programm serving as a single source of truth.
//        LogMessageToFile logToFile = new LogMessageToFile();
//        try{
//            logToFile.initTextFile();
//        }catch (Exception e){
//        }
        
        //Starts the Login Screen
        LoginScreen.login();
        
        


//        User user = new User(1,"admin", "password", 1);
//        System.out.println(user);
//        DatabaseActions db = new DatabaseActions();
//        DatabaseActions.printAllUsers();
//        DatabaseActions.createUserInDB();
//        DatabaseActions.deleteUser();
//          DatabaseActions.editUser();
//        UserMenu umenu= new UserMenu();
//        umenu.usermenu();
    }

}
