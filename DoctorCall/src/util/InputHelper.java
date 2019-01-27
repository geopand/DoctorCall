package util;

import java.util.Scanner;

/**
 *
 * @author Georg
 */
public class InputHelper {

    public static int validateIntInput(Scanner sc) {
        
        int i = 0;
        boolean correctInput = false;
        while (correctInput == false) {
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                System.out.print("\nEnter your choice >> ");
                sc.next();
            } else {
                i = sc.nextInt();
                correctInput = true;
            }
        }
        return i;
    }

    public static long validateLongInput(Scanner sc) {
        long i = 0;
        boolean correctInput = false;
        while (correctInput == false) {
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number");
                System.out.print("\nEnter your choice >> ");
                sc.next();
            } else {
                i = sc.nextInt();
                correctInput = true;
            }
        }
        return i;
    }

    public static String validateStringInput(Scanner sc) {
        String str = null;
        boolean correctInput = false;
        while (correctInput == false) {
            if (!sc.hasNext()) {
                System.out.println("Please enter a valid input");
                System.out.print("\nEnter your choice >> ");
                sc.nextLine();
            } else {
                str = sc.nextLine().toLowerCase().trim();
                correctInput = true;
            }
        }
        return str;
    }
    
    
    public static String validateStringInput(Scanner sc, String prompt) {
        String str =null;
        boolean check =false;
        do{
           if (!sc.hasNext()) {
                System.out.println("Please enter a valid input");
                System.out.print("\n"+prompt);
                sc.nextLine();
            } else {
               System.out.println("in else statement");
                 str = sc.nextLine().toLowerCase().trim();
                 return str;
                 
            }}while (check==false);
         return str;
    }
    
    
    
    
}
