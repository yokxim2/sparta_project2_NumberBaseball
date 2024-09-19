package scanner;

import control.Controller;

import java.util.Scanner;

public class InputReaderLv1 implements InputReader {

    Controller controller;

    public InputReaderLv1(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() {
        int digitInput = 3; // default
        Scanner scanner = new Scanner(System.in);
        System.out.println(" < 게임을 시작합니다 > ");

        while (true) {
            System.out.print("숫자를 입력하세요: " );
            String userInput = scanner.nextLine();

            if (!controller.checkAndScore(userInput, digitInput)) {
                break;
            }
        }
    }
}
