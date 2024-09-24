package org.example.challengelevel4;

import java.util.*;

public class BaseballGame {

    Scanner sc = new Scanner(System.in);

    private List<Integer> answer;
    private int gameNumber = 1;
    private final List<BaseballGameHistory> history = new ArrayList<>();
    private Integer changeDigit = null;

    public void setChangeDigit(){
        System.out.println("난이도를 선택하세요 : 3, 4, 5 선택 가능");

        while(true){
            String input = sc.nextLine();
            try{
                changeDigit = Integer.parseInt(input);
                if(changeDigit == 3 || changeDigit == 4 || changeDigit == 5){
                    break;
                } else {
                    System.out.println("올바르지 않는 입력값입니다.");
                }
            } catch (Exception e){
                System.out.println("3, 4, 5 만 선택 가능합니다.");
            }
        }

        System.out.println(changeDigit + " 자리수 난이도로 설정되었습니다.");
        play();
    }

    public void play(){

        // 0. 난이도 설정않고 게임 바로 시작 시 기본 3자리로 시작
        if(changeDigit == null){
            changeDigit = 3;
            System.out.println("기본 자리수 난이도인 3 으로 시작합니다.");
        }

        int attempts = 0;
        answer = generateAnswer(changeDigit);

        while(true){

            // 1. 유저에게 입력값을 받음
            System.out.println("숫자를 입력하세요 ");
            System.out.println("(" + changeDigit + "자리 수만 입력 가능, 같은 숫자 입력 불가, 숫자만 입력 가능)");

            String input = sc.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if(!validateInput(input, changeDigit)){
                System.out.println("올바르지 않는 입력값입니다.");
                continue;
            }

            // 3. 게임 진행횟수 증가
            attempts++;

            // 4. 스트라이크 개수 계산
            int strike = countStrike(input);
            // 6. 볼 개수 계산
            int ball = countBall(input) - strike;

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if(strike == 3){
                System.out.println("★★★★★정답입니다★★★★★");
                break;
            }

            // 7. 힌트 출력
            BaseballGameDisplay.displayHint(strike, ball);
        }

        history.add(new BaseballGameHistory(gameNumber, attempts, changeDigit));
        gameNumber++;
    }

    // 1. Random() 사용하여 정답 생성
    private List<Integer> generateAnswer(int changeDigit){
        Random random = new Random();
        Set<Integer> answerSet = new HashSet<>();

        for (int i = 1; answerSet.size() < changeDigit; i++) {
            int randomNum = random.nextInt(9) + 1;
            answerSet.add(randomNum);
        }
        return new ArrayList<>(answerSet);
    }

    // 1. Collections.shuffle() 사용하여 정답 생성
//    private List<Integer> generateAnswer(int changeDigit){
//        List<Integer> answerList = new ArrayList<>();
//
//        for (int i = 1; i <= 9; i++) {
//            answerList.add(i);
//        }
//        Collections.shuffle(answerList);
//        return answerList.subList(0, 3);
//    }

    // 2. 올바른 입력값을 받았는지 검증
    protected boolean validateInput(String input, int changeDigit) {
        if(input.length() != changeDigit){
            return false;
        }

        Set<Character> set = new HashSet<>();
        for(char i : input.toCharArray()){
            if(!Character.isDigit(i) || i == '0'){
                return false;
            }
            if(!set.add(i)){
                return false;
            }
        }
        return true;
    }

    // 스트라이크 개수
    private int countStrike(String input) {
        int strike = 0;
        for(int i = 0; i < changeDigit; i++){
            if(answer.get(i) == Character.getNumericValue(input.charAt(i))){
                strike++;
            }
        }
        return strike;
    }

    // 볼 개수
    private int countBall(String input) {
        int ball = 0;
        for(int i = 0; i < changeDigit; i++){
            if(answer.contains(Character.getNumericValue(input.charAt(i)))){
                ball++;
            }
        }
        return ball;
    }

    // 기록 보기
    public void getHistory(){
        if(history.isEmpty()){
            System.out.println(" 기록이 없습니다. ");
        } else {
            for(BaseballGameHistory h : history){
                BaseballGameDisplay.displayHistory(h);
            }
        }
    }
}
