package grade;

import generate.Generator;
import generate.GeneratorLv1;

import java.util.ArrayList;

public class GraderLv1 implements Grader {

    Generator generator;
    private final int answer;

    public GraderLv1(Generator generator) {
        this.generator = generator;
        this.answer = generator.generate();
    }

    @Override
    public int grade(int number) {
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
}
