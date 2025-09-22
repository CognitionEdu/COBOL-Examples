package edu.cognition.examples.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Java equivalent of unstring.cbl
 * Demonstrates string parsing operations equivalent to COBOL UNSTRING
 * 
 * COBOL Equivalent: unstring/unstring.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Examples of parsing delimited strings into components
 */
public class UnstringExample {
    
    public static void main(String[] args) {
        example1SimpleUnstring();
        
        example2MultipleUnstring();
        
        example3ExplicitFields();
        
        example4MultipleDelimiters();
        
        example5MultipleDelimitersMultipleDestinations();
        
        example6FormattedNumber();
    }
    
    /**
     * Example 1: Simple UNSTRING equivalent
     * COBOL: unstring ws-source-str delimited by ' ' into ws-part-1 ws-part-2
     */
    private static void example1SimpleUnstring() {
        System.out.println("=================================================");
        System.out.println("EX 1 : SIMPLE UNSTRING");
        System.out.println();
        
        String sourceString = "Hello World                   ";
        System.out.println("SOURCE STRING: " + sourceString);
        
        String[] parts = sourceString.trim().split(" ", 2);
        String part1 = parts.length > 0 ? String.format("%-10s", parts[0]) : "";
        String part2 = parts.length > 1 ? String.format("%-10s", parts[1]) : "";
        
        System.out.println("PART1: " + part1);
        System.out.println("PART2: " + part2);
        System.out.println();
    }
    
    /**
     * Example 2: UNSTRING multiple times into same destination
     * Demonstrates overflow handling and pointer tracking
     */
    private static void example2MultipleUnstring() {
        System.out.println("=================================================");
        System.out.println("EX 2 : UNSTRING MULTIPLE TIMES INTO SAME DEST.");
        System.out.println();
        
        String sourceString = "Hello World                   ";
        System.out.println("SOURCE STRING: " + sourceString);
        
        String[] parts = sourceString.trim().split(" ");
        int pointer = 1; // COBOL-style 1-based indexing
        
        for (int i = 0; i < parts.length; i++) {
            if (i == 0) {
                System.out.println("ERROR: OVERFLOW");
            } else {
                System.out.println("Successfully unstrung.");
            }
            
            String partValue = String.format("%-10s", parts[i]);
            System.out.println("PART VALUE: " + partValue);
            
            pointer += parts[i].length() + 1;
            System.out.printf("POINTER: %05d%n", pointer);
        }
        System.out.println();
    }
    
    /**
     * Example 3: UNSTRING into explicit fields with pointer tracking
     */
    private static void example3ExplicitFields() {
        System.out.println("=================================================");
        System.out.println("EX 3 : UNSTRING INTO EXPLICIT FIELDS");
        System.out.println();
        
        String sourceString = "Hello World                   ";
        System.out.println("SOURCE STRING: " + sourceString);
        
        String[] parts = sourceString.trim().split(" ", 2);
        
        System.out.println("Successfully unstrung.");
        String part1 = parts.length > 0 ? String.format("%-10s", parts[0]) : "";
        String part2 = parts.length > 1 ? String.format("%-10s", parts[1]) : "";
        
        System.out.println("PART1: " + part1);
        System.out.println("PART2: " + part2);
        System.out.printf("POINTER: %05d%n", sourceString.length() + 1);
        System.out.println();
    }
    
    /**
     * Example 4: UNSTRING with multiple delimiters
     * COBOL: delimited by "<" or ">" or "!" or "|" or "%"
     */
    private static void example4MultipleDelimiters() {
        System.out.println("=================================================");
        System.out.println("EX 4 : UNSTRING WITH MULTIPLE DELIMITERS ");
        System.out.println();
        
        String sourceString = "A<B<CD>E%FG!HIJ|KL!MN>OP#QR!ST";
        System.out.println("SOURCE STRING: " + sourceString);
        System.out.println();
        
        String[] delimiters = {"<", ">", "!", "|", "%"};
        List<String> values = new ArrayList<>();
        List<String> foundDelimiters = new ArrayList<>();
        
        parseWithDelimiters(sourceString, delimiters, values, foundDelimiters);
        
        int pointer = 1;
        for (int i = 0; i < values.size(); i++) {
            String value = String.format("%-4s", values.get(i));
            String delimiter = i < foundDelimiters.size() ? foundDelimiters.get(i) : " ";
            
            System.out.println("VALUE: " + value);
            System.out.println("DELIMITER: " + delimiter);
            System.out.println("CHAR COUNT:" + values.get(i).length());
            
            pointer += values.get(i).length() + (i < foundDelimiters.size() ? 1 : 0);
            System.out.printf("CURRENT POINTER: %05d%n", pointer);
            System.out.printf("TOTAL FIELDS FILLED: %02d%n", i + 1);
            System.out.println("-------------------------------------------");
            System.out.println();
        }
    }
    
    /**
     * Example 5: UNSTRING with multiple delimiters into multiple destinations
     */
    private static void example5MultipleDelimitersMultipleDestinations() {
        System.out.println("=================================================");
        System.out.println("EX 5 : UNSTRING WITH MULTIPLE DELIMITERS INTO MULTIPLE DESTINATIONS");
        System.out.println();
        
        String sourceString = "A<B<CD>EFG!HIJ|KLMN>O         ";
        System.out.println("SOURCE STRING: " + sourceString);
        System.out.println();
        
        String[] delimiters = {"<", ">", "!", "|"};
        List<String> values = new ArrayList<>();
        List<String> foundDelimiters = new ArrayList<>();
        
        parseWithDelimiters(sourceString.trim(), delimiters, values, foundDelimiters);
        
        for (int i = 0; i < values.size(); i++) {
            System.out.printf("STRING NUMBER: +%09d%n", i + 1);
            String value = String.format("%-4s", values.get(i));
            String delimiter = i < foundDelimiters.size() ? foundDelimiters.get(i) : " ";
            
            System.out.println("VALUE: " + value);
            System.out.println("DELIMITER: " + delimiter);
            System.out.println("CHAR COUNT:" + values.get(i).length());
            System.out.println("-------------------------------------------");
            System.out.println();
        }
        
        System.out.println("TOTALS: ");
        System.out.printf("FIELDS FILLED: %02d%n", values.size());
        System.out.println();
    }
    
    /**
     * Example 6: UNSTRING formatted number
     * Parse currency format
     */
    private static void example6FormattedNumber() {
        System.out.println("=================================================");
        System.out.println("EX 6 : UNSTRING FORMATTED NUMBER");
        System.out.println();
        
        String sourceValue = "$123,456.12";
        System.out.println("SOURCE VALUE: " + sourceValue);
        
        String cleanValue = sourceValue.replace("$", "");
        String[] parts = cleanValue.split("[,.]");
        
        for (int i = 0; i < parts.length; i++) {
            System.out.printf("PART %d: %s%n", i + 1, 
                i == parts.length - 1 && parts[i].length() == 2 ? 
                String.format("%03d", Integer.parseInt(parts[i])) : parts[i]);
        }
        System.out.println();
    }
    
    /**
     * Helper method to parse string with multiple delimiters
     * Simulates COBOL UNSTRING behavior more closely
     */
    private static void parseWithDelimiters(String source, String[] delimiters, 
                                          List<String> values, List<String> foundDelimiters) {
        StringBuilder currentValue = new StringBuilder();
        
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            String charStr = String.valueOf(ch);
            
            boolean isDelimiter = false;
            for (String delimiter : delimiters) {
                if (delimiter.equals(charStr)) {
                    if (currentValue.length() > 0) {
                        values.add(currentValue.toString());
                        foundDelimiters.add(delimiter);
                        currentValue = new StringBuilder();
                    }
                    isDelimiter = true;
                    break;
                }
            }
            
            if (!isDelimiter) {
                currentValue.append(ch);
            }
        }
        
        if (currentValue.length() > 0) {
            values.add(currentValue.toString());
        }
    }
}
