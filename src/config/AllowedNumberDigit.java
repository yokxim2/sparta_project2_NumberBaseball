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

    public static AllowedNumberDigit contains(int numberDigit) {
        for (AllowedNumberDigit value : AllowedNumberDigit.values()) {
            if (value.getNumberDigit() == numberDigit) {
                return value;
            }
        }
        return null;
    }
}
