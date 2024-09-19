package grade;

import exceptions.NotAllowedDigitsException;

public interface Grader {
    int generate();
    int grade(int number, int digit) throws NotAllowedDigitsException;
    void getMatchHistory();
}
