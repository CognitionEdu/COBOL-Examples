package edu.cognition.examples.accept;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Java equivalent of accept.cbl
 * Demonstrates various forms of user input handling that correspond to COBOL ACCEPT statements.
 * 
 * COBOL Equivalent: accept/accept.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Examples of using various forms of user input in Java (equivalent to COBOL ACCEPT verb)
 */
public class AcceptExample {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Simple accept. Enter a value: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        
        System.out.println("Press any key to enter screen mode.");
        scanner.nextLine();
        
        
        System.out.print("Enter value or wait 3 seconds: ");
        String timeoutInput = getInputWithTimeout(scanner, 3000);
        System.out.println("You entered: " + (timeoutInput != null ? timeoutInput : ""));
        
        System.out.print("Enter 16 chars to auto skip: ");
        String autoSkipInput = getInputWithMaxLength(scanner, 16);
        System.out.println("You entered: " + autoSkipInput);
        
        System.out.print("Enter a value (no echo): ");
        String hiddenInput = getHiddenInput();
        System.out.println("You entered: " + hiddenInput);
        
        System.out.print("Enter a value: ");
        String upperInput = scanner.nextLine().toUpperCase();
        System.out.println("You entered: " + upperInput);
        
        scanner.close();
    }
    
    /**
     * Simulates COBOL timeout functionality
     * Waits for input with a timeout period
     */
    private static String getInputWithTimeout(Scanner scanner, int timeoutMs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            return scanner.nextLine();
        });
        
        try {
            return future.get(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            executor.shutdown();
        }
    }
    
    /**
     * Simulates COBOL auto-skip functionality
     * Automatically submits when max length is reached
     */
    private static String getInputWithMaxLength(Scanner scanner, int maxLength) {
        StringBuilder input = new StringBuilder();
        
        try {
            while (input.length() < maxLength) {
                if (System.in.available() > 0) {
                    int ch = System.in.read();
                    if (ch == '\n' || ch == '\r') {
                        break;
                    }
                    input.append((char) ch);
                    System.out.print((char) ch); // Echo the character
                }
                Thread.sleep(10); // Small delay to prevent busy waiting
            }
        } catch (Exception e) {
            return scanner.nextLine();
        }
        
        System.out.println(); // New line after input
        return input.toString();
    }
    
    /**
     * Simulates COBOL no-echo functionality
     * Hides input from display (like password input)
     */
    private static String getHiddenInput() {
        java.io.Console console = System.console();
        if (console != null) {
            char[] password = console.readPassword();
            return new String(password);
        } else {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }
}
