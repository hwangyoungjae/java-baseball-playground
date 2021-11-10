package baseball;

public class Game {
    private final Balls answerBalls;
    private GameStatus status;

    public Game() {
        this.answerBalls = Balls.generateRandomBalls();
        this.status = GameStatus.PLAY;
    }

    public GameStatus getStatus() {
        return status;
    }


}
