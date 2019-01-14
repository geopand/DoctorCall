package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {

    static String user = "admin";
    static String pass = "admin";
    static String link = "jdbc:mysql://localhost:3306/doctorcall?serverTimezone=UTC&characterEncoding=utf-8&autoReconnect=true";
//     static String options = "?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
    static String urldb = link;

    public static void printAllUsers() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urldb, user, pass);
            String sqlSelect = "SELECT uid, username, password, role.role FROM user, role WHERE user.role_id = role.rid  AND deleted=0 order by uid;";
            PreparedStatement ps1 = conn.prepareStatement(sqlSelect);
            ResultSet rs1 = ps1.executeQuery();
            int count = 0;
            while (rs1.next()) {
                Long id = rs1.getLong(1);
                String username = rs1.getString(2);
                String password = rs1.getString(3);
                String role = rs1.getString(4);
                count++;
                if (count == 1) {
                    System.out.println("User ID" + " | " + " Username " + "\t | " + " Password \t" + " | " + " Role ");
                    System.out.println("---------------------------------------------------------------");
                } else {
                }
                System.out.println(id + "\t | " + username + "\t | " + password + "  \t | " + role);
            }
            ps1.close();
            conn.close();;
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void showUserById(int userId) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urldb, user, pass);
            String sqlSelect = "SELECT uid, username, password, role.role FROM user, role WHERE user.role_id=role.rid and user.uid=?  AND deleted=0 order by uid;";
            PreparedStatement ps1 = conn.prepareStatement(sqlSelect);
            ps1.setInt(1, userId);
            ResultSet rs1 = ps1.executeQuery();
//            int count = 0;
            while (rs1.next()) {
                Long id = rs1.getLong(1);
                String username = rs1.getString(2);
                String password = rs1.getString(3);
                String role = rs1.getString(4);
                System.out.println("You have chosen user: ");
                System.out.println("\tUsername: "+username);
                System.out.println("\tPassword: "+password);
                System.out.println("\tRole: "+ role);
//                count++;
//                if (count == 1) {
//                    System.out.println("User ID" + " | " + " Username " + "\t | " + " Password \t" + " | " + " Role ");
//                    System.out.println("---------------------------------------------------------------");
//                } else {
//                }
//                System.out.println(id + "\t | " + username + "\t | " + password + "  \t | " + role);
            }
            ps1.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter username: ");
        String newUsername = sc.next().toLowerCase().trim();
        System.out.println("Please enter password: ");
        String newPassword = sc.next().toLowerCase().trim();
        System.out.println("Available roles to choose ");
        System.out.println("\t[1] Administrator\n\t[2] User(Patient/Doctor)\n\t[3] State Authority");
        System.out.println("----------------------------------------------------");
        System.out.println("Please enter role id: ");
        int roleId = sc.nextInt();

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urldb, user, pass);
            String sqlCreateUser = "INSERT INTO user (username, password, role_id) VALUES (?,?,?);";
            PreparedStatement ps1 = conn.prepareStatement(sqlCreateUser);
            ps1.setString(1, newUsername);
            ps1.setString(2, newPassword);
            ps1.setInt(3, roleId);

            int cnt = ps1.executeUpdate();
            System.out.println("User " + newUsername + " successfully created");

            sc.close();
            ps1.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);

        }}
        
    
    
public static void editUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("This is the list of users.");
        Database.printAllUsers();
        System.out.println("\n");
        System.out.println("Which user do you want to edit?");
        System.out.println("Enter user id here: ");
        int userId = sc.nextInt();
        Database.showUserById(userId);
                
        System.out.println("Please enter a new username: ");
        String newUsername = sc.next().toLowerCase().trim();
        System.out.println("Please enter a new password: ");
        String newPassword = sc.next().toLowerCase().trim();
        System.out.println("Available roles to choose ");
        System.out.println("\t[1] Administrator\n\t[2] User(Patient/Doctor)\n\t[3] State Authority");
        System.out.println("----------------------------------------------------");
        System.out.println("Please enter role id: ");
        int roleId = sc.nextInt();
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(urldb, user, pass);
            String sqlEditUser = "UPDATE user SET username=?, password=?, role_id=? where user.uid=?;";
            PreparedStatement ps1 = conn.prepareStatement(sqlEditUser);
            ps1.setString(1, newUsername);
            ps1.setString(2, newPassword);
            ps1.setInt(3, roleId);
            ps1.setInt(4, userId);

            int cnt = ps1.executeUpdate();
            if (cnt==1){
            System.out.println("User " + newUsername + " successfully updated");
//            System.out.println("These are the new details");
//            Database.showUserById(userId);
            } else{};
            sc.close();
            ps1.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }



public static void authenticateUser(){
    Connection conn = null;

}



//    private Connection conn = null;
//    private Statement stmt = null;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet rs = null;
//    public int updateDataBase(String query) throws Exception {
//        try {
//            // Setup the connection with the DB
//            conn = DriverManager.getConnection(urldb, user, password);
//            // Statements allow to issue SQL queries to the database
//            stmt = conn.createStatement();
//            int i = stmt.executeUpdate(query);
//            return i;
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.close();
//        }
//    }
//    public ArrayList readDataBase(String query, int columns) throws Exception {
//        try {
//            // Setup the connection with the DB
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/afdemp_java_1?useSSL=false", "dbuser", "1234");
//            // Statements allow to issue SQL queries to the database
//            stmt = conn.createStatement();
//            // Result set get the result of the SQL query
//            rs = stmt.executeQuery(query);
//
//            //    resultSet.last();
//            //    System.out.println(resultSet.getRow());
//            ArrayList al = new ArrayList();
//            while (rs.next()) {
//                if (columns == 1) {
//                    al.add(rs.getString(1));
//                } else {
//                    ArrayList al2 = new ArrayList();
//                    for (int i = 1; i <= columns; i++) {
//                        al2.add(rs.getString(i));
//                    }
//                    al.add(al2);
//                }
//
//            }
//            return al;
//
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.close();
//        }
//    }
//
//    private void close() {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (Exception e) {
//        }
//    }

    public static void deleteUser() {
//        String answer=null;

        Scanner sc = new Scanner(System.in);
        System.out.println("This is the list of users.");
        Database.printAllUsers();
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
                    System.out.println("User ID " + " | " + " Username " + "\t | " + " Password " + "\t | "+" Role ");
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
