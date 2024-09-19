package exceptions;

// 모든 예외 상황의 부모 객체
public class BadInputException extends Exception {
    public BadInputException(String message) {
        super(message);
    }
}
