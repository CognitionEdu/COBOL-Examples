package edu.cognition.examples.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Java equivalent of json_generate.cbl
 * Demonstrates JSON generation equivalent to COBOL JSON GENERATE
 * 
 * COBOL Equivalent: json_generate/json_generate.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of JSON generation from record structures
 */
public class JsonGenerateExample {
    
    /**
     * Java equivalent of COBOL ws-record structure
     * Uses Jackson annotations for field name mapping
     */
    public static class Record {
        @JsonProperty("name")
        private String recordName;
        
        @JsonProperty("value") 
        private String recordValue;
        
        @JsonProperty("ws-record-blank")
        private String recordBlank;
        
        @JsonProperty("enabled")
        private String recordFlag;
        
        public Record() {
            this.recordBlank = " "; // Default blank space
            this.recordFlag = "false"; // Default value
        }
        
        public String getRecordName() { return recordName; }
        public void setRecordName(String recordName) { this.recordName = recordName; }
        
        public String getRecordValue() { return recordValue; }
        public void setRecordValue(String recordValue) { this.recordValue = recordValue; }
        
        public String getRecordBlank() { return recordBlank; }
        public void setRecordBlank(String recordBlank) { this.recordBlank = recordBlank; }
        
        public String getRecordFlag() { return recordFlag; }
        public void setRecordFlag(String recordFlag) { this.recordFlag = recordFlag; }
        
        public void setEnabled() { this.recordFlag = "true"; }
        public void setDisabled() { this.recordFlag = "false"; }
        public boolean isEnabled() { return "true".equals(this.recordFlag); }
        
        @Override
        public String toString() {
            return String.format("%-10s%-10s%-10s%-5s", 
                recordName != null ? recordName : "",
                recordValue != null ? recordValue : "",
                recordBlank != null ? recordBlank : "",
                recordFlag != null ? recordFlag : "");
        }
    }
    
    public static void main(String[] args) {
        try {
            Record record = new Record();
            
            record.setRecordName("Test Name");
            
            record.setRecordValue("Test Value");
            
            record.setEnabled();
            
            ObjectMapper mapper = new ObjectMapper();
            
            ObjectNode rootNode = mapper.createObjectNode();
            ObjectNode recordNode = mapper.valueToTree(record);
            rootNode.set("ws-record", recordNode);
            
            String jsonOutput = mapper.writeValueAsString(rootNode);
            
            System.out.println("JSON document successfully generated.");
            
            System.out.println("Generated JSON for record: " + record.toString());
            System.out.println("----------------------------");
            System.out.println(jsonOutput);
            System.out.println("----------------------------");
            
            System.out.printf("JSON output character count: %04d%n", jsonOutput.length());
            System.out.println("Done.");
            
        } catch (Exception e) {
            System.out.println("Error generating JSON: " + e.getMessage());
            System.exit(1);
        }
    }
}
