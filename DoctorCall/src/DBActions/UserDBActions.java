package DBActions;

import entities.User;
import home.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import util.DoctorCallException;
import util.InputHelper;

public class UserDBActions {

    public User getUser(String username, String password) throws DoctorCallException, SQLException {

        User user = DatabaseActions.fetchUserOrNull(username, password);
        return user;
    }

    public static void createUserInDB() throws DoctorCallException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter username: ");
        String newUsername = sc.next().toLowerCase().trim();

        while (DatabaseActions.usernameExists(newUsername) == true) {
            System.out.println("This username is already taken!");
            createUserInDB();
        }

        System.out.print("Please enter password: ");
        String newPassword = sc.next().toLowerCase().trim();
        System.out.println("\nAvailable roles to choose ");
        System.out.println("\t[1] Administrator\n\t[2] User(Patient/Doctor)\n\t[3] State Authority");
        System.out.println("----------------------------------------------------");
        System.out.print("Please enter role id: ");
        long roleId = InputHelper.validateLongInput(sc);
        boolean validId = DatabaseActions.roleIdExists(roleId);
        if (validId) {

            String sqlCreateUser = "INSERT INTO user (username, password, role_id) VALUES (?,?,?);";
            try (Connection conn = DatabaseActions.openConnection();
                    PreparedStatement ps1 = conn.prepareStatement(sqlCreateUser);) {
                ps1.setString(1, newUsername);
                ps1.setString(2, newPassword);
                ps1.setLong(3, roleId);

                ps1.executeUpdate();
                System.out.println("User " + newUsername + " successfully created");
            } catch (SQLException ex) {
                System.out.println("Problem connecting to the database: " + ex);
            }
        } else {
            System.out.println("[" + roleId + "]" + " is not a valid role option");
            createUserInDB();
        }
    }
    
 

    public static void deleteUser() {
        int count=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the list of users.");
        DatabaseActions.printAllUsers();
        ArrayList<Long> al = DatabaseActions.getArrayListUserIds();
        System.out.println();
        System.out.println("To choose a user for deletion enter the user ID here: ");
        Long userid = sc.nextLong();
        while (!al.contains(userid)) {
            System.out.println("User does not exist!");
            deleteUser();
        }

        System.out.println("You have selected the user with id= " + userid);
        System.out.println("Are you sure you want to delete the user? Press y/n :");
        String answer = sc.next().toLowerCase();
//          String answer = InputHelper.validateStringInput(sc, "Press y/n :");
        if ("y".equals(answer)) {
            String sqlDeleteUser = "UPDATE  user SET deleted=1 WHERE uid=?";
            try (Connection conn = DatabaseActions.openConnection();
                    PreparedStatement ps1 = conn.prepareStatement(sqlDeleteUser);) {
                ps1.setLong(1, userid);

                int cnt = ps1.executeUpdate();

                if (cnt != 0) {
                    System.out.println("User with user ID: " + userid + " successfully deleted");
                } else {
                    System.out.println("User not deleted");
                }

            } catch (SQLException ex) {
                System.out.println("Problem connecting to the database: " + ex);
            }
        } else {
            System.out.println(" Exiting the programm...");
            }
    }

    public static void editUser() throws DoctorCallException, SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("This is the list of users.");
        DatabaseActions.printAllUsers();
        System.out.println("\n");
        System.out.println("Which user do you want to edit?");
        System.out.print("Enter user id here: ");
        int userId = InputHelper.validateIntInput(sc);
        DatabaseActions.showUserById(userId);

        System.out.println("Please enter a new username: ");
        String newUsername = sc.next().toLowerCase().trim();


        System.out.println("Please enter a new password: ");
        String newPassword = sc.next().toLowerCase().trim();
        System.out.println("Available roles to choose ");
        System.out.println("\t[1] Administrator\n\t[2] User(Patient/Doctor)\n\t[3] State Authority");
        System.out.println("----------------------------------------------------");
        System.out.print("Please enter role id: ");
        int roleId = InputHelper.validateIntInput(sc);

        String sqlEditUser = "UPDATE user SET username=?, password=?, role_id=? where user.uid=?;";
        try (Connection conn = DatabaseActions.openConnection();
                PreparedStatement ps1 = conn.prepareStatement(sqlEditUser);) {
            ps1.setString(1, newUsername);
            ps1.setString(2, newPassword);
            ps1.setInt(3, roleId);
            ps1.setInt(4, userId);

            int cnt = ps1.executeUpdate();
            if (cnt == 1) {
                System.out.println("User " + newUsername + " successfully updated");
                System.out.println("These are the new details");
                DatabaseActions.showUserById(userId);
            } else {
                System.out.println("ATTENTION!! User " + newUsername + " was not updated.\n Check the user id you entered for mistakes.");
            };

        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

}
