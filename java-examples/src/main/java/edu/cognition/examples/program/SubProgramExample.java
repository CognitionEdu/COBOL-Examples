package edu.cognition.examples.program;

import java.util.Scanner;

/**
 * Java equivalent of sub_program/main_app.cbl and sub.cbl
 * Demonstrates sub-program calling equivalent to COBOL CALL statements
 * 
 * COBOL Equivalent: sub_program/main_app.cbl and sub.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of calling sub-programs and parameter passing
 */
public class SubProgramExample {
    
    /**
     * Java equivalent of COBOL sub-program
     * Demonstrates WORKING-STORAGE vs LOCAL-STORAGE behavior
     */
    public static class SubProgram {
        private static String wsTestItem1 = "";
        private static String wsTestItem2 = "";
        
        /**
         * Equivalent to COBOL sub-program entry point
         * @param param1 - equivalent to COBOL linkage section parameter
         * @param param2 - equivalent to COBOL linkage section parameter
         * @param byReference - if true, simulates BY REFERENCE; if false, BY CONTENT
         */
        public static void callSubProgram(StringBuilder param1, StringBuilder param2, boolean byReference) {
            String lsTestItem1 = "";
            String lsTestItem2 = "";
            
            System.out.println("In sub program: " + String.format("%-10s %-10s", param1.toString(), param2.toString()));
            System.out.println();
            
            System.out.println("working-storage values at start:");
            System.out.println("ws-test-item-1: " + String.format("%-10s", wsTestItem1));
            System.out.println("ws-test-item-2: " + String.format("%-10s", wsTestItem2));
            System.out.println();
            
            System.out.println("local-storage values at start:");
            System.out.println("ls-test-item-1: " + String.format("%-10s", lsTestItem1));
            System.out.println("ls-test-item-2: " + String.format("%-10s", lsTestItem2));
            System.out.println();
            
            System.out.println("Moving linkage section values to ws and ls vars..");
            
            wsTestItem1 = param1.toString();
            wsTestItem2 = param2.toString();
            lsTestItem1 = param1.toString();
            lsTestItem2 = param2.toString();
            
            System.out.println("setting input variables to new value...");
            System.out.println();
            
            if (byReference) {
                param1.setLength(0);
                param1.append("replace1");
                param2.setLength(0);
                param2.append("replace2");
            } else {
            }
            
            System.out.println("working-storage values at end:");
            System.out.println("ws-test-item-1: " + String.format("%-10s", wsTestItem1));
            System.out.println("ws-test-item-2: " + String.format("%-10s", wsTestItem2));
            System.out.println();
            
            System.out.println("local-storage values at end:");
            System.out.println("ls-test-item-1: " + String.format("%-10s", lsTestItem1));
            System.out.println("ls-test-item-2: " + String.format("%-10s", lsTestItem2));
            System.out.println();
            
            System.out.println("Exit sub program: " + String.format("%-10s %-10s", param1.toString(), param2.toString()));
            System.out.println();
        }
        
        /**
         * Equivalent to COBOL CANCEL statement - resets WORKING-STORAGE
         */
        public static void cancelSubProgram() {
            wsTestItem1 = "";
            wsTestItem2 = "";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        StringBuilder input1 = new StringBuilder();
        StringBuilder input2 = new StringBuilder();
        
        System.out.println();
        System.out.print("Enter value for #1: ");
        input1.append(scanner.nextLine());
        
        System.out.print("Enter value for #2: ");
        input2.append(scanner.nextLine());
        System.out.println();
        
        System.out.println("-----------------------------------------------");
        System.out.println("Main app: " + String.format("%-10s %-10s", input1.toString(), input2.toString()));
        System.out.println("Calling sub program by content:");
        
        StringBuilder copy1 = new StringBuilder(input1.toString());
        StringBuilder copy2 = new StringBuilder(input2.toString());
        SubProgram.callSubProgram(copy1, copy2, false);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Main app: " + String.format("%-10s %-10s", input1.toString(), input2.toString()));
        System.out.println("Second call of sub program should retain WS values.");
        System.out.println("Calling sub program by reference:");
        
        SubProgram.callSubProgram(input1, input2, true);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Main app: " + String.format("%-10s %-10s", input1.toString(), input2.toString()));
        System.out.println("Cancelling sub program");
        
        SubProgram.cancelSubProgram();
        
        System.out.println("Calling sub program. WS values should be reset:");
        SubProgram.callSubProgram(input1, input2, false);
        
        System.out.println("-----------------------------------------------");
        System.out.println("Main app: " + String.format("%-10s %-10s", input1.toString(), input2.toString()));
        
        scanner.close();
    }
}
