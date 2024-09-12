import exceptions.BadInputException;
import grade.Grader;
import grade.GraderLv1;
import parse.Parser;
import parse.ParserLv1;

public class BaseballLv1 implements Baseball {

    Grader grader;
    Parser parser;

    public BaseballLv1(Grader grader, Parser parser) {
        this.grader = grader;
        this.parser = parser;
    }

    @Override
    public int hit(String userInput) {
        try {
            int inputInt = parser.parseNumber(userInput);
            return grader.grade(inputInt);
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
