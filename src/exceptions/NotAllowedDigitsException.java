package exceptions;

public class NotAllowedDigitsException extends BadInputException {
    public NotAllowedDigitsException(int digit) {
        super("자릿수가 일치하지 않습니다. " + digit + "자리 숫자를 입력해주세요.");
    }
}
