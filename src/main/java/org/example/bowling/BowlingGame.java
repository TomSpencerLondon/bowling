package org.example.bowling;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BowlingGame {

    public int scoreBowling(String rolls) {
        int totalScore = 0;
        int rollIndex = 0;

        // Validate the input string
        if (!isValidBowlingInput(rolls)) {
            throw new IllegalBowlingArgumentException(List.of(
                    "Invalid input format. Correct format:",
                    "X for strike",
                    "/ for spare",
                    "Numbers 0-9 for open frames",
                    "Example: X9-9-X9-/..."
            ));
        }

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
        int firstRollScore = getRollScore(firstRoll);
        char secondRoll = rolls.charAt(index + 1);
        int secondRollScore = getRollScore(secondRoll);

        if (firstRollScore != 10 && !acceptableNormalScore(firstRollScore, secondRollScore)) {
            throw new IllegalBowlingArgumentException(List.of(
                    "Invalid input format. Correct format:",
                    "X for strike",
                    "/ for spare",
                    "Numbers 0-9 for open frames",
                    "Example: X9-9-X9-/..."
            ));
        }

        score += firstRollScore;
        score += secondRollScore;

        return score;
    }

    private static boolean acceptableNormalScore(int firstRollScore, int secondRollScore) {
        return 10 - (firstRollScore + secondRollScore) > 0;
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


    private boolean isValidBowlingInput(String rolls) {
        // Validate the length of the rolls (between 12 and 21)
        if (rolls == null || rolls.length() < 12 || rolls.length() > 21) {
            return false;
        }

        return rolls.matches("^[0-9X/-]*$");
    }




}
