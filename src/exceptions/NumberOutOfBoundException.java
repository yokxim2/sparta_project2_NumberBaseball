package exceptions;

public class NumberOutOfBoundException extends BadInputException {
    public NumberOutOfBoundException() {
        super("1 ~ 9 사이의 숫자를 입력해 주세요.");
    }
}
