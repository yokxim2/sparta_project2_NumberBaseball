import java.util.Scanner;

public class GameMain {

    private final Baseball baseBall;

    public GameMain(Baseball baseBall) {
        this.baseBall = baseBall;
    }

    public static void main(String[] args) {
        GameConfig config = new GameConfig();
        GameMain game = config.setUpGameMain();

        Scanner scanner = new Scanner(System.in);
        System.out.println(" < 게임을 시작합니다 > ");

        while (true) {
            System.out.print("숫자를 입력하세요: " );
            String userInput = scanner.nextLine();

            if (game.baseBall.hit(userInput) == 3) {
                break;
            }
        }

        System.out.println("== 게임을 종료합니다. ==");
    }
}
