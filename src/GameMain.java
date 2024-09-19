import scanner.InputReader;

public class GameMain {

    InputReader inputReader;

    public GameMain(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public static void main(String[] args) {
        GameConfig config = new GameConfig();
        GameMain game = config.createGameMain();

        game.inputReader.start();
        System.out.println("== 게임을 종료합니다. ==");3
    }
}
