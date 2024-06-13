package com.example.israelpx.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {

    @InjectMocks
    private ScoreService scoreService;

    @BeforeEach
    public void setUp() {
        scoreService = new ScoreService();
    }

    @Test
    public void testCalculateCombinations() {

        Assertions.assertEquals(1, scoreService.calculateCombinations("3x3"));


        Assertions.assertEquals(0, scoreService.calculateCombinations("0x2"));


        Assertions.assertEquals(1, scoreService.calculateCombinations("3x0"));


        Assertions.assertEquals(1, scoreService.calculateCombinations("0x0"));
    }

    @Test
    public void testCountCombinations() {

        Assertions.assertEquals(1, scoreService.countCombinations(3));


        Assertions.assertEquals(1, scoreService.countCombinations(0));


        Assertions.assertEquals(0, scoreService.countCombinations(-1));
    }
}
