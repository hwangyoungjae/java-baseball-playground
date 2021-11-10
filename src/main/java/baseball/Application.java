package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private GameStatus gameStatus = GameStatus.WAIT;
    private Balls answerBalls;

    public static void main(String[] args) {
        inputUserBalls();
    }

    static Balls inputUserBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        return Balls.numberOf(stringToArrayList(input));
    }

    public Application() {
        loop();
    }

    void start() {
        gameStatus = GameStatus.PLAY;
        answerBalls = Balls.generateRandomBalls();
//        System.out.println(answerBalls);
    }

    private void loop() {
        start();
        while (gameStatus != GameStatus.QUIT) run();
    }

    void run() {
        String input;

        if (gameStatus.getStatusMessage() != null) {
            System.out.print(gameStatus.getStatusMessage());
        }

        switch (gameStatus) {
            case WAIT:
                input = scanner.nextLine();
                if (Objects.equals(input, "1")) {
                    start();
                } else if (Objects.equals(input, "2")) {
                    gameStatus = GameStatus.QUIT;
                } else {
                    gameStatus = GameStatus.QUIT;
                }
                break;
            case PLAY:
                input = scanner.nextLine();
                Balls userBalls = Balls.numberOf(stringToArrayList(input));
                PlayResult playResult = answerBalls.play(userBalls);

                if (playResult.isNothing()) {
                    System.out.println("Nothing");
                } else {
                    StringBuilder sb = new StringBuilder();
                    if (playResult.getBall() > 0) {
                        sb.append(String.format("%sBall", playResult.getBall()));
                    }
                    if (playResult.getStrike() > 0) {
                        sb.append(String.format("%sStrike", playResult.getStrike()));
                    }
                    System.out.println(sb);
                }
                if (playResult.isEnded()) {
                    gameStatus = GameStatus.DONE;
                }
                break;
            case DONE:
                gameStatus = GameStatus.WAIT;
                break;
            default:
                gameStatus = GameStatus.QUIT;
        }
    }

    public static List<Integer> stringToArrayList(String numbers) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            arr.add(Integer.parseInt(String.valueOf(c)));
        }
        return arr;
    }
}
