package exceptions;

// 음수를 입력했을 때 발생하는 오류 상황
public class NegativeNumberException extends BadInputException {
    public NegativeNumberException() {
        super("양수를 적어주세요.");
    }
}
