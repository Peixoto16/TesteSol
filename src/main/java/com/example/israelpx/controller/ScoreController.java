package com.example.israelpx.controller;

import com.example.israelpx.model.Score;
import com.example.israelpx.dto.ScoreResponse;
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
    public ResponseEntity<ScoreResponse> verifyScore(@RequestBody Score scoreRequest) {
        int combinations = scoreService.calculateCombinations(scoreRequest.getScore());
        return ResponseEntity.ok(new ScoreResponse(combinations));
    }

}
