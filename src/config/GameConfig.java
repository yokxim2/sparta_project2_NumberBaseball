package config;

import exceptions.BadInputException;
import exceptions.NotNumberException;
import exceptions.WrongDigitInputException;

// 환경설정 담당 객체, 지금은 자릿수 변경 기능만 있음. 확장성 고려 추가 변동 여지 있음
public class GameConfig {
    // 자릿수
    private int digit = 3;

    public int getDigit() {
        return digit;
    }

    public void changeDigit(String input) throws BadInputException {
        try {
            digit = Integer.parseInt(input);
            AllowedNumberDigit numberDigit = AllowedNumberDigit.contains(digit);

            if (numberDigit == null) {
                throw new WrongDigitInputException();
            } else {
                System.out.println(numberDigit.getNumberDigit() + "자리수 난이도로 설정되었습니다.");
            }
        } catch (NumberFormatException e) {
            throw new NotNumberException();
        }
    }
}
