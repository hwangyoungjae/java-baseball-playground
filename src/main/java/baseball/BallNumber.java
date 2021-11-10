package baseball;

import baseball.exceptions.InvalidArgumentError;

public class BallNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int number;

    public BallNumber(int number) throws InvalidArgumentError {
        validation(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validation(int n) throws InvalidArgumentError {
        if (n < MIN_NUMBER || n > MAX_NUMBER) {
            throw new InvalidArgumentError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BallNumber that = (BallNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
