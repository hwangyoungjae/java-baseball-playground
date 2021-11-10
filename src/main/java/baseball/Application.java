package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input;
        final Scanner scanner = new Scanner(System.in);
        BaseballGame game = new BaseballGame();

        game.start();
        System.out.println(game.numbers);
        while (game.gameStatus != GameStatus.QUIT) {
            switch (game.gameStatus) {
                case WAIT:
                    System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n",
                            GameMenu.START.getValue(),
                            GameMenu.QUIT.getValue());
                    input = scanner.nextLine();
                    GameMenu m = GameMenu.of(Integer.parseInt(input));
                    switch (m) {
                        case START:
                            game.start();
                            break;
                        default:
                            game.gameStatus = GameStatus.QUIT;
                    }
                    break;
                case PLAY:
                    System.out.print("숫자를 입력해주세요 : ");
                    input = scanner.nextLine();
                    String matchResult = game.match(new GameNumber(input));
                    System.out.println(matchResult);
                    break;
                case DONE:
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    game.gameStatus = GameStatus.WAIT;
                    break;
                default:
                    game.gameStatus = GameStatus.QUIT;
            }
        }
    }
}