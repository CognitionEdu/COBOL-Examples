package edu.cognition.examples.system;

import java.io.IOException;

/**
 * Java equivalent of screen_size/get_screen_size.cbl
 * Demonstrates terminal size detection equivalent to COBOL screen size functions
 * 
 * COBOL Equivalent: screen_size/get_screen_size.cbl
 * Author: Converted from Erik Eriksen's COBOL example
 * Purpose: Example of getting terminal/screen dimensions
 */
public class ScreenSizeExample {
    
    public static void main(String[] args) {
        getScreenSizeMethod1();
        
        getScreenSizeMethod2();
        
        System.out.println("Done.");
        System.out.println();
    }
    
    /**
     * Method 1: Java equivalent of COBOL ACCEPT FROM LINES/COLUMNS
     * Uses system properties and environment variables where available
     */
    private static void getScreenSizeMethod1() {
        System.out.println("Using 'ACCEPT ... FROM LINES' and 'ACCEPT ... FROM COLUMNS' to get screen size:");
        System.out.println("-------------------------------------------------------------");
        
        int lines = getTerminalLines();
        int columns = getTerminalColumns();
        
        System.out.println("Current screen size:");
        System.out.printf("Columns: %03d%n", columns);
        System.out.printf("  Lines: %03d%n", lines);
        System.out.println();
        System.out.println("Resize and press enter to continue");
        
        try {
            System.in.read();
        } catch (IOException e) {
        }
        System.out.println();
    }
    
    /**
     * Method 2: Java equivalent of COBOL CBL_GET_SCR_SIZE
     * Uses system commands where possible for more accurate results
     */
    private static void getScreenSizeMethod2() {
        System.out.println("Using 'CBL_GET_SCR_SIZE' to get screen size:");
        System.out.println("-------------------------------------------------------------");
        
        int[] screenSize = getScreenSizeSystemCall();
        int lines = screenSize[0];
        int columns = screenSize[1];
        
        System.out.println("Current screen size:");
        System.out.printf("Columns: %03d%n", columns);
        System.out.printf("  Lines: %03d%n", lines);
        System.out.println();
        System.out.println("Resize and press enter to continue");
        
        try {
            System.in.read();
        } catch (IOException e) {
        }
        System.out.println();
    }
    
    /**
     * Get terminal lines using various methods
     */
    private static int getTerminalLines() {
        String linesEnv = System.getenv("LINES");
        if (linesEnv != null) {
            try {
                return Integer.parseInt(linesEnv);
            } catch (NumberFormatException e) {
            }
        }
        
        String linesProp = System.getProperty("terminal.lines");
        if (linesProp != null) {
            try {
                return Integer.parseInt(linesProp);
            } catch (NumberFormatException e) {
            }
        }
        
        return 24;
    }
    
    /**
     * Get terminal columns using various methods
     */
    private static int getTerminalColumns() {
        String columnsEnv = System.getenv("COLUMNS");
        if (columnsEnv != null) {
            try {
                return Integer.parseInt(columnsEnv);
            } catch (NumberFormatException e) {
            }
        }
        
        String columnsProp = System.getProperty("terminal.columns");
        if (columnsProp != null) {
            try {
                return Integer.parseInt(columnsProp);
            } catch (NumberFormatException e) {
            }
        }
        
        return 80;
    }
    
    /**
     * Get screen size using system calls (more accurate method)
     * Equivalent to COBOL CBL_GET_SCR_SIZE function
     */
    private static int[] getScreenSizeSystemCall() {
        int lines = 24; // Default
        int columns = 80; // Default
        
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("linux") || os.contains("mac") || os.contains("unix")) {
                Process process = Runtime.getRuntime().exec(new String[]{"sh", "-c", "stty size 2>/dev/null"});
                process.waitFor();
                
                if (process.exitValue() == 0) {
                    java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()));
                    String result = reader.readLine();
                    
                    if (result != null && !result.trim().isEmpty()) {
                        String[] parts = result.trim().split("\\s+");
                        if (parts.length == 2) {
                            lines = Integer.parseInt(parts[0]);
                            columns = Integer.parseInt(parts[1]);
                        }
                    }
                }
            } else if (os.contains("windows")) {
                Process process = Runtime.getRuntime().exec("mode con");
                process.waitFor();
                
                if (process.exitValue() == 0) {
                    java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()));
                    String line;
                    
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("Lines:")) {
                            String[] parts = line.split(":");
                            if (parts.length > 1) {
                                lines = Integer.parseInt(parts[1].trim());
                            }
                        } else if (line.contains("Columns:")) {
                            String[] parts = line.split(":");
                            if (parts.length > 1) {
                                columns = Integer.parseInt(parts[1].trim());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            lines = getTerminalLines();
            columns = getTerminalColumns();
        }
        
        return new int[]{lines, columns};
    }
}
