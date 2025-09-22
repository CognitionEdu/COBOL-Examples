package com.example.trimservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringTrimServiceTest {

    private StringTrimService stringTrimService;

    @BeforeEach
    void setUp() {
        stringTrimService = new StringTrimService();
    }

    @Test
    void testTrimDefault_CobolTestString() {
        String input = "    hello world       ";
        String expected = "hello world";
        String result = stringTrimService.trimDefault(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimLeading_CobolTestString() {
        String input = "    hello world       ";
        String expected = "hello world       ";
        String result = stringTrimService.trimLeading(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimTrailing_CobolTestString() {
        String input = "    hello world       ";
        String expected = "    hello world";
        String result = stringTrimService.trimTrailing(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimDefault_StringLiteral() {
        String input = "    String literal    ";
        String expected = "String literal";
        String result = stringTrimService.trimDefault(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimLeading_StringLiteral() {
        String input = "     String literal   ";
        String expected = "String literal   ";
        String result = stringTrimService.trimLeading(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimTrailing_StringLiteral() {
        String input = "   String literal    ";
        String expected = "   String literal";
        String result = stringTrimService.trimTrailing(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimDefault_NullInput() {
        String result = stringTrimService.trimDefault(null);
        assertNull(result);
    }

    @Test
    void testTrimLeading_NullInput() {
        String result = stringTrimService.trimLeading(null);
        assertNull(result);
    }

    @Test
    void testTrimTrailing_NullInput() {
        String result = stringTrimService.trimTrailing(null);
        assertNull(result);
    }

    @Test
    void testTrimDefault_EmptyString() {
        String input = "";
        String expected = "";
        String result = stringTrimService.trimDefault(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimDefault_OnlySpaces() {
        String input = "     ";
        String expected = "";
        String result = stringTrimService.trimDefault(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimLeading_OnlySpaces() {
        String input = "     ";
        String expected = "";
        String result = stringTrimService.trimLeading(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimTrailing_OnlySpaces() {
        String input = "     ";
        String expected = "";
        String result = stringTrimService.trimTrailing(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimDefault_NoSpaces() {
        String input = "hello";
        String expected = "hello";
        String result = stringTrimService.trimDefault(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimLeading_NoLeadingSpaces() {
        String input = "hello   ";
        String expected = "hello   ";
        String result = stringTrimService.trimLeading(input);
        assertEquals(expected, result);
    }

    @Test
    void testTrimTrailing_NoTrailingSpaces() {
        String input = "   hello";
        String expected = "   hello";
        String result = stringTrimService.trimTrailing(input);
        assertEquals(expected, result);
    }
}
