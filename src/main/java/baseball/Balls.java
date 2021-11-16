package baseball;

import baseball.exceptions.InvalidBallPositionError;
import baseball.exceptions.InvalidBallsDuplicatedError;
import baseball.exceptions.InvalidError;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {
    private final List<Ball> balls;

    private Balls(List<Ball> ballList) throws InvalidError {
        validationBallCount(ballList);
        validationDuplicatedBall(ballList);
        this.balls = ballList;
    }

    private static void validationBallCount(List<Ball> ballList) throws InvalidBallPositionError {
        if (ballList.size() != Ball.MAX_POSITION) {
            throw new InvalidBallPositionError();
        }
    }

    private static void validationDuplicatedBall(List<Ball> ballList) throws InvalidBallsDuplicatedError {
        int i = 0;
        int j = i + 1;
        while (i < Ball.MAX_POSITION - 1) {
            if (ballList.get(i).equalsOfNumber(ballList.get(j))) throw new InvalidBallsDuplicatedError();
            j += 1;
            if (j >= Ball.MAX_POSITION) {
                i += 1;
                j = i + 1;
            }
        }
    }

    public static Balls ofString(String str) throws InvalidError {
        List<Ball> bs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int pos = i + 1;
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            bs.add(new Ball(pos, num));
        }
        return new Balls(bs);
    }

    public static Balls ofArray(List<Integer> array) throws InvalidError {
        List<Ball> bs = new ArrayList<>();
        for (int pos = 0; pos < array.size(); pos++) {
            Integer num = array.get(pos);
            bs.add(new Ball(pos + 1, num));
        }
        return new Balls(bs);
    }

    public BallMatchResult match(Ball userBall) {
        return balls.stream()
                .map((ball) -> ball.match(userBall))
                .filter((r) -> !r.isNothing())
                .findFirst()
                .orElse(BallMatchResult.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        for (Ball userBall : userBalls.balls) {
            result.evaluation(match(userBall));
        }
        return result;
    }

    public boolean equals(Balls target) {
        if (balls.size() != target.balls.size()) return false;
        for (int i = 0; i < balls.size(); i++) {
            if (!balls.get(i).equals(target.balls.get(i))) {
                return false;
            }
        }
        return true;
    }
}
