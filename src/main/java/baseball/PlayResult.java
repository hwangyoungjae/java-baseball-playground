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

    public void evaluation(BallMatchResult ballMatchResult) {
        if (ballMatchResult.isBall()) {
            ball += 1;
        }
        if (ballMatchResult.isStrike()) {
            strike += 1;
        }
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isEnded() {
        return strike == BallPosition.MAX_POSITION;
    }
}
