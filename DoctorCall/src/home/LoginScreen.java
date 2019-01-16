/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.util.Scanner;

/**
 *
 * @author Georg
 */
public class LoginScreen {
    
    public void login(){
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Welcome to Doctor Call");
        System.out.println("---------------------------");
        System.out.println("Please provide your credentials");
        System.out.println("Enter username:  ");
        String loginUsername = sc.next().toLowerCase().trim();
        System.out.println("Enter password:  ");
        String loginPassword = sc.next().toLowerCase().trim();
        
         
        
    
    
    }
    
}
