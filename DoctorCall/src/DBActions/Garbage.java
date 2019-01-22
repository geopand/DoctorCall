/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBActions;

import static DBActions.DatabaseActions.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Georg
 */
public class Garbage {
    
public static ArrayList<Long> getArrayListUserIds() {
            ArrayList<Long> al = new ArrayList<Long>();    
        String sqlSelect = "SELECT uidFROM user, role WHERE user.role_id = role.rid  AND deleted=0 order by uid;";       
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
    
    
    
 /*   
    public static void editUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("This is the list of users.");
        DatabaseActions.printAllUsers();
        System.out.println("\n");
        System.out.println("Which user do you want to edit?");
        System.out.println("Enter user id here: ");
        int userId = sc.nextInt();
        DatabaseActions.showUserById(userId);

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
            if (cnt == 1) {
                System.out.println("User " + newUsername + " successfully updated");
//            System.out.println("These are the new details");
//            DatabaseActions.showUserById(userId);
            } else {
            };
            sc.close();
            ps1.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }
   */ 
    
}
