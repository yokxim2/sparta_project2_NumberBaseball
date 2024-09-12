package exceptions;

public class NegativeNumberException extends BadInputException {
    public NegativeNumberException() {
        super("양수를 적어주세요.");
    }
}
