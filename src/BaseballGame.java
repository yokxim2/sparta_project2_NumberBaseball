public class BaseballGame {

    public static void main(String[] args) {
        GameFactory game = new GameFactory();

        game.start();
        System.out.println("== 게임을 종료합니다. ==");
    }
}
