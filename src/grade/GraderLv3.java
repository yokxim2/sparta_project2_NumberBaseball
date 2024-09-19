package grade;

import exceptions.NotAllowedDigitsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraderLv3 implements Grader {

    private int answer;
    private int digit;
    private Map<Integer, Integer> matchHistory = new HashMap<>();

    private int currentGame = 1;
    private int attemptCount = 0;

    public GraderLv3() {
        this.answer = generate();
    }

    @Override
    public int generate() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int nextNumber = (int)(Math.random() * 9) + 1;
            if (!numberList.contains(nextNumber)) {
                numberList.add(nextNumber);
            }
        }
        return concatAll(numberList);
    }

    @Override
    public int grade(int number, int digit) throws NotAllowedDigitsException {
        this.digit = digit;
        validateDigitCount(number);
        attemptCount++;
        int strikeCount = 0;
        int ballCount = 0;
        ArrayList<Integer> answerToList = numberToList(answer);
        ArrayList<Integer> targetNumberToList = numberToList(number);
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

    private void validateDigitCount(int number) throws NotAllowedDigitsException {
        String numberStr = Integer.toString(number);
        if (numberStr.length() != digit) {
            throw new NotAllowedDigitsException(digit);
        }
    }

    private void saveMatchHistory() {
        matchHistory.put(currentGame, attemptCount);
    }

    private void resetGame() {
        currentGame++;
        attemptCount = 0;
        answer = generate();
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
