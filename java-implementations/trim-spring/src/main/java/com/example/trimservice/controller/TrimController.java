package com.example.trimservice.controller;

import com.example.trimservice.model.TrimResult;
import com.example.trimservice.service.TrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trim")
public class TrimController {
    
    @Autowired
    private TrimService trimService;
    
    @PostMapping("/both")
    public TrimResult trimBoth(@RequestBody Map<String, String> request) {
        String input = request.get("input");
        return trimService.trimBoth(input);
    }
    
    @PostMapping("/leading")
    public TrimResult trimLeading(@RequestBody Map<String, String> request) {
        String input = request.get("input");
        return trimService.trimLeading(input);
    }
    
    @PostMapping("/trailing")
    public TrimResult trimTrailing(@RequestBody Map<String, String> request) {
        String input = request.get("input");
        return trimService.trimTrailing(input);
    }
    
    @GetMapping("/demo")
    public List<TrimResult> demonstrateTrimFunctions() {
        return trimService.demonstrateTrimFunctions();
    }
    
    @GetMapping("/console-demo")
    public String consoleDemo() {
        trimService.printCobolStyleOutput();
        return "Check console output for COBOL-style demonstration";
    }
    
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "COBOL Trim Function Java Implementation");
    }
}
