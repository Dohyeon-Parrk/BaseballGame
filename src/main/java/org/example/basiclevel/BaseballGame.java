package org.example.basiclevel;

import java.util.*;

public class BaseballGame {

    Scanner sc = new Scanner(System.in);

    private final List<Integer> answer;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        this.answer = generateAnswer();
    }

    public void play(){
        while(true){
            // 1. 유저에게 입력값을 받음
            System.out.println("숫자를 입력하세요 (세 자리 수만 입력 가능, 같은 숫자 입력 불가, 숫자만 입력 가능)");
            String input = sc.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if(!validateInput(input)){
                System.out.println("올바르지 않는 입력값입니다.");
                continue;
            }

            // 3. 게임 진행횟수 증가

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
    }
    /* Random() 사용 */
    private List<Integer> generateAnswer(){
        Random random = new Random();
        Set<Integer> answerSet = new HashSet<>();

        while(answerSet.size() < 3){
            int randomNum = random.nextInt(9);
            answerSet.add(randomNum);
        }
        return new ArrayList<>(answerSet);
    }

    /* Collections.shuffle() 사용 */
//    private List<Integer> generateAnswer(){
//        List<Integer> randomNum = new ArrayList<>();
//        for (int i = 1; i <= 9; i++) {
//            randomNum.add(i);
//        }
//        Collections.shuffle(randomNum);
//        return randomNum.subList(0, 3);-++ 
//    }

    // 2. 올바른 입력값을 받았는지 검증
    protected boolean validateInput(String input) {
        if(input.length() != 3){
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
        for(int i = 0; i < 3; i++){
            if(answer.get(i) == Character.getNumericValue(input.charAt(i))){
                strike++;
            }
        }
        return strike;
    }

    // 볼 개수
    private int countBall(String input) {
        int ball = 0;
        for(int i = 0; i < 3; i++){
            if(answer.contains(Character.getNumericValue(input.charAt(i)))){
                ball++;
            }
        }
        return ball;
    }

}
