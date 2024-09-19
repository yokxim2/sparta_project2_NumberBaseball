package grade;

import exceptions.NotAllowedDigitsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraderLv3 implements Grader {

    private int answer;
    private int digit;
    private boolean isAnswerGenerated = false;

    // 결과 저장 관련 인자
    private Map<Integer, Integer> matchHistory = new HashMap<>();
    private int currentGame = 1;
    private int attemptCount = 0;

    @Override
    public int generate() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < digit) {
            int nextNumber = (int)(Math.random() * 9) + 1;
            if (!numberList.contains(nextNumber)) {
                numberList.add(nextNumber);
            }
        }
        isAnswerGenerated = true;
        return concatAll(numberList);
    }

    @Override
    public int grade(int number, int digitNumber) {

        int strikeCount = 0;
        int ballCount = 0;
        ArrayList<Integer> answerToList = numberToList(answer);
        ArrayList<Integer> targetNumberToList = numberToList(number);

        // 게임을 새로 시작하거나, 정답을 맞춰서 Reset 된 경우에만 수행된다.
        if (!isAnswerGenerated) {
            this.digit = digitNumber;
            answer = generate();
            isAnswerGenerated = true;
        }

        attemptCount++;

        // 스트라이크, 볼 조건에 해당될 경우 카운터를 증가시킨다.
        for (int i = 0; i < targetNumberToList.size(); i++) {
            int targetNumber = targetNumberToList.get(i);
            if (answerToList.contains(targetNumber)) {
                if (answerToList.get(i) == targetNumber) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }

        // 게임 종료
        if (strikeCount == digit) {
            saveMatchHistory();
            resetGame();
        }

        printResult(strikeCount, ballCount);
        return strikeCount;
    }

    @Override
    public void getMatchHistory() {
        System.out.println(" < 게임 기록 보기 > ");
        for (int i = 1; i <= matchHistory.size(); i++) {
            System.out.println(i + "번째 게임 : 시도 횟수 - " + matchHistory.get(i));
        }
        System.out.println();
    }

    private void saveMatchHistory() {
        matchHistory.put(currentGame, attemptCount);
    }

    private void resetGame() {
        currentGame++;
        attemptCount = 0;
        isAnswerGenerated = false;
    }

    private ArrayList<Integer> numberToList(int number) {
        ArrayList<Integer> list = new ArrayList<>();

        while (number > 0) {
            list.add(0, number % 10);
            number /= 10;
        }
        return list;
    }

    private void printResult(int strikeCount, int ballCount) {
        if (strikeCount == digit) {
            System.out.println("정답입니다!");
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("아웃!");
        } else {
            System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼!");
        }
    }

    private int concatAll(List<Integer> numberList) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : numberList) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }
}