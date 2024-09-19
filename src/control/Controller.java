package control;

import exceptions.BadInputException;

// Grader와 UserInputParser를 적절히 사용한다.
public interface Controller {
    boolean checkAndScore(String input, int digit) throws BadInputException;
    void getMatchHistory();
}
