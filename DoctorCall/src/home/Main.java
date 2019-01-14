package home;

import db.Database;
import menu.UserMenu;

public class Main {

    public static void main(String[] args) {

//        User user = new User(1,"admin", "password", 1);
//        System.out.println(user);
//        Database db = new Database();
//        Database.printAllUsers();
//        Database.createUser();
//        Database.deleteUser();
//Database.editUser();
        UserMenu umenu= new UserMenu();
        umenu.usermenu();

    }

}
