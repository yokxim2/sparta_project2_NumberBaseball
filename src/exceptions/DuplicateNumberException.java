package exceptions;

public class DuplicateNumberException extends BadInputException {
    public DuplicateNumberException() {
        super("중복되지 않는 숫자를 선택해주세요.");
    }
}
