package org.example.bowling;

import org.assertj.core.api.ThrowableAssertAlternative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void allSpares() {
        String rolls = "5/5/5/5/5/5/5/5/5/5/5";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(150);
    }

    @Test
    void allSparesAgain() {
        String rolls = "9/9/9/9/9/9/9/9/9/9/1";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score)
                .isEqualTo(182);
    }

    @Test
    void alternateStrikesAndOpenFrames() {
        String rolls = "X9-9-X9-9-X9-9-X9-";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(130);
    }

    @Test
    void strikeAndMissesAlternate() {
        String rolls = "X9-9-X9-9-X9-9-9-";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(120);
    }

    @Test
    void allOnesOnEachFrame() {
        String rolls = "1-1-1-1-1-1-1-1-1-1-";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(10);
    }

    @Test
    void sparesAndSomeOpenFrames() {
        String rolls = "1-1-1-1-1-1-1-1-1-1-";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(10);
    }

    @Test
    void allOnesOnEachRoll() {
        String rolls = "11111111111111111111";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(20);
    }

    @Test
    void sparesWithOpenFrames() {
        String rolls = "5/5/5-5/5-5-5/5-5-5/-";
        int score = bowlingGame.scoreBowling(rolls);

        assertThat(score).isEqualTo(95);
    }

    @Test
    void testInvalidCharacterInInput() {
        String rolls = "X9-9-X9-9-X9-9-X9-9@";  // Invalid character '@'
        // Use a try-catch block to explicitly capture the exception
        try {
            bowlingGame.scoreBowling(rolls);
            fail("Expected an IllegalBowlingArgumentException to be thrown");
        } catch (IllegalBowlingArgumentException ex) {
            // Assert the error messages in the exception
            assertThat(ex.getErrorMessages()).containsExactly(
                    "Invalid input format. Correct format:",
                    "X for strike",
                    "/ for spare",
                    "Numbers 0-9 for open frames",
                    "Example: X9-9-X9-/..."
            );
        }
    }

    @Test
    void testTooManyFrames() {
        String rolls = "X9-9-X9-9-X9-9-X9-9-X9-9-X9";  // Too many frames (11 frames)
        // Use a try-catch block to explicitly capture the exception
        try {
            bowlingGame.scoreBowling(rolls);
            fail("Expected an IllegalBowlingArgumentException to be thrown");
        } catch (IllegalBowlingArgumentException ex) {
            // Assert the error messages in the exception
            assertThat(ex.getErrorMessages()).containsExactly(
                    "Invalid input format. Correct format:",
                    "X for strike",
                    "/ for spare",
                    "Numbers 0-9 for open frames",
                    "Example: X9-9-X9-/..."
            );
        }
    }

}
