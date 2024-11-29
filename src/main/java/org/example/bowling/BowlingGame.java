package org.example.bowling;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BowlingGame {

    // Method to calculate the total score
    public int scoreBowling(String rolls) {
        int totalScore = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (rolls.charAt(rollIndex) == 'X') {
                totalScore += 10 + getScoreForNextTwoRolls(rolls, rollIndex + 1);
                rollIndex++;
            } else if (rolls.charAt(rollIndex + 1) == '/') {
                totalScore += 10 + getScoreForNextRoll(rolls, rollIndex + 2);
                rollIndex += 2;
            } else {
                totalScore += getScoreForNextTwoRolls(rolls, rollIndex);
                rollIndex += 2;
            }
        }
        return totalScore;
    }

    private int getScoreForNextTwoRolls(String rolls, int index) {
        int score = 0;

        char firstRoll = rolls.charAt(index);
        score += getRollScore(firstRoll);

        char secondRoll = rolls.charAt(index + 1);
        score += getRollScore(secondRoll);

        return score;
    }

    private int getScoreForNextRoll(String rolls, int index) {
        char nextRoll = rolls.charAt(index);
        return getRollScore(nextRoll);
    }

    private int getRollScore(char roll) {
        if (roll == 'X') {
            return 10;
        } else if (roll == '/') {
            return 10;
        } else if (roll == '-') {
            return 0;
        } else {
            return Character.getNumericValue(roll);
        }
    }
}
