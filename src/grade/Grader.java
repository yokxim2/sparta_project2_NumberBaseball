package grade;

import exceptions.NotAllowedDigitsException;

// 정답을 생성하고, 입력값과 일치하는지 확인한다. 또 게임 기록을 저장한다.
public interface Grader {
    int generate();
    int grade(int number, int digit) throws NotAllowedDigitsException;
    void getMatchHistory();
}
