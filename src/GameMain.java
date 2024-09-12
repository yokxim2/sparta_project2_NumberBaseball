import java.util.Scanner;

public class GameMain {

    public static void main(String[] args) {
        Baseball player = new BaseballLv1();

        Scanner scanner = new Scanner(System.in);
        System.out.println(" < 게임을 시작합니다 > ");

        while (true) {
            System.out.print("숫자를 입력하세요: " );
            String userInput = scanner.nextLine();

            if (player.hit(userInput) == 3) {
                break;
            }
        }

        System.out.println("== 게임을 종료합니다. ==");
    }
}
