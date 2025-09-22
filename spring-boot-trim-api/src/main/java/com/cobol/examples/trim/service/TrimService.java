package com.cobol.examples.trim.service;

import org.springframework.stereotype.Service;

@Service
public class TrimService {

    public String trimBoth(String input) {
        if (input == null) {
            return null;
        }
        return input.trim();
    }

    public String trimLeading(String input) {
        if (input == null) {
            return null;
        }
        return input.stripLeading();
    }

    public String trimTrailing(String input) {
        if (input == null) {
            return null;
        }
        return input.stripTrailing();
    }
}
