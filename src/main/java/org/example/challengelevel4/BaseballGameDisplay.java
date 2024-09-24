package org.example.challengelevel4;

public class BaseballGameDisplay {

    public static void displayHint(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("아웃");
        } else {
            System.out.println(strike + " 스트라이크 " + ball + " 볼 " );
        }
    }

    public static void displayHistory(BaseballGameHistory history){
        System.out.println(history.getGameNumber() + " 번 게임( " + history.getChangeDigit() + "난이도 ) : 시도 횟수 " + history.getAttempts() + "회");
    }
}
