package com.cobol.examples.trim.dto;

import jakarta.validation.constraints.NotNull;

public class TrimRequest {
    
    @NotNull(message = "Input string cannot be null")
    private String input;

    public TrimRequest() {
    }

    public TrimRequest(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
