package baseball;

import baseball.exceptions.InvalidArgumentError;

public class Ball {
    private final BallPosition ballPosition;
    private final BallNumber ballNumber;

    public Ball(int position, int number) throws InvalidArgumentError {
        ballPosition = new BallPosition(position);
        ballNumber = new BallNumber(number);
    }

    public BallMatchResult match(Ball userBall) {
        if (this.equals(userBall)) return BallMatchResult.STRIKE;
        if (this.matchBallNumber(userBall)) return BallMatchResult.BALL;
        return BallMatchResult.NOTHING;
    }

    private boolean matchBallNumber(Ball userBall) {
        return this.ballNumber.getNumber() == userBall.ballNumber.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (!ballPosition.equals(ball.ballPosition)) return false;
        return ballNumber.equals(ball.ballNumber);
    }

    @Override
    public int hashCode() {
        int result = ballPosition.hashCode();
        result = 31 * result + ballNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(ballNumber);
    }
}
