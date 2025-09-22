package com.example.trimservice.controller;

import com.example.trimservice.service.StringTrimService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrimController.class)
class TrimControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StringTrimService stringTrimService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testTrimDefault() throws Exception {
        String input = "    hello world       ";
        String expected = "hello world";
        
        when(stringTrimService.trimDefault(input)).thenReturn(expected);

        Map<String, String> request = Map.of("input", input);

        mockMvc.perform(post("/trim/default")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.original").value(input))
                .andExpect(jsonPath("$.trimmed").value(expected))
                .andExpect(jsonPath("$.operation").value("default"));
    }

    @Test
    void testTrimLeading() throws Exception {
        String input = "    hello world       ";
        String expected = "hello world       ";
        
        when(stringTrimService.trimLeading(input)).thenReturn(expected);

        Map<String, String> request = Map.of("input", input);

        mockMvc.perform(post("/trim/leading")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.original").value(input))
                .andExpect(jsonPath("$.trimmed").value(expected))
                .andExpect(jsonPath("$.operation").value("leading"));
    }

    @Test
    void testTrimTrailing() throws Exception {
        String input = "    hello world       ";
        String expected = "    hello world";
        
        when(stringTrimService.trimTrailing(input)).thenReturn(expected);

        Map<String, String> request = Map.of("input", input);

        mockMvc.perform(post("/trim/trailing")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.original").value(input))
                .andExpect(jsonPath("$.trimmed").value(expected))
                .andExpect(jsonPath("$.operation").value("trailing"));
    }

    @Test
    void testTrimDefault_NullInput() throws Exception {
        when(stringTrimService.trimDefault(null)).thenReturn(null);

        Map<String, String> request = Map.of();

        mockMvc.perform(post("/trim/default")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.original").value(""))
                .andExpect(jsonPath("$.trimmed").value(""))
                .andExpect(jsonPath("$.operation").value("default"));
    }
}
