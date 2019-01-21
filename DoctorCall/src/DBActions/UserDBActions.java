package DBActions;



import home.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import util.DoctorCallException;


public class UserDBActions {
    
    public User getUser (String username, String password) throws DoctorCallException, SQLException{
        
            User user = DatabaseActions.fetchUserOrNull(username, password);
            return user;
    
    }
   
 public static void createUserInDB() throws DoctorCallException, SQLException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter username: ");
        String newUsername = sc.next().toLowerCase().trim();
//        User user = fetchUserbyUsernameOrNull(newUsername);
//        System.out.println("user.getUsername()");

        System.out.println("Please enter password: ");
        String newPassword = sc.next().toLowerCase().trim();
        System.out.println("Available roles to choose ");
        System.out.println("\t[1] Administrator\n\t[2] User(Patient/Doctor)\n\t[3] State Authority");
        System.out.println("----------------------------------------------------");
        System.out.println("Please enter role id: ");
        int roleId = sc.nextInt();

        String sqlCreateUser = "INSERT INTO user (username, password, role_id) VALUES (?,?,?);";

        try (Connection conn = DatabaseActions.openConnection();
                PreparedStatement ps1 = conn.prepareStatement(sqlCreateUser);) {

            ps1.setString(1, newUsername);
            ps1.setString(2, newPassword);
            ps1.setLong(3, roleId);

            int cnt = ps1.executeUpdate();
            System.out.println("User " + newUsername + " successfully created");

        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);

        }
    }

//    private static User createUserOb(ResultSet rs) throws SQLException, DoctorCallException {
//        User user = new User(rs.getLong("uid"), rs.getString("username"), rs.getString("password"), rs.getLong("role_id"));
//        return user;
//    }
    
public static void editUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("This is the list of users.");
        DatabaseActions.printAllUsers();
        System.out.println("\n");
        System.out.println("Which user do you want to edit?");
        System.out.print("Enter user id here: ");
        int userId = sc.nextInt();
        DatabaseActions.showUserById(userId);

        System.out.println("Please enter a new username: ");
        String newUsername = sc.next().toLowerCase().trim();
        System.out.println("Please enter a new password: ");
        String newPassword = sc.next().toLowerCase().trim();
        System.out.println("Available roles to choose ");
        System.out.println("\t[1] Administrator\n\t[2] User(Patient/Doctor)\n\t[3] State Authority");
        System.out.println("----------------------------------------------------");
        System.out.print("Please enter role id: ");
        int roleId = sc.nextInt();

        String sqlEditUser = "UPDATE user SET username=?, password=?, role_id=? where user.uid=?;";
        try (Connection conn = DatabaseActions.openConnection();
                        PreparedStatement ps1 = conn.prepareStatement(sqlEditUser);){
            ps1.setString(1, newUsername);
            ps1.setString(2, newPassword);
            ps1.setInt(3, roleId);
            ps1.setInt(4, userId);

            int cnt = ps1.executeUpdate();
            if (cnt == 1) {
                System.out.println("User " + newUsername + " successfully updated");
//            System.out.println("These are the new details");
//            DatabaseActions.showUserById(userId);
            } else {System.out.println("User " + newUsername + " was not updated");
            };
           
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }
    
    

    
    
    
}
