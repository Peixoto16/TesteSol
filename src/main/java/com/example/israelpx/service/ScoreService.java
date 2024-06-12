package com.example.israelpx.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    public int calculateCombinations(String score) {
        String[] parts = score.split("x");
        int homeScore = Integer.parseInt(parts[0]);
        int awayScore = Integer.parseInt(parts[1]);

        return countCombinations(homeScore) * countCombinations(awayScore);
    }

    private int countCombinations(int score) {

    }
}

