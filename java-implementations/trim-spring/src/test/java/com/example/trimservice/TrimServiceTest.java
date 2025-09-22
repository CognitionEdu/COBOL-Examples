package com.example.trimservice;

import com.example.trimservice.model.TrimResult;
import com.example.trimservice.service.TrimService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrimServiceTest {
    
    @Autowired
    private TrimService trimService;
    
    @Test
    public void testTrimBoth() {
        String input = "    hello world       ";
        TrimResult result = trimService.trimBoth(input);
        
        assertEquals(input, result.getOriginal());
        assertEquals("hello world", result.getTrimmed());
        assertEquals("BOTH", result.getTrimType());
    }
    
    @Test
    public void testTrimLeading() {
        String input = "    hello world       ";
        TrimResult result = trimService.trimLeading(input);
        
        assertEquals(input, result.getOriginal());
        assertEquals("hello world       ", result.getTrimmed());
        assertEquals("LEADING", result.getTrimType());
    }
    
    @Test
    public void testTrimTrailing() {
        String input = "    hello world       ";
        TrimResult result = trimService.trimTrailing(input);
        
        assertEquals(input, result.getOriginal());
        assertEquals("    hello world", result.getTrimmed());
        assertEquals("TRAILING", result.getTrimType());
    }
    
    @Test
    public void testDemonstrateTrimFunctions() {
        var results = trimService.demonstrateTrimFunctions();
        assertNotNull(results);
        assertEquals(6, results.size());
    }
}
