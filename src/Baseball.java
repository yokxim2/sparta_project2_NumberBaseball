import exceptions.BadInputException;

public interface Baseball {
    int hit(String userInput) throws BadInputException;
}
