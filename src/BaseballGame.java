import scanner.InputReader;

public class BaseballGame {

    private final InputReader inputReader;

    public BaseballGame(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public static void main(String[] args) {
        VersionControl vc = new VersionControl();
        BaseballGame game = vc.createMain();

        game.inputReader.start();
        System.out.println("== 게임을 종료합니다. ==");
    }
}
