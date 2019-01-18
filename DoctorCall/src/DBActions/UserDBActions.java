package DBActions;


import home.User;
import java.sql.SQLException;
import util.DoctorCallException;


public class UserDBActions {
    
    public User getUser (String username, String password) throws DoctorCallException, SQLException{
        
            User user = DatabaseActions.fetchUserOrNull(username, password);
            return user;
    
    }
    
    

    
    
    
}
