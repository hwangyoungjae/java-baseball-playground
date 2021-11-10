package baseball;

public class GameNumber {
    static final int NUMBER_LENGTH = 3;
    static final String ALLOW_CHARACTER = "123456789";

    public final String numbers;

    public GameNumber(String numbers) {
        validationNumberLength(numbers);
        validationNumberAllowCharacter(numbers);
        validationDuplicated(numbers);
        this.numbers = numbers;
    }

    public int[] match(GameNumber input) {
        int[] result = new int[]{0, 0};
        for (int i = 0; i < input.numbers.length(); i++) {
            char c = input.numbers.charAt(i);
            if (numbers.contains(String.valueOf(c))) {
                if (numbers.indexOf(c) == i) {
                    result[1] += 1;
                } else {
                    result[0] += 1;
                }
            }
        }
        return result;
    }

    private static void validationNumberLength(String numbers) {
        if (numbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("number length");
        }
    }

    private static void validationNumberAllowCharacter(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!ALLOW_CHARACTER.contains(String.valueOf(numbers.charAt(i)))) {
                throw new IllegalArgumentException("allow character");
            }
        }
    }

    private static void validationDuplicated(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            if (numbers.length() - numbers.replace(String.valueOf(c), "").length() != 1) {
                throw new IllegalArgumentException("duplicated");
            }
        }
    }

    @Override
    public String toString() {
        return "GameNumber{" +
                "numbers='" + numbers + '\'' +
                '}';
    }
}
