package edu.cognition.examples.accept;

import java.util.Arrays;

/**
 * Java equivalent of accept-secure.cbl
 * Demonstrates secure password input equivalent to COBOL ACCEPT SECURE
 * 
 * COBOL Equivalent: accept/accept-secure.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of secure input handling (COBOL SECURE keyword equivalent)
 */
public class AcceptSecureExample {
    
    public static void main(String[] args) {
        System.out.print("Enter password: ");
        
        java.io.Console console = System.console();
        char[] password = null;
        
        if (console != null) {
            password = console.readPassword();
        } else {
            System.out.println("(Console not available - password will be visible)");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String fallbackPassword = scanner.nextLine();
            password = fallbackPassword.toCharArray();
            scanner.close();
        }
        
        System.out.println("   You entered: " + new String(password));
        
        if (password != null) {
            Arrays.fill(password, ' ');
        }
    }
}
