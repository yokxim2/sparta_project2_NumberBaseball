package exceptions;

// 올바르지 않은 자릿수 숫자를 입력했을 시 발생하는 오류 상황
public class NotAllowedDigitsException extends BadInputException {
    public NotAllowedDigitsException(int digit) {
        super("자릿수가 일치하지 않습니다. " + digit + "자리 숫자를 입력해주세요.");
    }
}
