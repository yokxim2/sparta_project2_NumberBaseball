import generate.Generator;
import generate.GeneratorLv1;
import grade.Grader;
import grade.GraderLv1;
import parse.Parser;
import parse.ParserLv1;

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

    public Baseball createBaseball() {
        Grader grader = createGrader();
        Parser parser = createParser();
        return new BaseballLv1(grader, parser);
    }

    public GameMain createGameMain() {
        Baseball baseball = createBaseball();
        return new GameMain(baseball);
    }
}
