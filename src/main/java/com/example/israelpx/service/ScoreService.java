package com.example.israelpx.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScoreService {

    private final Map<Integer, Integer> cache = new HashMap<>();
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

        // Armazena todas as combinações possíveis de pontuações de 0 até totalPontos
        int[] combinations = new int[score + 1];

        //  A única forma de acabar com 0 pontos é não realizar nenhuma jogada
        combinations[0] = 1;

        // Pontos de jogada
        int[] posivePlays = {3, 6, 7, 8};

        // Adiciona as combinações complementares para cada jogada possível
        // Sempre adiciona 0 para pontuações impossíveis
        for (int play : posivePlays) {
            for (int i = play; i <= score; i++) {
                combinations[i] += combinations[i - play];
            }
        }

        cache.put(score, combinations[score]);

        return combinations[score];
    }

    // Método para Teste
    public Map<Integer, Integer> getCache() {
        return cache;
    }

}

