import scanner.InputReader;

public class GameMain {

    InputReader inputReader;

    public GameMain(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public static void main(String[] args) {
        VersionControl vc = new VersionControl();
        GameMain game = vc.createGameMain();

        game.inputReader.start();
        System.out.println("== 게임을 종료합니다. ==");
    }
}
