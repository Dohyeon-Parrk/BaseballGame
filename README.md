# 야구게임 프로그램 (BaseballGame)

![Java](https://img.shields.io/badge/Java-17-blue)

## 개요 (Overview)
- 컴퓨터가 생성한 3자리 숫자를 플레이어가 맞추는 게임 입니다. <br>
  각 자리는 1 에서 9 까지의 숫자가 무작위로 지정되며, 동일한 숫자는 사용 불가, 모든 자리수에 서로 다른 수를 입력하여야 합니다.
  
- 각 시도에 대해 '스트라이크'와 '볼'의 개수를 출력하여 플레이어가 숫자를 맞출 수 있도록 힌트를 출력합니다.
  - `스트라이크` : 입력값과 정답을 비교해 같은 자리에 같은 숫자가 있는 경우
  - `볼` : 숫자는 같지만, 자리는 다른 경우
  - `아웃` : 숫자도, 자리도 다른 경우 <br>
  
- #### `basiclevel` 패키지 :<br>
  기본적인 야구게임 레벨입니다. 게임 시작과, 게임 종료만 작동하고, 게임 기록 보기는 미구현된 레벨입니다.<br><br>

  ![image](https://github.com/user-attachments/assets/c395d013-e2f7-468c-9f86-df28f1eeb70f)

- #### `challengelevel3` 패키지 :<br>
  게임 기록 보기가 추가된 레벨입니다. 플레이 했던 게임들의 기록을 확인 할 수 있습니다.<br><br>

  ![image](https://github.com/user-attachments/assets/c2397c05-c7cc-44e5-a735-a775b92cce8b)

- #### `challengelevel4` 패키지 :<br>
  난이도 조절의 기능이 추가된 레벨입니다. 기본 설정은 3 자릿수이고, 난이도 설정을 4 자릿수, 5자릿수로 설정 할 수 있습니다.<br><br>

  ![image](https://github.com/user-attachments/assets/6d57b1de-0f19-414a-ab65-ae7e75005f21)


<br><br>
## 주요 기능 (Key Features)

### 1. 난이도 설정
- 게임을 시작하기 전에 **난이도(숫자 자릿수)** 를 설정할 수 있습니다.
- 사용자는 3자리, 4자리, 5자리 중에서 선택할 수 있으며, 선택한 자릿수에 맞게 게임이 진행됩니다.
- 기본 난이도는 3자리입니다. 사용자가 난이도를 선택하지 않으면 3자리 게임이 기본적으로 시작됩니다.
### 2. 정답 숫자 생성
- 1부터 9까지의 숫자 중에서 중복되지 않는 난이도에 맞는 숫자를 무작위로 생성합니다.
- 난이도에 따라 3자리, 4자리, 5자리 숫자를 랜덤으로 생성하여 게임을 진행합니다.
### 3. 입력값 검증
- 사용자가 입력한 숫자가 난이도에 맞는 자릿수인지 확인합니다.
- 중복된 숫자가 포함되거나, 숫자가 아닌 문자가 입력될 경우 오류 메시지를 출력하고 재입력을 요청합니다.
### 4. 힌트 제공
- 사용자가 입력한 숫자와 정답 숫자를 비교하여 스트라이크와 볼을 제공합니다:
  - 스트라이크: 숫자와 자리가 모두 맞는 경우.
  - 볼: 숫자는 맞지만 자리가 다른 경우.
  - 아웃: 맞는 숫자가 없는 경우.
> 예시:<br>
입력: 123, 정답: 135 -> "1 스트라이크 1 볼"<br>
입력: 789, 정답: 135 -> "아웃"
### 5. 게임 종료
- 사용자가 정답을 맞추면, 정답 메시지를 출력하고 게임이 종료됩니다.
- 정답을 맞히기까지의 시도 횟수를 기록합니다.
### 6. 기록 보기
- 각 게임에서 사용자가 정답을 맞히기까지 시도한 횟수와 게임 번호를 기록합니다.
- 게임 종료 후 사용자는 게임 기록을 확인할 수 있습니다.
-  `challengelevel4` 의 레벨에서는 난이도도 표시된 기록을 확인할 수 있습니다.
### 7. 게임 종료 옵션
- 사용자가 원할 때 게임을 종료할 수 있습니다. 게임을 종료하면, **"게임을 종료합니다"** 라는 메시지가 출력되고 프로그램이 종료됩니다.

<br><br>
## 기술 스택 (Tech Stack)

- **Java**: Java 17

