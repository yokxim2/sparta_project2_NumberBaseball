package control;

import exceptions.BadInputException;
import grade.Grader;
import parse.UserInputParser;

public class ControllerLv1 implements Controller {

    Grader grader;
    UserInputParser parser;

    public ControllerLv1(Grader grader, UserInputParser parser) {
        this.grader = grader;
        this.parser = parser;
    }

    @Override
    public boolean checkAndScore(String userInput, int digit) throws BadInputException {
        parser.setDigit(digit);
        int input = parser.parseNumber(userInput);
        if (grader.grade(input, digit) == digit) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void getMatchHistory() {
        grader.getMatchHistory();
    }
}
