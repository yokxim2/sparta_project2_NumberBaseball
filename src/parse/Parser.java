package parse;

import exceptions.BadInputException;

public interface Parser {
    int parseNumber(String input) throws BadInputException;
}
