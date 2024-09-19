package exceptions;

// 0을 입력했을 때 나오는 오류 상황
public class NumberOutOfBoundException extends BadInputException {
    public NumberOutOfBoundException() {
        super("1 ~ 9 사이의 숫자를 입력해 주세요.");
    }
}
