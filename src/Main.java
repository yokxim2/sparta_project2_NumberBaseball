import scanner.InputReader;

public class Main {

    private final InputReader inputReader;

    public Main(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public static void main(String[] args) {
        VersionControl vc = new VersionControl();
        Main game = vc.createMain();

        game.inputReader.start();
        System.out.println("== 게임을 종료합니다. ==");
    }
}
