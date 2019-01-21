package DBActions;

import home.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import util.DoctorCallException;

public class DatabaseActions {

    static String user = "admin";
    static String pass = "admin";
    static String urldb = "jdbc:mysql://localhost:3306/doctorcall?serverTimezone=UTC&characterEncoding=utf-8&autoReconnect=true";
//  static String options = "?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";

//grabs username and password and returns a user (if exists in DB else returns null)
    public static User fetchUserOrNull(String username, String password) throws DoctorCallException, SQLException {
        String sqlFetchUser = "SELECT uid, username, password, role_id FROM user WHERE username=? and password=?;";

        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlFetchUser);) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getLong(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRoleId(rs.getLong(4));
                return user;
//                return createUserOb(rs);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new DoctorCallException(e.getMessage(), e);
        }

    }

    public static void printAllUsers() {
        String sqlSelect = "SELECT uid, username, password, role.role FROM user, role WHERE user.role_id = role.rid  AND deleted=0 order by uid;";

        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                Long id = rs.getLong(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String role = rs.getString(4);
                count++;
                if (count == 1) {
                    System.out.println("User ID" + " | " + " Username " + "\t | " + " Password \t" + " | " + " Role ");
                    System.out.println("---------------------------------------------------------------");
                } else {
                }
                System.out.println(id + "\t | " + username + "\t | " + password + "  \t | " + role);
            }

        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void showUserById(int userId) {
        String sqlSelect = "SELECT uid, username, password, role.role FROM user, role WHERE user.role_id=role.rid and user.uid=?  AND deleted=0 order by uid;";
        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
            ps.setInt(1, userId);
            ResultSet rs1 = ps.executeQuery();
//            int count = 0;
            while (rs1.next()) {
                Long id = rs1.getLong(1);
                String username = rs1.getString(2);
                String password = rs1.getString(3);
                String role = rs1.getString(4);
                System.out.println("You have chosen user: ");
                System.out.println("\tUsername: " + username);
                System.out.println("\tPassword: " + password);
                System.out.println("\tRole: " + role);
//                count++;
//                if (count == 1) {
//                    System.out.println("User ID" + " | " + " Username " + "\t | " + " Password \t" + " | " + " Role ");
//                    System.out.println("---------------------------------------------------------------");
//                } else {
//                }
//                System.out.println(id + "\t | " + username + "\t | " + password + "  \t | " + role);
            }

        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    


 
    public static void authenticateUser() {
        Connection conn = null;

    }

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(urldb, user, pass);
    }

    public static void deleteUser() {

        Scanner sc = new Scanner(System.in);
        System.out.println("This is the list of users.");
        DatabaseActions.printAllUsers();
        System.out.println();
        System.out.println("To choose a user for deletion enter the user ID here: ");
        int userid = sc.nextInt();
        System.out.println("You have selected the user with id= " + userid);
        System.out.println("Are you sure you want to delete the user? Press y/n");
        String answer = sc.next();

        if ("y".equals(answer)) {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(urldb, user, pass);
                String sqlCreateUser = "UPDATE  user SET deleted=1 WHERE uid=?";
                PreparedStatement ps1 = conn.prepareStatement(sqlCreateUser);
                ps1.setInt(1, userid);

                int cnt = ps1.executeUpdate();
                System.out.println("User with user ID: " + userid + " successfully deleted");

                sc.close();
                ps1.close();
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Problem connecting to the database: " + ex);
            }
        } else {
            System.out.println(" Exiting the programm...");
        };

    }

    public static void superPrintAllMessages() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urldb, user, pass);
            String sqlSelectAllMsgs = "SELECT  ";
            PreparedStatement ps1 = conn.prepareStatement(sqlSelectAllMsgs);
            ResultSet rs1 = ps1.executeQuery();
            int count = 0;
            while (rs1.next()) {
                Long id = rs1.getLong(1);
                String username = rs1.getString(2);
                String password = rs1.getString(3);
                String role = rs1.getString(4);
                count++;
                if (count == 1) {
                    System.out.println("User ID " + " | " + " Username " + "\t | " + " Password " + "\t | " + " Role ");
                    System.out.println("---------------------------------------------------------------");
                } else {
                }
                System.out.println(id + "\t | " + username + "\t | " + password + "\t | " + role);
            }
            ps1.close();
            conn.close();;
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void printAllInbox() {

    }

    public static void printAllSent() {

    }

}
