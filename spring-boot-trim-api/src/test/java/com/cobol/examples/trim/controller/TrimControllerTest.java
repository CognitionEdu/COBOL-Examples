package com.cobol.examples.trim.controller;

import com.cobol.examples.trim.service.TrimService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrimController.class)
class TrimControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrimService trimService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testTrimBoth_success() throws Exception {
        String input = "    hello world       ";
        String expectedTrimmed = "hello world";
        
        when(trimService.trimBoth(input)).thenReturn(expectedTrimmed);

        String requestBody = "{\"input\":\"" + input + "\"}";

        mockMvc.perform(post("/api/trim/both")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.original").value(input))
                .andExpect(jsonPath("$.trimmed").value(expectedTrimmed))
                .andExpect(jsonPath("$.operation").value("both"));
    }

    @Test
    void testTrimLeading_success() throws Exception {
        String input = "    hello world       ";
        String expectedTrimmed = "hello world       ";
        
        when(trimService.trimLeading(input)).thenReturn(expectedTrimmed);

        String requestBody = "{\"input\":\"" + input + "\"}";

        mockMvc.perform(post("/api/trim/leading")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.original").value(input))
                .andExpect(jsonPath("$.trimmed").value(expectedTrimmed))
                .andExpect(jsonPath("$.operation").value("leading"));
    }

    @Test
    void testTrimTrailing_success() throws Exception {
        String input = "    hello world       ";
        String expectedTrimmed = "    hello world";
        
        when(trimService.trimTrailing(input)).thenReturn(expectedTrimmed);

        String requestBody = "{\"input\":\"" + input + "\"}";

        mockMvc.perform(post("/api/trim/trailing")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.original").value(input))
                .andExpect(jsonPath("$.trimmed").value(expectedTrimmed))
                .andExpect(jsonPath("$.operation").value("trailing"));
    }

    @Test
    void testTrimBoth_withNullInput_shouldReturnBadRequest() throws Exception {
        String requestBody = "{\"input\":null}";

        mockMvc.perform(post("/api/trim/both")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testTrimBoth_withMissingInput_shouldReturnBadRequest() throws Exception {
        String requestBody = "{}";

        mockMvc.perform(post("/api/trim/both")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());
    }
}
