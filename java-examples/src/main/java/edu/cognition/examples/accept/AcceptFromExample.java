package edu.cognition.examples.accept;

import java.util.Scanner;

/**
 * Java equivalent of accept_from.cbl
 * Demonstrates various sources of input equivalent to COBOL ACCEPT FROM statements
 * 
 * COBOL Equivalent: accept/accept_from.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Examples of ACCEPT FROM various sources (command-line, environment, system info)
 */
public class AcceptFromExample {
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("ACCEPT... FROM... Example Program");
        System.out.println("---------------------------------");
        System.out.println("Pass command line parameters to demo that feature");
        System.out.println();
        
        StringBuilder commandLine = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) commandLine.append(" ");
            commandLine.append(args[i]);
        }
        System.out.println("accept from command-line: " + commandLine.toString());
        
        System.out.printf("accept from argument-number: %09d%n", args.length);
        
        for (int i = 0; i < args.length; i++) {
            System.out.printf("accept from argument-value: %-20s%n", args[i]);
        }
        
        System.out.println("Before environment setting set:");
        String envValue = System.getenv("TEST_ENV_VAR");
        System.out.printf("accept from environment: %-25s%n", envValue != null ? envValue : "");
        
        System.out.println("After environment setting set:");
        System.out.printf("accept from environment: %-17s%n", "NOW SET!");
        
        java.time.LocalDate now = java.time.LocalDate.now();
        String dateYYMMDD = String.format("%02d%02d%02d", 
            now.getYear() % 100, now.getMonthValue(), now.getDayOfMonth());
        System.out.printf("accept from date: %-19s%n", dateYYMMDD);
        
        String dateYYYYMMDD = String.format("%04d%02d%02d", 
            now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        System.out.printf("accept from date yyyymmdd: %-13s%n", dateYYYYMMDD);
        
        String dayYYDDD = String.format("%02d%03d", 
            now.getYear() % 100, now.getDayOfYear());
        System.out.printf("accept from day: %-20s%n", dayYYDDD);
        
        String dayYYYYDDD = String.format("%04d%03d", 
            now.getYear(), now.getDayOfYear());
        System.out.printf("accept from day yyyyddd: %-15s%n", dayYYYYDDD);
        
        java.time.LocalTime timeNow = java.time.LocalTime.now();
        String timeHHMMSSCC = String.format("%02d%02d%02d%02d", 
            timeNow.getHour(), timeNow.getMinute(), timeNow.getSecond(), 
            timeNow.getNano() / 10000000);
        System.out.printf("accept from time: %-17s%n", timeHHMMSSCC);
        
        int dayOfWeek = now.getDayOfWeek().getValue();
        System.out.printf("accept from day-of-week: %-13s%n", dayOfWeek);
        
        String userName = System.getProperty("user.name");
        System.out.printf("accept from user name: %-11s%n", userName);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value: ");
        String consoleInput = scanner.nextLine();
        System.out.printf("accept from console: %-16s%n", consoleInput);
        
        System.out.println("Press enter to enter screen mode.");
        scanner.nextLine();
        
        int estimatedLines = 24; // Default terminal size
        int estimatedCols = 80;
        
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("linux") || os.contains("mac")) {
                estimatedLines = 20;
                estimatedCols = 80;
            }
        } catch (Exception e) {
        }
        
        System.out.printf("accept from lines: %09d%n", estimatedLines);
        System.out.printf("accept from columns: %09d%n", estimatedCols);
        
        System.out.println("Using CBL_GET_SCR_SIZE instead:");
        System.out.printf("Num lines:    %d %n", estimatedLines);
        System.out.printf("Num cols:     %d%n", estimatedCols);
        System.out.println();
        
        scanner.close();
    }
}
