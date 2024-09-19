package exceptions;

// 자리수 조절 중 의도하지 않은 값을 입력했을 때 나오는 오류 상황
public class WrongDigitInputException extends BadInputException {
    public WrongDigitInputException() {
        super("3 ~ 5 자리수 난이도 조절만 가능합니다.");
    }
}
