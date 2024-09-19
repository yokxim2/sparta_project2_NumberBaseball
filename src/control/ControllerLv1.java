package control;

import exceptions.BadInputException;
import grade.Grader;
import grade.GraderLv3;
import parse.Parser;

public class ControllerLv1 implements Controller {

    Grader grader;
    Parser parser;

    public ControllerLv1(Grader grader, Parser parser) {
        this.grader = grader;
        this.parser = parser;
    }

    @Override
    public boolean checkAndScore(String userInput, String digitInput) {
        try {
            int digit = parser.parseNumber(digitInput);
            int input = parser.parseNumber(userInput);
            if (grader.grade(input, digit) == digit) {
                return true;
            } else {
                return false;
            }
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void getMatchHistory() {
        grader.getMatchHistory();
    }
}
