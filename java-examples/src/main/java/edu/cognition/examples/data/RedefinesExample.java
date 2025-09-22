package edu.cognition.examples.data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Java equivalent of redefines.cbl
 * Demonstrates data structure redefining equivalent to COBOL REDEFINES
 * 
 * COBOL Equivalent: redifines/redefines.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of redefining data structures to interpret data differently
 */
public class RedefinesExample {
    
    /**
     * Java equivalent of COBOL ws-customer structure with REDEFINES
     * Uses composition and methods to simulate REDEFINES behavior
     */
    public static class Customer {
        private int customerType; // 1=Person, 2=Corp
        private String customerName; // Can be interpreted as first+last or corp name
        private String streetAddress;
        private String state;
        private int zipCode;
        
        public Customer() {
            this.customerName = "                              "; // 30 spaces
            this.streetAddress = "                    "; // 20 spaces
            this.state = "  "; // 2 spaces
        }
        
        public boolean isPersonType() { return customerType == 1; }
        public boolean isCorpType() { return customerType == 2; }
        public void setPersonType() { this.customerType = 1; }
        public void setCorpType() { this.customerType = 2; }
        
        public void setPersonName(String firstName, String lastName) {
            String combined = String.format("%-10s%-20s", firstName, lastName);
            this.customerName = combined.substring(0, Math.min(30, combined.length()));
        }
        
        public String getFirstName() {
            return customerName.substring(0, 10).trim();
        }
        
        public String getLastName() {
            return customerName.substring(10, 30).trim();
        }
        
        public void setCorpName(String corpName) {
            this.customerName = String.format("%-30s", corpName).substring(0, 30);
        }
        
        public String getCorpName() {
            return customerName.trim();
        }
        
        public String getStreetAddress() { return streetAddress.trim(); }
        public void setStreetAddress(String address) { 
            this.streetAddress = String.format("%-20s", address).substring(0, 20);
        }
        
        public String getState() { return state.trim(); }
        public void setState(String state) { 
            this.state = String.format("%-2s", state).substring(0, 2);
        }
        
        public int getZipCode() { return zipCode; }
        public void setZipCode(int zipCode) { this.zipCode = zipCode; }
    }
    
    /**
     * Java equivalent of COBOL ws-diff-data-types with REDEFINES
     * Uses ByteBuffer to simulate memory reinterpretation
     */
    public static class DataTypeExample {
        private char dataType; // 'D'=Display, 'C'=Comp
        private ByteBuffer buffer;
        
        public DataTypeExample() {
            this.buffer = ByteBuffer.allocate(10);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        
        public boolean isDisplayType() { return dataType == 'D'; }
        public boolean isCompType() { return dataType == 'C'; }
        public void setDisplayType() { this.dataType = 'D'; }
        public void setCompType() { this.dataType = 'C'; }
        
        public void setDisplayValue(String value) {
            setDisplayType();
            buffer.clear();
            byte[] bytes = String.format("%-10s", value).getBytes();
            buffer.put(bytes, 0, Math.min(10, bytes.length));
        }
        
        public String getDisplayValue() {
            buffer.position(0);
            byte[] bytes = new byte[10];
            buffer.get(bytes);
            return new String(bytes).trim();
        }
        
        public void setCompValue(double value) {
            setCompType();
            buffer.clear();
            buffer.putDouble(value);
        }
        
        public double getCompValue() {
            buffer.position(0);
            try {
                return buffer.getDouble();
            } catch (Exception e) {
                buffer.position(0);
                long longValue = 0;
                for (int i = 0; i < Math.min(8, buffer.remaining()); i++) {
                    longValue |= ((long) (buffer.get() & 0xFF)) << (i * 8);
                }
                return Double.longBitsToDouble(longValue);
            }
        }
    }
    
    public static void main(String[] args) {
        setupTestData();
        
        displayCustomerData();
        
        setupSecondTestData();
        
        displaySecondTestData();
    }
    
    private static void setupTestData() {
        System.out.println();
        System.out.println("1. Person record with first/last name entered.");
        System.out.println("2. Corp record with corp name entered.");
        System.out.println("3. Person record with corp name entered.");
    }
    
    private static void displayCustomerData() {
        System.out.println();
        System.out.println("Displaying fake customer data:");
        System.out.println("------------------------------");
        System.out.println();
        
        Customer[] customers = new Customer[3];
        
        customers[0] = new Customer();
        customers[0].setPersonType();
        customers[0].setPersonName("test-first", "test-last");
        customers[0].setStreetAddress("123 fake st");
        customers[0].setState("NV");
        customers[0].setZipCode(12345);
        
        customers[1] = new Customer();
        customers[1].setCorpType();
        customers[1].setCorpName("no-name corp");
        customers[1].setStreetAddress("567 real st");
        customers[1].setState("NY");
        customers[1].setZipCode(11795);
        
        customers[2] = new Customer();
        customers[2].setPersonType();
        customers[2].setCorpName("SET CORP VALUE"); // This affects the name field
        customers[2].setStreetAddress("890 what st");
        customers[2].setState("MA");
        customers[2].setZipCode(9345);
        
        for (Customer customer : customers) {
            if (customer.isPersonType()) {
                System.out.println("Customer Type: PERSON");
                System.out.println("First Name: " + customer.getFirstName());
                System.out.println("Last Name: " + customer.getLastName());
            } else {
                System.out.println("Customer Type: CORP");
                System.out.println("Company name: " + customer.getCorpName());
            }
            
            System.out.println("Address: ");
            System.out.println(customer.getStreetAddress());
            System.out.println(customer.getState() + ", " + customer.getZipCode());
            System.out.println("------------------------------");
            System.out.println();
        }
    }
    
    private static void setupSecondTestData() {
    }
    
    private static void displaySecondTestData() {
        System.out.println();
        System.out.println("Redefines with different variable types:");
        System.out.println("----------------------------------------");
        
        DataTypeExample[] dataExamples = new DataTypeExample[2];
        
        dataExamples[0] = new DataTypeExample();
        dataExamples[0].setDisplayValue("ABC123");
        
        System.out.println("Value entered in ws-data-disp-value: ABC123");
        System.out.println("ws-data-disp-value x(10): " + dataExamples[0].getDisplayValue());
        System.out.println("ws-data-comp-value comp-2: " + dataExamples[0].getCompValue());
        System.out.println();
        
        dataExamples[1] = new DataTypeExample();
        dataExamples[1].setCompValue(12345.63);
        
        System.out.println("----------------------------------------");
        System.out.println("Value entered in ws-data-comp-value: 12345.63");
        System.out.println("ws-data-disp-value x(10): " + dataExamples[1].getDisplayValue());
        System.out.println("ws-data-comp-value comp-2: " + dataExamples[1].getCompValue());
        System.out.println();
    }
}
