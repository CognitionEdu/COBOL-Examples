package edu.cognition.examples.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Java equivalent of sql_example.cbl
 * Demonstrates PostgreSQL database operations equivalent to COBOL embedded SQL
 * 
 * COBOL Equivalent: sql/sql_example.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of connecting and using a PostgreSQL database
 */
public class SqlExample {
    
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/cobol_db_example";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "password";
    
    private Connection connection;
    private Scanner scanner;
    
    public SqlExample() {
        this.scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        SqlExample example = new SqlExample();
        example.run();
    }
    
    public void run() {
        System.out.println();
        System.out.println("COBOL SQL DB Example Program");
        System.out.println("----------------------------");
        System.out.println();
        
        try {
            connectToDatabase();
            
            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("1) Display all accounts");
                System.out.println("2) Display disabled accounts");
                System.out.println("3) Query accounts");
                System.out.println("4) Exit");
                System.out.print("Selection: ");
                
                String choice = scanner.nextLine();
                
                switch (choice) {
                    case "1":
                        displayAllAccounts();
                        break;
                    case "2":
                        displayDisabledAccounts();
                        break;
                    case "3":
                        queryAccounts();
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("Please make a selection between 1-4");
                        break;
                }
            }
            
        } catch (SQLException e) {
            handleSqlError(e);
        } finally {
            disconnectFromDatabase();
            scanner.close();
        }
    }
    
    /**
     * Equivalent to COBOL EXEC SQL CONNECT TO :ws-db-connection-string
     */
    private void connectToDatabase() throws SQLException {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to database successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
            throw e;
        }
    }
    
    /**
     * Equivalent to COBOL display-all-accounts paragraph
     * Uses ACCOUNT-ALL-CUR cursor equivalent
     */
    private void displayAllAccounts() throws SQLException {
        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, IS_ENABLED, CREATE_DT, MOD_DT " +
                    "FROM ACCOUNTS ORDER BY ID";
        
        List<DatabaseRecord> accounts = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                DatabaseRecord record = new DatabaseRecord(
                    rs.getInt("ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("PHONE"),
                    rs.getString("ADDRESS"),
                    rs.getString("IS_ENABLED"),
                    rs.getString("CREATE_DT"),
                    rs.getString("MOD_DT")
                );
                accounts.add(record);
            }
        }
        
        displayAccountResults(accounts);
    }
    
    /**
     * Equivalent to COBOL display-disabled-accounts paragraph
     * Uses ACCOUNT-DISABLED-CUR cursor equivalent
     */
    private void displayDisabledAccounts() throws SQLException {
        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, IS_ENABLED, CREATE_DT, MOD_DT " +
                    "FROM ACCOUNTS WHERE IS_ENABLED = 'N' ORDER BY ID";
        
        List<DatabaseRecord> accounts = new ArrayList<>();
        
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                DatabaseRecord record = new DatabaseRecord(
                    rs.getInt("ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("PHONE"),
                    rs.getString("ADDRESS"),
                    rs.getString("IS_ENABLED"),
                    rs.getString("CREATE_DT"),
                    rs.getString("MOD_DT")
                );
                accounts.add(record);
            }
        }
        
        displayAccountResults(accounts);
    }
    
    /**
     * Equivalent to COBOL query-accounts paragraph
     * Uses ACCOUNT-QUERY-CUR cursor equivalent with LIKE operations
     */
    private void queryAccounts() throws SQLException {
        boolean searchAgain = true;
        
        while (searchAgain) {
            System.out.println();
            System.out.print("Enter search value: ");
            String searchString = scanner.nextLine();
            
            String searchValue = "%" + searchString.trim() + "%";
            
            System.out.println("Search value: " + searchValue);
            System.out.println("Length: " + searchValue.length());
            
            String sql = "SELECT ID, FIRST_NAME, LAST_NAME, PHONE, ADDRESS, IS_ENABLED, CREATE_DT, MOD_DT " +
                        "FROM ACCOUNTS WHERE " +
                        "FIRST_NAME LIKE ? OR LAST_NAME LIKE ? OR PHONE LIKE ? OR ADDRESS LIKE ? " +
                        "ORDER BY ID";
            
            List<DatabaseRecord> accounts = new ArrayList<>();
            
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, searchValue);
                stmt.setString(2, searchValue);
                stmt.setString(3, searchValue);
                stmt.setString(4, searchValue);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        DatabaseRecord record = new DatabaseRecord(
                            rs.getInt("ID"),
                            rs.getString("FIRST_NAME"),
                            rs.getString("LAST_NAME"),
                            rs.getString("PHONE"),
                            rs.getString("ADDRESS"),
                            rs.getString("IS_ENABLED"),
                            rs.getString("CREATE_DT"),
                            rs.getString("MOD_DT")
                        );
                        accounts.add(record);
                    }
                }
            }
            
            displayAccountResults(accounts);
            
            System.out.println();
            System.out.print("Search again? (Y/[N]) ");
            String response = scanner.nextLine().toUpperCase();
            searchAgain = "Y".equals(response);
        }
    }
    
    /**
     * Equivalent to COBOL display-account-results paragraph
     * Displays accounts in table format
     */
    private void displayAccountResults(List<DatabaseRecord> accounts) {
        System.out.println();
        System.out.println("ACCOUNTS:");
        System.out.println();
        System.out.println(" ID   | First    | Last     | Phone      | Address                | Enabled ");
        System.out.println("------|----------|----------|------------|------------------------|--------");
        
        for (DatabaseRecord account : accounts) {
            System.out.println(account.toString());
        }
    }
    
    /**
     * Equivalent to COBOL check-sql-state paragraph
     * Handles SQL errors and displays error information
     */
    private void handleSqlError(SQLException e) {
        System.out.println();
        System.out.println("SQL Error:");
        System.out.println("SQLCODE: " + e.getErrorCode());
        System.out.println("SQLSTATE: " + e.getSQLState());
        System.out.println("ERROR MESSAGE: " + e.getMessage());
        System.out.println();
    }
    
    /**
     * Disconnect from database
     */
    private void disconnectFromDatabase() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected.");
                System.out.println();
            } catch (SQLException e) {
                System.out.println("Error disconnecting: " + e.getMessage());
            }
        }
    }
}
