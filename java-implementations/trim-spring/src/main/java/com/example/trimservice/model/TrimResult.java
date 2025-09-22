package com.example.trimservice.model;

public class TrimResult {
    private String original;
    private String trimmed;
    private String trimType;
    
    public TrimResult() {}
    
    public TrimResult(String original, String trimmed, String trimType) {
        this.original = original;
        this.trimmed = trimmed;
        this.trimType = trimType;
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
    
    public String getTrimType() {
        return trimType;
    }
    
    public void setTrimType(String trimType) {
        this.trimType = trimType;
    }
    
    @Override
    public String toString() {
        return String.format("TrimResult{original='%s', trimmed='%s', trimType='%s'}", 
                           original, trimmed, trimType);
    }
}
