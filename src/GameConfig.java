import control.Controller;
import control.ControllerLv1;
import grade.Grader;
import grade.GraderLv1;
import grade.GraderLv3;
import parse.Parser;
import parse.ParserLv1;
import scanner.InputReader;
import scanner.InputReaderLv1;
import scanner.InputReaderLv2;
import scanner.InputReaderLv3;

public class GameConfig {

    public Grader createGrader() {
//        return new GraderLv1();
        return new GraderLv3();
    }

    public Parser createParser() {
        return new ParserLv1();
    }

    public Controller createController() {
        Grader grader = createGrader();
        Parser parser = createParser();
        return new ControllerLv1(grader, parser);
    }

    public InputReader createInputReader() {
        Controller controller = createController();
//        return new InputReaderLv1(controller);
//        return new InputReaderLv2(controller);
        return new InputReaderLv3(controller);
    }

    public GameMain createGameMain() {
        InputReader inputReader = createInputReader();
        return new GameMain(inputReader);
    }
}
