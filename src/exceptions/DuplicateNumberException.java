package exceptions;

// 중복된 숫자를 사용했을 때 발생하는 오류 상황
public class DuplicateNumberException extends BadInputException {
    public DuplicateNumberException() {
        super("중복되지 않는 숫자를 선택해주세요.");
    }
}
