package com.example.israelpx.controller;

import com.example.israelpx.model.ScoreRequest;
import com.example.israelpx.model.ScoreResponse;
import com.example.israelpx.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/verify")
    public ResponseEntity<?> verifyScore(@RequestBody ScoreRequest scoreRequest) {
        int combinations = scoreService.calculateCombinations(scoreRequest.getScore());
        return ResponseEntity.ok(new ScoreResponse(combinations));
    }

}
