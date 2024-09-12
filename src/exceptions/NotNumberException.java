package exceptions;

public class NotNumberException extends BadInputException {
    public NotNumberException() {
        super("숫자를 입력해주세요.");
    }
}
