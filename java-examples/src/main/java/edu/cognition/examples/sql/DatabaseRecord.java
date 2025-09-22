package edu.cognition.examples.sql;

/**
 * Java equivalent of COBOL ws-sql-account-record structure
 * Represents a database account record
 */
public class DatabaseRecord {
    private int accountId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String isEnabled;
    private String createDate;
    private String modDate;
    
    public DatabaseRecord() {}
    
    public DatabaseRecord(int accountId, String firstName, String lastName, 
                         String phone, String address, String isEnabled, 
                         String createDate, String modDate) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.isEnabled = isEnabled;
        this.createDate = createDate;
        this.modDate = modDate;
    }
    
    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getIsEnabled() { return isEnabled; }
    public void setIsEnabled(String isEnabled) { this.isEnabled = isEnabled; }
    
    public String getCreateDate() { return createDate; }
    public void setCreateDate(String createDate) { this.createDate = createDate; }
    
    public String getModDate() { return modDate; }
    public void setModDate(String modDate) { this.modDate = modDate; }
    
    public boolean isAccountEnabled() { return "Y".equals(isEnabled); }
    public boolean isAccountDisabled() { return "N".equals(isEnabled); }
    
    @Override
    public String toString() {
        return String.format("%5d | %-8s | %-8s | %-10s | %-22s | %s",
            accountId, 
            firstName != null ? firstName : "",
            lastName != null ? lastName : "",
            phone != null ? phone : "",
            address != null ? address : "",
            isEnabled != null ? isEnabled : "");
    }
}
