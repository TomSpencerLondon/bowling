package org.example.bowling;

public class BowlingScore {
    private String roll1;
    private String roll2;
    private String roll3;
    private String roll4;
    private String roll5;
    private String roll6;
    private String roll7;
    private String roll8;
    private String roll9;
    private String roll10;
    private String roll11;
    private String roll12;
    private String roll13;
    private String roll14;
    private String roll15;
    private String roll16;
    private String roll17;
    private String roll18;
    private String roll19;
    private String roll20;
    private String roll21;

    public String getRoll1() {
        return roll1;
    }

    public String getRoll2() {
        return roll2;
    }

    public String getRoll3() {
        return roll3;
    }

    public String getRoll4() {
        return roll4;
    }

    public String getRoll5() {
        return roll5;
    }

    public String getRoll6() {
        return roll6;
    }

    public String getRoll7() {
        return roll7;
    }

    public String getRoll8() {
        return roll8;
    }

    public String getRoll9() {
        return roll9;
    }

    public String getRoll10() {
        return roll10;
    }

    public String getRoll11() {
        return roll11;
    }

    public String getRoll12() {
        return roll12;
    }

    public String getRoll13() {
        return roll13;
    }

    public String getRoll14() {
        return roll14;
    }

    public String getRoll15() {
        return roll15;
    }

    public String getRoll16() {
        return roll16;
    }

    public String getRoll17() {
        return roll17;
    }

    public String getRoll18() {
        return roll18;
    }

    public String getRoll19() {
        return roll19;
    }

    public String getRoll20() {
        return roll20;
    }

    public String getRoll21() {
        return roll21;
    }

    public void setRoll1(String roll1) {
        this.roll1 = roll1;
    }

    public void setRoll2(String roll2) {
        this.roll2 = roll2;
    }

    public void setRoll3(String roll3) {
        this.roll3 = roll3;
    }

    public void setRoll4(String roll4) {
        this.roll4 = roll4;
    }

    public void setRoll5(String roll5) {
        this.roll5 = roll5;
    }

    public void setRoll6(String roll6) {
        this.roll6 = roll6;
    }

    public void setRoll7(String roll7) {
        this.roll7 = roll7;
    }

    public void setRoll8(String roll8) {
        this.roll8 = roll8;
    }

    public void setRoll9(String roll9) {
        this.roll9 = roll9;
    }

    public void setRoll10(String roll10) {
        this.roll10 = roll10;
    }

    public void setRoll11(String roll11) {
        this.roll11 = roll11;
    }

    public void setRoll12(String roll12) {
        this.roll12 = roll12;
    }

    public void setRoll13(String roll13) {
        this.roll13 = roll13;
    }

    public void setRoll14(String roll14) {
        this.roll14 = roll14;
    }

    public void setRoll15(String roll15) {
        this.roll15 = roll15;
    }

    public void setRoll16(String roll16) {
        this.roll16 = roll16;
    }

    public void setRoll17(String roll17) {
        this.roll17 = roll17;
    }

    public void setRoll18(String roll18) {
        this.roll18 = roll18;
    }

    public void setRoll19(String roll19) {
        this.roll19 = roll19;
    }

    public void setRoll20(String roll20) {
        this.roll20 = roll20;
    }

    public void setRoll21(String roll21) {
        this.roll21 = roll21;
    }

    public String getRoll(int index) {
        return switch (index) {
            case 1 -> roll1;
            case 2 -> roll2;
            case 3 -> roll3;
            case 4 -> roll4;
            case 5 -> roll5;
            case 6 -> roll6;
            case 7 -> roll7;
            case 8 -> roll8;
            case 9 -> roll9;
            case 10 -> roll10;
            case 11 -> roll11;
            case 12 -> roll12;
            case 13 -> roll13;
            case 14 -> roll14;
            case 15 -> roll15;
            case 16 -> roll16;
            case 17 -> roll17;
            case 18 -> roll18;
            case 19 -> roll19;
            case 20 -> roll20;
            case 21 -> roll21;
            default -> null;
        };
    }

    // finalScore method concatenating the rolls manually
    public String finalScore() {
        StringBuilder score = new StringBuilder();

        for (int i = 1; i <= 21; i++) {
            String roll = getRoll(i);
            if (roll != null && !roll.isEmpty()) {
                score.append(roll);
            }
        }

        return score.toString().trim();
    }
}

