import parse.Parser;
import parse.ParserLv1;

import java.util.Scanner;

public class BaseballLv1 implements Baseball {

    Parser parser = new ParserLv1();

    @Override
    public int hit(String userInput) {
        int inputInt = parser.parseNumber(userInput);
    }
}
