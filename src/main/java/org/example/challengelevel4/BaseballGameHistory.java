package org.example.challengelevel4;

public class BaseballGameHistory {

    private final int gameNumber;
    private final int attempts;
    private final int changeDigit;

    public BaseballGameHistory(int gameNumber, int attempts, int changeDigit) {
        this.gameNumber = gameNumber;
        this.attempts = attempts;
        this.changeDigit = changeDigit;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getChangeDigit() {
        return changeDigit;
    }

}
