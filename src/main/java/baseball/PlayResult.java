package baseball;

public class PlayResult {
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void evaluation(BallMatchResult result) {
        if (result.isBall()) ball += 1;
        if (result.isStrike()) strike += 1;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isEnded() {
        return ball == 0 && strike == Ball.MAX_POSITION;
    }

    @Override
    public String toString() {
        return "PlayResult{" +
                "ball=" + ball +
                ", strike=" + strike +
                '}';
    }
}
