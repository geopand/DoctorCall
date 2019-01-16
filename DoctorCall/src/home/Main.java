package home;

import DBActions.Database;
import java.sql.SQLException;
import util.DoctorCallException;
import util.LogMessageToFile;

public class Main {

    public static void main(String[] args) throws DoctorCallException, SQLException {
        LogMessageToFile logToFile = new LogMessageToFile();
        try{logToFile.initTextFile();
        }catch (Exception e){
        }


//        User user = new User(1,"admin", "password", 1);
//        System.out.println(user);
//        Database db = new Database();
//        Database.printAllUsers();
        Database.createUserInDB();
//        Database.deleteUser();
//  Database.editUser();
//        UserMenu umenu= new UserMenu();
//        umenu.usermenu();
    }

}
