package baseball;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus match(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (isNumberEquals(ball.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isNumberEquals(int n) {
        return this.number == n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (position != ball.position) return false;
        return isNumberEquals(ball.number);
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + number;
        return result;
    }
}
