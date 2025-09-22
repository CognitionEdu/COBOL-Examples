package edu.cognition.examples.string;

/**
 * Java equivalent of trim.cbl
 * Demonstrates string trimming operations equivalent to COBOL TRIM function
 * 
 * COBOL Equivalent: trim/trim.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Examples of using string trimming functions
 */
public class TrimExample {
    
    public static void main(String[] args) {
        String testString = "    hello world               ";
        
        System.out.println("--" + testString + "--");
        
        String trimmedBoth = testString.trim();
        System.out.println("--" + trimmedBoth + "--");
        
        String trimmedTrailing = testString.replaceAll("\\s+$", "");
        System.out.println("--" + trimmedTrailing + "--");
        
        String trimmedLeading = testString.replaceAll("^\\s+", "");
        System.out.println("--" + trimmedLeading + "--");
        
        System.out.println("******************************");
        System.out.println(testString);
        System.out.println("******************************");
        System.out.println(trimmedBoth);
        System.out.println("******************************");
        System.out.println(trimmedBoth); // Same as trim() result
        System.out.println("******************************");
        System.out.println(trimmedLeading);
        
        String literalString = "   String literal    ";
        System.out.println("--" + literalString + "--");
        System.out.println("--" + literalString.trim() + "--");
        System.out.println("--" + literalString.replaceAll("\\s+$", "") + "--");
        System.out.println("--" + literalString.replaceAll("^\\s+", "") + "--");
        System.out.println();
        
        demonstrateAdditionalJavaMethods();
    }
    
    /**
     * Demonstrates additional Java string trimming methods not available in COBOL
     */
    private static void demonstrateAdditionalJavaMethods() {
        String testString = "    hello world               ";
        
        System.out.println("Additional Java String Methods:");
        System.out.println("-------------------------------");
        
        if (hasStripMethods()) {
            System.out.println("Using Java 11+ strip methods:");
            System.out.println("strip(): --" + testString.strip() + "--");
            System.out.println("stripLeading(): --" + testString.stripLeading() + "--");
            System.out.println("stripTrailing(): --" + testString.stripTrailing() + "--");
        }
        
        String customString = "xxxhello worldxxx";
        System.out.println("Custom character trimming:");
        System.out.println("Original: --" + customString + "--");
        System.out.println("Trim 'x': --" + customString.replaceAll("^x+|x+$", "") + "--");
    }
    
    /**
     * Check if Java 11+ strip methods are available
     */
    private static boolean hasStripMethods() {
        try {
            String.class.getMethod("strip");
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
