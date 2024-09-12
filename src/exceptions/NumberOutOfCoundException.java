package exceptions;

public class NumberOutOfCoundException extends BadInputException {
    public NumberOutOfCoundException() {
        super("1 ~ 9 사이의 숫자를 입력해 주세요.");
    }
}
