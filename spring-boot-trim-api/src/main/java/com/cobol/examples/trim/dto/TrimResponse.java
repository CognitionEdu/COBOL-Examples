package com.cobol.examples.trim.dto;

public class TrimResponse {
    
    private String original;
    private String trimmed;
    private String operation;

    public TrimResponse() {
    }

    public TrimResponse(String original, String trimmed, String operation) {
        this.original = original;
        this.trimmed = trimmed;
        this.operation = operation;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTrimmed() {
        return trimmed;
    }

    public void setTrimmed(String trimmed) {
        this.trimmed = trimmed;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
