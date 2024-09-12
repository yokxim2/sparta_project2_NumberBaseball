import control.Controller;
import control.ControllerLv1;
import generate.Generator;
import generate.GeneratorLv1;
import grade.Grader;
import grade.GraderLv1;
import parse.Parser;
import parse.ParserLv1;
import scanner.InputReader;
import scanner.InputReaderLv1;

public class GameConfig {
    public Generator createGenerator() {
        return new GeneratorLv1();
    }

    public Grader createGrader() {
        Generator generator = createGenerator();
        return new GraderLv1(generator);
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
        return new InputReaderLv1(controller);
    }

    public GameMain createGameMain() {
        InputReader inputReader = createInputReader();
        return new GameMain(inputReader);
    }
}
