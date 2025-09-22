package com.example.trimservice.service;

import org.springframework.stereotype.Service;

@Service
public class StringTrimService {

    public String trimDefault(String input) {
        if (input == null) {
            return null;
        }
        return input.trim();
    }

    public String trimLeading(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("^\\s+", "");
    }

    public String trimTrailing(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s+$", "");
    }
}
