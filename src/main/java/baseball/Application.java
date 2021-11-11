package baseball;

import baseball.exceptions.InvalidError;

import java.util.Scanner;

public class Application {
    static final Scanner scanner = new Scanner(System.in);
    Game game;
    boolean quitFlag = false;

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    void start() {
        newGame();
        loop();
    }

    void loop() {
        while (!quitFlag) {
            if (game.isDone()) {
                menuHandler();
            } else {
                pitchingHandler();
            }
        }
    }

    void menuHandler() {
        try {
            Menu menu = menuNumberToMenu(inputMenuNumber());
            menuProcess(menu);
        } catch (RuntimeException ignored) {
        }
    }

    void menuProcess(Menu menu) {
        if (menu == Menu.START) {
            newGame();
        } else if (menu == Menu.QUIT) {
            quitFlag = true;
        }
    }

    void pitchingHandler() {
        try {
            pitchingProcess();
        } catch (InvalidError ignored) {
        }
    }

    void pitchingProcess() throws InvalidError {
        Balls userBalls = pitchingNumberToBalls(inputPitchingNumber());
        PlayResult result = game.pitching(userBalls);

        StringBuilder sb = new StringBuilder();
        if (result.getBall() > 0) sb.append(String.format(Msg.BALL.getValue(), result.getBall()));
        if (result.getStrike() > 0) sb.append(String.format(Msg.STRIKE.getValue(), result.getStrike()));
        if (sb.toString().equals("")) {
            System.out.println(Msg.NOTHING);
        } else {
            System.out.println(sb);
        }
        if (result.isEnded()) System.out.println(Msg.DISPLAY_GAME_DONE);
    }

    void newGame() {
//        Balls balls = null;
//        try {
//            balls = Balls.ofArray(Arrays.asList(1, 2, 3));
//        } catch (InvalidError e) {
//            e.printStackTrace();
//        }
//        game = new Game(balls);
        game = new Game();
    }

    String inputPitchingNumber() {
        System.out.print(Msg.INPUT_PITCHING_NUMBER);
        return scanner.nextLine();
    }

    Balls pitchingNumberToBalls(String pitchingNumber) throws InvalidError {
        return Balls.ofString(pitchingNumber);
    }

    String inputMenuNumber() {
        System.out.print(Msg.INPUT_GAME_MENU);
        return scanner.nextLine();
    }

    Menu menuNumberToMenu(String menuNumberString) {
        return Menu.values()[Integer.parseInt(menuNumberString) - 1];
    }
}
