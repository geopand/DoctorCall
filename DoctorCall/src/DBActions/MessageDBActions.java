package DBActions;

import static DBActions.DatabaseActions.openConnection;
import entities.User;
import home.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import util.DoctorCallException;
import util.InputHelper;

public class MessageDBActions {

    public static void printAllMessages() {
        String sqlSelect = "SELECT mid,  user.username, user1.username, message, creation_date FROM message, user, user as user1 WHERE message.sender_id=user.uid AND  message.recipient_id=user1.uid";

        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                Long mid = rs.getLong(1);
                String senderUsername = rs.getString(2);
                String recipientUsername = rs.getString(3);
                String message = rs.getString(4);
                Timestamp creationDate = rs.getTimestamp(5);
                count++;
                if (count == 1) {
                    System.out.println("Message ID" + " | " + " Sender " + "\t | " + " Recipient \t" + " | " + "Message\t  " + " | " + "Created");
                    System.out.println("---------------------------------------------------------------");
                } else {
                }
                System.out.println(mid + "\t | " + senderUsername + "\t | " + recipientUsername + "  \t | " + message + "  \t | " + creationDate);
            }

        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void messageActionMenuAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nYou can do the following");
        System.out.println("\t[1]  Edit a message");
        System.out.println("\t[2]  Delete a message");
        System.out.println("\t[3]  Return");
        System.out.print("\nEnter your choice >> ");
        int input = InputHelper.validateIntInput(sc);
        switch (input) {
            case 1:
                System.out.print("Enter the message id >> ");
                int mid = InputHelper.validateIntInput(sc);
                editMessage(mid);
                System.out.println("\n\nYou are back to main menu");
                Menu.adminTextMenu();
                break;
            case 2:
                System.out.print("Enter the message id >> ");
                mid = InputHelper.validateIntInput(sc);
                deleteMessageByAdmin(mid);
                System.out.println("\n\n");
                Menu.adminTextMenu();
                break;
            case 3:
                System.out.println("\n\n");
                Menu.adminTextMenu();
                break;

            default:
                System.out.println("Choose a valid option");
        }
    }

    public static void deleteMessageByAdmin(int mid) {
        String sqlDeleteByAdmin = "UPDATE message SET message='[message deleted by admin]' where message.mid=?;";
        try (Connection conn = DatabaseActions.openConnection();
                PreparedStatement ps1 = conn.prepareStatement(sqlDeleteByAdmin);) {
            ps1.setInt(1, mid);
            int cnt = ps1.executeUpdate();
            if (cnt == 1) {
                System.out.println("Message with id:  " + mid + " successfully deleted");

            } else {
                System.out.println("ATTENTION!! MEssage with id:  " + mid + " was not deleted.\n Check the message id you entered for mistakes.");
            }
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void sendMessage(User user) {
        User senderUser = user;

    }

    public static void readUserInbox(User user) {
        User recipientUser = user;
        long recipientUid = recipientUser.getUserId();
        String sqlSelect = "SELECT mid,  user.username,  message, creation_date FROM message, user WHERE message.sender_id=user.uid AND  message.recipient_id=?";

        try (Connection conn = openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlSelect);) {
            ps.setLong(1, recipientUid);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                Long mid = rs.getLong(1);
                String senderUsername = rs.getString(2);
                String message = rs.getString(3);
                Timestamp creationDate = rs.getTimestamp(4);
                count++;
                if (count == 1) {
                    System.out.println("Message ID" + " | " + " Sender " + "\t | " + " Recipient \t" + " | " + "Message\t  " + " | " + "Created");
                    System.out.println("---------------------------------------------------------------");
                } else {
                }
                System.out.println(mid + "\t | " + senderUsername + "  \t | " + message + "  \t | " + creationDate);
            }
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }
    }

    public static void editMessage(int mid) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nYou have selected the following message");
        showMessageById(mid);
        System.out.println("Please enter the new message body: ");
        String messageBody = sc.nextLine();
        String sqlEditByAdmin = "UPDATE message SET message=? where message.mid=?;";
        try (Connection conn = DatabaseActions.openConnection();
                PreparedStatement ps1 = conn.prepareStatement(sqlEditByAdmin);) {
            ps1.setString(1, messageBody);
            ps1.setInt(2, mid);
            int cnt = ps1.executeUpdate();
            if (cnt == 1) {
                System.out.println("Message with id:  " + mid + " successfully edited");
            } else {
                System.out.println("ATTENTION!! MEssage with id:  " + mid + " was not deleted.\n Check the message id you entered for mistakes.");
            };

        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }

    }

    public static void showMessageById(int mid) {
        String sqlFetchMessage = "SELECT mid,  user.username, user1.username, message, creation_date FROM message, user, user as user1 WHERE message.sender_id=user.uid AND  message.recipient_id=user1.uid and message.mid=?";
        try (Connection conn = DatabaseActions.openConnection();
                PreparedStatement ps = conn.prepareStatement(sqlFetchMessage);) {
            ps.setInt(1, mid);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                mid = rs.getInt(1);
                String senderUsername = rs.getString(2);
                String recipientUsername = rs.getString(3);
                String message = rs.getString(4);
                Timestamp creationDate = rs.getTimestamp(5);
                count++;
                if (count == 1) {
                    System.out.println("Message ID" + " | " + " Sender " + "\t | " + " Recipient \t" + " | " + "Message\t  " + " | " + "Created");
                    System.out.println("---------------------------------------------------------------");
                } else {
                }
                System.out.println(mid + "\t | " + senderUsername + "\t | " + recipientUsername + "  \t | " + message + "  \t | " + creationDate);
            }
        } catch (SQLException ex) {
            System.out.println("Problem connecting to the database: " + ex);
        }

    }

}
