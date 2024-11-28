package org.example.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void testAllStrikes() {
        String rolls = "XXXXXXXXXXXX";

        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score)
                .isEqualTo(300);
    }
}
