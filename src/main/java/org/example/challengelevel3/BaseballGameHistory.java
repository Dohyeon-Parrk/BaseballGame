package org.example.challengelevel3;

public class BaseballGameHistory {

    private final int gameNumber;
    private final int attempts;

    public BaseballGameHistory(int gameNumber, int attempts) {
        this.gameNumber = gameNumber;
        this.attempts = attempts;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public int getAttempts() {
        return attempts;
    }

}
