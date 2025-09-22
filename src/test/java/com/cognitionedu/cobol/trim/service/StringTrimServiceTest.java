package com.cognitionedu.cobol.trim.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StringTrimServiceTest {
    
    @Autowired
    private StringTrimService trimService;
    
    @Test
    void testTrimBoth() {
        String input = "    hello world               ";
        String expected = "hello world";
        assertEquals(expected, trimService.trimBoth(input));
        
        assertEquals("", trimService.trimBoth("   "));
        assertEquals("test", trimService.trimBoth("test"));
        assertNull(trimService.trimBoth(null));
    }
    
    @Test
    void testTrimLeading() {
        String input = "    hello world               ";
        String expected = "hello world               ";
        assertEquals(expected, trimService.trimLeading(input));
        
        assertEquals("test   ", trimService.trimLeading("   test   "));
        assertEquals("", trimService.trimLeading("   "));
        assertNull(trimService.trimLeading(null));
    }
    
    @Test
    void testTrimTrailing() {
        String input = "    hello world               ";
        String expected = "    hello world";
        assertEquals(expected, trimService.trimTrailing(input));
        
        assertEquals("   test", trimService.trimTrailing("   test   "));
        assertEquals("", trimService.trimTrailing("   "));
        assertNull(trimService.trimTrailing(null));
    }
    
    @Test
    void testStringLiterals() {
        assertEquals("String literal", trimService.trimBoth("   String literal    "));
        assertEquals("String literal   ", trimService.trimLeading("     String literal   "));
        assertEquals("   String literal", trimService.trimTrailing("   String literal    "));
    }
}
