package com.example.trimservice.service;

import com.example.trimservice.model.TrimResult;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrimService {
    
    public TrimResult trimBoth(String input) {
        return new TrimResult(input, input.trim(), "BOTH");
    }
    
    public TrimResult trimLeading(String input) {
        String trimmed = input.replaceAll("^\\s+", "");
        return new TrimResult(input, trimmed, "LEADING");
    }
    
    public TrimResult trimTrailing(String input) {
        String trimmed = input.replaceAll("\\s+$", "");
        return new TrimResult(input, trimmed, "TRAILING");
    }
    
    public List<TrimResult> demonstrateTrimFunctions() {
        List<TrimResult> results = new ArrayList<>();
        
        String testString1 = "    hello world       ";
        String testString2 = "   String literal    ";
        
        results.add(trimBoth(testString1));
        results.add(trimLeading(testString1));
        results.add(trimTrailing(testString1));
        
        results.add(trimBoth(testString2));
        results.add(trimLeading(testString2));
        results.add(trimTrailing(testString2));
        
        return results;
    }
    
    public String formatOutput(String input, String trimmed) {
        return String.format("--%s--", trimmed);
    }
    
    public void printCobolStyleOutput() {
        String testString = "    hello world       ";
        String separator = "******************************";
        
        System.out.println("=== COBOL-Style TRIM Function Demonstration ===");
        System.out.println();
        
        System.out.println(formatOutput(testString, testString));
        System.out.println(formatOutput(testString, testString.trim()));
        System.out.println(formatOutput(testString, trimLeading(testString).getTrimmed()));
        System.out.println(formatOutput(testString, trimTrailing(testString).getTrimmed()));
        
        System.out.println(separator);
        System.out.println(String.format("%-30s", testString));
        
        System.out.println(separator);
        System.out.println(String.format("%-30s", testString.trim()));
        
        System.out.println(separator);
        System.out.println(String.format("%-30s", trimLeading(testString).getTrimmed()));
        
        System.out.println(separator);
        System.out.println(String.format("%-30s", trimTrailing(testString).getTrimmed()));
        
        System.out.println();
        System.out.println("=== String Literal Examples ===");
        String literal = "    String literal    ";
        System.out.println(formatOutput(literal, literal));
        System.out.println(formatOutput(literal, literal.trim()));
        System.out.println(formatOutput(literal, trimLeading(literal).getTrimmed()));
        System.out.println(formatOutput(literal, trimTrailing(literal).getTrimmed()));
    }
}
