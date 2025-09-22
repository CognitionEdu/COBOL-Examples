package com.cobol.examples.trim.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrimServiceTest {

    private TrimService trimService;

    @BeforeEach
    void setUp() {
        trimService = new TrimService();
    }

    @Test
    void testTrimBoth_withCobolExample() {
        String input = "    hello world       ";
        String result = trimService.trimBoth(input);
        assertEquals("hello world", result);
    }

    @Test
    void testTrimLeading_withCobolExample() {
        String input = "    hello world       ";
        String result = trimService.trimLeading(input);
        assertEquals("hello world       ", result);
    }

    @Test
    void testTrimTrailing_withCobolExample() {
        String input = "    hello world       ";
        String result = trimService.trimTrailing(input);
        assertEquals("    hello world", result);
    }

    @Test
    void testTrimBoth_withOnlySpaces() {
        String input = "     ";
        String result = trimService.trimBoth(input);
        assertEquals("", result);
    }

    @Test
    void testTrimLeading_withOnlySpaces() {
        String input = "     ";
        String result = trimService.trimLeading(input);
        assertEquals("", result);
    }

    @Test
    void testTrimTrailing_withOnlySpaces() {
        String input = "     ";
        String result = trimService.trimTrailing(input);
        assertEquals("", result);
    }

    @Test
    void testTrimBoth_withEmptyString() {
        String input = "";
        String result = trimService.trimBoth(input);
        assertEquals("", result);
    }

    @Test
    void testTrimBoth_withNullInput() {
        String result = trimService.trimBoth(null);
        assertNull(result);
    }

    @Test
    void testTrimLeading_withNullInput() {
        String result = trimService.trimLeading(null);
        assertNull(result);
    }

    @Test
    void testTrimTrailing_withNullInput() {
        String result = trimService.trimTrailing(null);
        assertNull(result);
    }

    @Test
    void testTrimBoth_withNoSpaces() {
        String input = "hello";
        String result = trimService.trimBoth(input);
        assertEquals("hello", result);
    }

    @Test
    void testTrimLeading_withNoLeadingSpaces() {
        String input = "hello   ";
        String result = trimService.trimLeading(input);
        assertEquals("hello   ", result);
    }

    @Test
    void testTrimTrailing_withNoTrailingSpaces() {
        String input = "   hello";
        String result = trimService.trimTrailing(input);
        assertEquals("   hello", result);
    }
}
