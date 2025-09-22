package edu.cognition.examples.xml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Java equivalent of xml_generate.cbl
 * Demonstrates XML generation equivalent to COBOL XML GENERATE
 * 
 * COBOL Equivalent: xml_generate/xml_generate.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of XML generation from record structures
 */
public class XmlGenerateExample {
    
    /**
     * Java equivalent of COBOL ws-record structure
     * Uses JAXB annotations for XML mapping
     */
    @XmlRootElement(name = "ws-record")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Record {
        
        @XmlElement(name = "name")
        private String recordName;
        
        @XmlElement(name = "value")
        private String recordValue;
        
        @XmlTransient // Equivalent to COBOL "suppress when spaces"
        private String recordBlank;
        
        @XmlAttribute(name = "enabled") // Equivalent to COBOL "type of ws-record-flag is attribute"
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
            
            JAXBContext context = JAXBContext.newInstance(Record.class);
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false); // Include XML declaration
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(record, writer);
            String xmlOutput = writer.toString();
            
            System.out.println("XML document successfully generated.");
            
            System.out.println("Generated xml for record: " + record.toString());
            System.out.println("----------------------------");
            System.out.println(xmlOutput.trim());
            System.out.println("----------------------------");
            
            System.out.printf("XML output character count: %04d%n", xmlOutput.length());
            System.out.println("Done.");
            
        } catch (Exception e) {
            System.out.println("Error generating XML: " + e.getMessage());
            System.exit(1);
        }
    }
}
