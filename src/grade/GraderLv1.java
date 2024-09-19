package grade;

import java.util.ArrayList;
import java.util.List;

public class GraderLv1 implements Grader {

    private final int answer;

    public GraderLv1() {
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
    public int grade(int number, int digit) {
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
        printResult(strikeCount, ballCount);
        return strikeCount;
    }

    @Override
    public void getMatchHistory() {
        System.out.println("구현하지 않는 기능입니다.");
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
        if (strikeCount == 3) {
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
