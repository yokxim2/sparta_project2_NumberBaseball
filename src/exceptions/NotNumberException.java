package exceptions;

// 입력값이 숫자가 아닐 시 발생하는 오류 상황
public class NotNumberException extends BadInputException {
    public NotNumberException() {
        super("숫자를 입력해주세요.");
    }
}
