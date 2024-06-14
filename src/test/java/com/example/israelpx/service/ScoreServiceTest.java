package com.example.israelpx.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Pode dar alguns warnings, mais sao so avisos.
public class ScoreServiceTest {

    @InjectMocks
    private ScoreService scoreService;

    @BeforeEach
    public void setUp() {
        scoreService = new ScoreService();
    }

    @Test
    public void testCalculateCombinations() {
        // Uma pontuação válida
        Assertions.assertEquals(1, scoreService.calculateCombinations("3x3"));

        // Uma pontuação onde uma das equipes não marcou pontos
        Assertions.assertEquals(0, scoreService.calculateCombinations("0x2"));

        // uma pontuação onde uma das equipes marcou zero pontos
        Assertions.assertEquals(1, scoreService.calculateCombinations("3x0"));

        // Uma pontuação onde ambas as equipes não marcaram pontos
        Assertions.assertEquals(1, scoreService.calculateCombinations("0x0"));
    }

    @Test
    public void testCountCombinations() {
        // Pontuação válida
        Assertions.assertEquals(1, scoreService.countCombinations(3));

        // Pontuação zero
        Assertions.assertEquals(1, scoreService.countCombinations(0));

        //Pontuação negativa
        Assertions.assertEquals(0, scoreService.countCombinations(-1));
    }

    @Test
    public void testCountCombinationsWithCache() {
        // Verifica se a combinação é calculada corretamente e armazenada no cache
        Assertions.assertEquals(2, scoreService.countCombinations(6));
        Assertions.assertTrue(scoreService.getCache().containsKey(6));

        // Verifica se o valor armazenado no cache é reutilizado
        Assertions.assertEquals(2, scoreService.countCombinations(6));
    }

}
