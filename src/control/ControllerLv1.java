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

    public int hit(String userInput) {          // 여기서 몇 스트라이크인지 아예 처리!! 차라리 Grader안에서 터트리는 것도 나쁘지 않은듯
        try {
            return grader.grade(parser.parseNumber(userInput));
        } catch (BadInputException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public void getMatchHistory() {
        grader.getMatchHistory();
    }
}
