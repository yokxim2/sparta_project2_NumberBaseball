package scanner;

import config.GameConfig;
import control.Controller;
import exceptions.BadInputException;

import java.util.Scanner;

public class InputReaderLv4 implements InputReader {

    Controller controller;
    GameConfig gameConfig;

    public InputReaderLv4(Controller controller, GameConfig gameConfig) {
        this.controller = controller;
        this.gameConfig = gameConfig;
    }

    @Override
    public void start() {
        int digitInput = 3; // default
        Scanner scanner = new Scanner(System.in);
        System.out.println(" < 환영합니다! 원하시는 번호를 입력해주세요. > ");
        boolean gameEnd = false;
        while (!gameEnd) {
            System.out.println();
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기 >>");
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    try {
                        System.out.println("설정하고자 하는 자리수를 입력하세요.");
                        String input = scanner.nextLine();
                        gameConfig.changeDigit(input);
                        digitInput = gameConfig.getDigit();
                        gameBegin(scanner, digitInput);
                    } catch (BadInputException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "1":
                    try {
                        gameBegin(scanner, digitInput);
                    } catch (BadInputException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    controller.getMatchHistory();
                    break;
                case "3":
                    gameEnd = true;
            }
        }
    }

    private void gameBegin(Scanner scanner, int digitInput) throws BadInputException {
        while (true) {
            System.out.println("숫자를 입력하세요: " );
            String userInput = scanner.nextLine();

            if (controller.checkAndScore(userInput, digitInput)) {
                break;
            }
        }
        return;
    }
}
