import exceptions.BadInputException;
import grade.Grader;
import grade.GraderLv1;
import parse.Parser;
import parse.ParserLv1;

import java.util.Scanner;

public class BaseballLv1 implements Baseball {

    Parser parser = new ParserLv1();
    Grader grader = new GraderLv1();

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
