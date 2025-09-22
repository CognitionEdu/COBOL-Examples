package edu.cognition.examples;

import java.util.Scanner;

/**
 * Main class to run all COBOL-to-Java conversion examples
 * Provides a menu-driven interface to execute individual examples
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("COBOL Examples - Java Conversion");
        System.out.println("================================");
        System.out.println();
        
        while (running) {
            displayMenu();
            System.out.print("Enter your choice (1-10, or 0 to exit): ");
            
            String choice = scanner.nextLine();
            System.out.println();
            
            switch (choice) {
                case "1":
                    runAcceptExamples();
                    break;
                case "2":
                    runJsonExample();
                    break;
                case "3":
                    runXmlExample();
                    break;
                case "4":
                    runSqlExample();
                    break;
                case "5":
                    runStringExamples();
                    break;
                case "6":
                    runDataStructureExamples();
                    break;
                case "7":
                    runSubProgramExample();
                    break;
                case "8":
                    runScreenSizeExample();
                    break;
                case "9":
                    runAllExamples();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            if (running) {
                System.out.println();
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                System.out.println();
            }
        }
        
        System.out.println("Thank you for using the COBOL-to-Java examples!");
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("Available Examples:");
        System.out.println("1. User Input Examples (accept/)");
        System.out.println("2. JSON Generation Example");
        System.out.println("3. XML Generation Example");
        System.out.println("4. SQL Database Example");
        System.out.println("5. String Processing Examples");
        System.out.println("6. Data Structure Examples (redefines)");
        System.out.println("7. Sub-Program Example");
        System.out.println("8. Screen Size Example");
        System.out.println("9. Run All Examples");
        System.out.println("0. Exit");
        System.out.println();
    }
    
    private static void runAcceptExamples() {
        System.out.println("=== User Input Examples ===");
        System.out.println();
        
        System.out.println("Running AcceptExample...");
        edu.cognition.examples.accept.AcceptExample.main(new String[]{});
        
        System.out.println("\nRunning AcceptSecureExample...");
        edu.cognition.examples.accept.AcceptSecureExample.main(new String[]{});
        
        System.out.println("\nRunning AcceptFromExample...");
        edu.cognition.examples.accept.AcceptFromExample.main(new String[]{"arg1", "arg2", "arg3"});
    }
    
    private static void runJsonExample() {
        System.out.println("=== JSON Generation Example ===");
        System.out.println();
        edu.cognition.examples.json.JsonGenerateExample.main(new String[]{});
    }
    
    private static void runXmlExample() {
        System.out.println("=== XML Generation Example ===");
        System.out.println();
        edu.cognition.examples.xml.XmlGenerateExample.main(new String[]{});
    }
    
    private static void runSqlExample() {
        System.out.println("=== SQL Database Example ===");
        System.out.println("Note: Requires PostgreSQL database setup");
        System.out.println();
        edu.cognition.examples.sql.SqlExample.main(new String[]{});
    }
    
    private static void runStringExamples() {
        System.out.println("=== String Processing Examples ===");
        System.out.println();
        
        System.out.println("Running TrimExample...");
        edu.cognition.examples.string.TrimExample.main(new String[]{});
        
        System.out.println("\nRunning UnstringExample...");
        edu.cognition.examples.string.UnstringExample.main(new String[]{});
    }
    
    private static void runDataStructureExamples() {
        System.out.println("=== Data Structure Examples ===");
        System.out.println();
        edu.cognition.examples.data.RedefinesExample.main(new String[]{});
    }
    
    private static void runSubProgramExample() {
        System.out.println("=== Sub-Program Example ===");
        System.out.println();
        edu.cognition.examples.program.SubProgramExample.main(new String[]{});
    }
    
    private static void runScreenSizeExample() {
        System.out.println("=== Screen Size Example ===");
        System.out.println();
        edu.cognition.examples.system.ScreenSizeExample.main(new String[]{});
    }
    
    private static void runAllExamples() {
        System.out.println("=== Running All Examples ===");
        System.out.println();
        
        runJsonExample();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        runXmlExample();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        runStringExamples();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        runDataStructureExamples();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        runScreenSizeExample();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        System.out.println("All non-interactive examples completed!");
        System.out.println("Note: Interactive examples (accept, sql, sub-program) skipped in batch mode.");
    }
}
