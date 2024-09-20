package parse;

import exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class UserInputParserLv1 implements UserInputParser {

    private int digit = 3;

    @Override
    public int parseNumber(String input) throws BadInputException {
        int number = validateIfPureNumber(input);           // 숫자로 이루어져 있는가?
        validateIfPositiveNumber(number);                   // 값이 음수인가?
        validateZeroNeverUsed(number);                      // 1 ~ 9 사이 숫자가 사용되었는가?
        validateIfDuplicateNumberUsed(number);              // 연속되어 같은 숫자가 사용되었는가?
        validateDigitCount(number);                         // 알맞은 자리수가 입력되었는가?

        return number;
    }

    private int validateIfPureNumber(String input) throws NotNumberException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    private void validateIfPositiveNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException();
        }
    }

    private void validateZeroNeverUsed(int number) throws NumberOutOfBoundException {
        int num = number;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                throw new NumberOutOfBoundException();
            }
            num /= 10;
        }
    }

    private void validateIfDuplicateNumberUsed(int number) throws DuplicateNumberException {
        List<Integer> numberList = new ArrayList<>();
        int num = number;
        while (num > 0) {
            int digit = num % 10;
            if (numberList.contains(digit)) {
                throw new DuplicateNumberException();
            } else {
                numberList.add(digit);
            }
            num /= 10;
        }
    }

    private void validateDigitCount(int number) throws NotAllowedDigitsException {
        String numberStr = Integer.toString(number);
        if (numberStr.length() != digit) {
            throw new NotAllowedDigitsException(digit);
        }
    }

    @Override
    public void setDigit(int digit) {
        this.digit = digit;
    }
}
