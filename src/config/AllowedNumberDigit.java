package config;

public enum AllowedNumberDigit {
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int numberDigit;

    AllowedNumberDigit(int numberDigit) {
        this.numberDigit = numberDigit;
    }

    public int getNumberDigit() {
        return numberDigit;
    }

    // 자리수가 허가된 범위 내에 있는지 조사하고, 일치하지 않을 시 Null을 반환하도록 있도록 했다. (기본형 int를 반환형으로 하지 않은 이유)
    public static AllowedNumberDigit contains(int numberDigit) {
        for (AllowedNumberDigit value : AllowedNumberDigit.values()) {
            if (value.getNumberDigit() == numberDigit) {
                return value;
            }
        }
        return null;
    }
}
