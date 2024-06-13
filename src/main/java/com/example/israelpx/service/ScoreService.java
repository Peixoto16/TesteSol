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

    public int countCombinations(int score) {
        if (score < 0) {
            return 0;
        }

        int[] combinations = new int[score + 1];

        combinations[0] = 1;

        int[] posivePlays = {3, 6, 7, 8};

        for (int play : posivePlays) {
            for (int i = play; i <= score; i++) {
                combinations[i] += combinations[i - play];
            }
        }

        return combinations[score];
    }
}

