import config.GameConfig;
import control.Controller;
import control.ControllerLv1;
import grade.Grader;
import grade.GraderLv3;
import parse.UserInputParser;
import parse.UserInputParserLv1;
import scanner.*;

// 버전 관리 및 객체들의 생성자 주입을 담당하는 클래스
public class VersionControl {


    public Grader createGrader() {
//        return new GraderLv1();           // Lv 1 ~ Lv 2
        return new GraderLv3();             // Lv 3 ~ Lv 4
    }

    public UserInputParser createParser() {
        return new UserInputParserLv1();    // Lv 1 ~ Lv 4
    }

    public Controller createController() {
        Grader grader = createGrader();
        UserInputParser parser = createParser();
        return new ControllerLv1(grader, parser);   // Lv 1 ~ Lv 4
    }

    public GameConfig gameConfig() {
        return new GameConfig();            // Lv 1 ~ Lv 4
    }

    public InputReader createInputReader() {
        Controller controller = createController();
        GameConfig gameConfig = gameConfig();
//        return new InputReaderLv1(controller);            // Lv 1
//        return new InputReaderLv2(controller);            // Lv 2
//        return new InputReaderLv3(controller);            // Lv 3
        return new InputReaderLv4(controller, gameConfig);  // Lv 4
    }

    public GameMain createGameMain() {
        InputReader inputReader = createInputReader();
        return new GameMain(inputReader);   // Lv 1 ~ Lv 4
    }
}
