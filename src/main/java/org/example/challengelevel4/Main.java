package org.example.challengelevel4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BaseballGame game = new BaseballGame();

        while(true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("★★★★★ [숫자 야구 게임에 오신것을 환영합니다] ★★★★★");
            System.out.println(" <원하시는 숫자를 입력하여 진행해 주세요> ");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            System.out.println("-----------------------------------------------------");

            String input = sc.nextLine();

            // if 문 사용
            if(input.equals("1")) {
                System.out.println(" < 게임을 시작합니다 > ");
                game.play();
            } else if(input.equals("2")) {
                System.out.println(" < 게임 기록 >");
                game.getHistory();
            } else if(input.equals("3")) {
                System.out.println(" < 게임을 종료합니다 > ");
                return;
            } else if(input.equals("0")) {
                System.out.println(" < 설정하고자 하는 자리수를 입력하세요 > ");
                game.setChangeDigit();
            } else {
                System.out.println("올바르지 않는 입력값입니다.");
            }

            // switch 문 사용
//            switch (input) {
//                case "0":
//                    System.out.println(" < 설정하고자 하는 자리수를 입력하세요 > ");
//                    game.setChangeDigit();
//                    break;
//
//                case "1":
//                    System.out.println(" <게임을 시작합니다> ");
//                    game.play();
//                    break;
//
//                case "2":
//                    System.out.println(" < 게임 기록 >");
//                    game.getHistory();
//                    break;
//
//                case "3":
//                    System.out.println(" <게임을 종료합니다> ");
//                    return;
//
//                default:
//                    System.out.println("올바르지 않는 입력값입니다.");
//                    break;
//            }
        }
    }
}