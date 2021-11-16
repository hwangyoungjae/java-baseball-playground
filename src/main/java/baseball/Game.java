package baseball;

import baseball.exceptions.InvalidError;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    enum GameStatus {
        PLAY,
        DONE,
    }

    private final Balls answerBalls;
    private GameStatus status;

    public Game() {
        this(generateBalls());
    }

    public Game(Balls answerBalls) {
        this.answerBalls = answerBalls;
        this.status = GameStatus.PLAY;
    }

    private static Balls generateBalls() {
        try {
            return Balls.ofArray(generateRandomBallNumbers());
        } catch (InvalidError e) {
            throw new RuntimeException();
        }
    }

    private static List<Integer> generateRandomBallNumbers() {
        List<Integer> ballNumbers = new ArrayList<>();
        while (ballNumbers.size() < Ball.MAX_POSITION) {
            Integer n = RandomUtils.nextInt(Ball.MIN_NUMBER, Ball.MAX_NUMBER);
            if (!ballNumbers.contains(n)) ballNumbers.add(n);
        }
        return ballNumbers;
    }

    public PlayResult pitching(Balls userBall) {
        if (status != GameStatus.PLAY) {
            throw new RuntimeException();
        }
        PlayResult playResult = answerBalls.play(userBall);
        if (playResult.isEnded()) {
            status = GameStatus.DONE;
        }
        return playResult;
    }

    public GameStatus getStatus() {
        return status;
    }

    public boolean isDone() {
        return status == GameStatus.DONE;
    }
}
