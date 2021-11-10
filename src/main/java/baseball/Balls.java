package baseball;

import baseball.exceptions.InvalidArgumentError;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {
    public final List<Ball> balls;

    public static Balls generateRandomBalls() {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BallPosition.MAX_POSITION) {
            Integer n = RandomUtils.nextInt(BallNumber.MIN_NUMBER, BallNumber.MAX_NUMBER);
            if (!numbers.contains(n)) numbers.add(n);
        }
        try {
            return Balls.numberOf(numbers);
        } catch (InvalidArgumentError e) {
            throw new RuntimeException();
        }
    }

    private Balls(List<Ball> answerBalls) {
        this.balls = answerBalls;
    }

    static Balls numberOf(List<Integer> numbers) throws InvalidArgumentError {
        validationDuplicatedNumbers(numbers);
        ArrayList<Ball> arr = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            Ball ball = new Ball(i + 1, numbers.get(i));
            arr.add(ball);
        }
        return new Balls(arr);
    }

    public BallMatchResult match(Ball userBall) {
        return balls.stream()
                .map(answer -> answer.match(userBall))
                .filter(BallMatchResult::isNotNothing)
                .findFirst()
                .orElse(BallMatchResult.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult playResult = new PlayResult();
        userBalls.balls.forEach(userBall -> {
            BallMatchResult ballMatchResult = match(userBall);
            playResult.evaluation(ballMatchResult);
        });
        return playResult;
    }

    private static void validationDuplicatedNumbers(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        if (numbers.size() != hashSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return balls.toString();
    }
}
