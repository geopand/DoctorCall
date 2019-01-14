package menu;

import java.util.Scanner;
import javax.swing.text.html.HTML;

public class UserMenu {

    public void usermenu() {
        Scanner sc = new Scanner(System.in);
        Boolean isNumber;
        int choice=0;
            
            do{
//        System.out.println("Welcome dear user: " + username);
        System.out.println("Please choose of the actions below");
        System.out.println("[1]. View all inbox messages");
        System.out.println("[2]. View all sent messages");
        System.out.println("[3]. Delete an inbox message");
        System.out.println("[4]. Delete a  sent message");
        System.out.println("[5]. Exit the menu");
                System.out.println("------------------------");
        System.out.println("Enter a number: ");

         
        if(sc.hasNextInt()){
            choice=sc.nextInt();
            isNumber=true;
       
        switch (choice) {
            case 1:
                System.out.println("all inbox messages");
                break;
            case 2:
                System.out.println("all sent messages");
                break;
            case 3:
                System.out.println("delete an inbox messages");
                break;
            case 4:
                System.out.println("delete an sent messages");
                break;
            default:
                System.out.println("Exiting the menu...");
        }

    } else {
            System.out.println("ATTENTION! Not a valid input, please enter a number\n\n");
            isNumber=false;
            sc.nextLine();
        }           
            } while (choice!=5);

    }
}
