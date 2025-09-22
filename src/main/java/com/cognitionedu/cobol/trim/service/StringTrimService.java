package com.cognitionedu.cobol.trim.service;

import org.springframework.stereotype.Service;

@Service
public class StringTrimService {
    
    /**
     * Trims both leading and trailing whitespace (default COBOL trim behavior)
     */
    public String trimBoth(String input) {
        if (input == null) {
            return null;
        }
        return input.trim();
    }
    
    /**
     * Trims only leading whitespace (COBOL trim leading)
     */
    public String trimLeading(String input) {
        if (input == null) {
            return null;
        }
        return input.stripLeading();
    }
    
    /**
     * Trims only trailing whitespace (COBOL trim trailing)
     */
    public String trimTrailing(String input) {
        if (input == null) {
            return null;
        }
        return input.stripTrailing();
    }
}
