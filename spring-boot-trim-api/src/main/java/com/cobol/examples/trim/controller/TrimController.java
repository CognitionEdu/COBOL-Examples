package com.cobol.examples.trim.controller;

import com.cobol.examples.trim.dto.TrimRequest;
import com.cobol.examples.trim.dto.TrimResponse;
import com.cobol.examples.trim.service.TrimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trim")
@CrossOrigin(origins = "*")
public class TrimController {

    private final TrimService trimService;

    @Autowired
    public TrimController(TrimService trimService) {
        this.trimService = trimService;
    }

    @PostMapping("/both")
    public ResponseEntity<TrimResponse> trimBoth(@Valid @RequestBody TrimRequest request) {
        String trimmed = trimService.trimBoth(request.getInput());
        TrimResponse response = new TrimResponse(request.getInput(), trimmed, "both");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/leading")
    public ResponseEntity<TrimResponse> trimLeading(@Valid @RequestBody TrimRequest request) {
        String trimmed = trimService.trimLeading(request.getInput());
        TrimResponse response = new TrimResponse(request.getInput(), trimmed, "leading");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/trailing")
    public ResponseEntity<TrimResponse> trimTrailing(@Valid @RequestBody TrimRequest request) {
        String trimmed = trimService.trimTrailing(request.getInput());
        TrimResponse response = new TrimResponse(request.getInput(), trimmed, "trailing");
        return ResponseEntity.ok(response);
    }
}
