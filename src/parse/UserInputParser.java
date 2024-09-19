package parse;

import exceptions.BadInputException;

// 입력값의 유효성을 판단하고, 예외 상황이 발생하지 않을 시 int를 반환하는 클래스
public interface UserInputParser {
    void setDigit(int digit);
    int parseNumber(String input) throws BadInputException;
}
