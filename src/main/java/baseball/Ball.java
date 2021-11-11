package baseball;

import baseball.exceptions.InvalidBallNumberError;
import baseball.exceptions.InvalidBallPositionError;

public class Ball {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private final int position;
    private final int number;

    public Ball(int position, int number) throws InvalidBallPositionError, InvalidBallNumberError {
        validationPosition(position);
        validationNumber(number);
        this.position = position;
        this.number = number;
    }

    private void validationPosition(int value) throws InvalidBallPositionError {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new InvalidBallPositionError();
        }
    }

    private void validationNumber(int value) throws InvalidBallNumberError {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new InvalidBallNumberError();
        }
    }

    public BallMatchResult match(Ball userBall) {
        if (equals(userBall)) return BallMatchResult.STRIKE;
        if (equalsOfNumber(userBall)) return BallMatchResult.BALL;
        return BallMatchResult.NOTHING;
    }

    public boolean equals(Ball userBall) {
        return equalsOfPosition(userBall) && equalsOfNumber(userBall);
    }

    public boolean equalsOfPosition(Ball userBall) {
        return this.getPosition() == userBall.getPosition();
    }

    public boolean equalsOfNumber(Ball userBall) {
        return this.getNumber() == userBall.getNumber();
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
}