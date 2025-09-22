package com.example.trimservice.controller;

import com.example.trimservice.service.StringTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/trim")
@CrossOrigin(origins = "*")
public class TrimController {

    @Autowired
    private StringTrimService stringTrimService;

    @PostMapping("/default")
    public Map<String, String> trimDefault(@RequestBody Map<String, String> request) {
        String input = request.get("input");
        String result = stringTrimService.trimDefault(input);
        return Map.of(
            "original", input != null ? input : "",
            "trimmed", result != null ? result : "",
            "operation", "default"
        );
    }

    @PostMapping("/leading")
    public Map<String, String> trimLeading(@RequestBody Map<String, String> request) {
        String input = request.get("input");
        String result = stringTrimService.trimLeading(input);
        return Map.of(
            "original", input != null ? input : "",
            "trimmed", result != null ? result : "",
            "operation", "leading"
        );
    }

    @PostMapping("/trailing")
    public Map<String, String> trimTrailing(@RequestBody Map<String, String> request) {
        String input = request.get("input");
        String result = stringTrimService.trimTrailing(input);
        return Map.of(
            "original", input != null ? input : "",
            "trimmed", result != null ? result : "",
            "operation", "trailing"
        );
    }
}
