package home;

import java.sql.SQLException;
import util.DoctorCallException;
import util.LogMessageToFile;

public class Main {

    public static void main(String[] args) throws DoctorCallException, SQLException {
        
        //Creating the text file that will be used as a central log not visible
        //directly from the programm serving as a single source of truth.
        LogMessageToFile logToFile = new LogMessageToFile();
        try{
            logToFile.initTextFile();
        }catch (Exception e){
        }
        

//Starts the Login Screen
        LoginScreen.login();
        
        


    }

}
