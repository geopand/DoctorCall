
package menu;


public class AdminMenu {
    
    public static void Menu(){
    
    do{
        System.out.println("Welcome dear Admin");
        System.out.println("Please choose of the actions below");
        System.out.println("[1]. View all users");
        System.out.println("[2]. Create new user");
        System.out.println("[3]. Edit existing user");
        System.out.println("");
        System.out.println("\t---");
        System.out.println("");
        System.out.println("---Admin's Messages---");
        System.out.println("[4]. View all inbox messages");
        System.out.println("[5]. View all sent messages");
        System.out.println("[6]. Delete an inbox message");
        System.out.println("[7]. Delete a  sent message");
        System.out.println("");
        System.out.println("\t---");
        System.out.println("");
        System.out.println("---User's Messages---");
        System.out.println("[8]. View messages from all users");
        System.out.println("[9]. Edit a user message");
        System.out.println("[10]. Delete a user message");
        System.out.println("[11]. Exit the menu");

        
        if(sc.hasNextInt()){
            choice=sc.nextInt();
           Boolean isNumber=true;
       
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
