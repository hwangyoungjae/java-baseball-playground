package baseball;

public enum BallMatchResult {
    NOTHING,
    BALL,
    STRIKE,
    ;

    public boolean isNotNothing() {
        return this != BallMatchResult.NOTHING;
    }

    public boolean isBall() {
        return this == BallMatchResult.BALL;
    }

    public boolean isStrike() {
        return this == BallMatchResult.STRIKE;
    }
}
