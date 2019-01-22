package DBActions;

import entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public static boolean usernameExists(String username) throws DoctorCallException, SQLException {
        String sqlFetchUser = "SELECT uid, username, password, role_id FROM user WHERE username=?;";
        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlFetchUser);) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
//                return createUserOb(rs);
            } else {
                return false;
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

    public static ArrayList<Long> getArrayListUserIds() {
            ArrayList<Long> al = new ArrayList<Long>();    
        String sqlSelect = "SELECT uid FROM user, role WHERE user.role_id = role.rid  AND deleted=0 order by uid;";       
        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                Long id = rs.getLong(1);
               al.add(rs.getLong(1));}
        }
        catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }return al;
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

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(urldb, user, pass);
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
