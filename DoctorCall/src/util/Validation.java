package util;

import java.util.Scanner;

/**
 *
 * @author Georg
 */
public class Validation {

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
            if (!sc.hasNext(str)) {
                System.out.println("Please enter a valid input");
                System.out.print("\nEnter your choice >> ");
                sc.next();
            } else {
                str = sc.nextLine();
                correctInput = true;
            }
        }
        return str;
    }
}
