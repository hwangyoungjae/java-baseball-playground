package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> answerNumbers) {
        this.answers = mapBall(answerNumbers);
    }

    private static List<Ball> mapBall(List<Integer> answerNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answerNumbers.get(i)));
        }
        return balls;
    }

    public BallStatus match(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.match(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        return new PlayResult();
    }
}
