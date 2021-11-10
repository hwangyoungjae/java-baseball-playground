package baseball;

import utils.RandomUtils;

import java.util.ArrayList;

public class BaseballGame {
    GameStatus gameStatus = GameStatus.WAIT;
    GameNumber numbers;

    public void start() {
        gameStatus = GameStatus.PLAY;
        numbers = generateGameNumber();
    }

    public void menu(int menuNumber) {
        
    }

    public String match(GameNumber input) {
        int[] matchResult = numbers.match(input);

        if (matchResult[0] == 0 && matchResult[1] == 0) {
            return "낫싱";
        }

        String responseString = "";
        if (matchResult[0] != 0) {
            responseString += String.format("%s볼 ", matchResult[0]);
        }
        if (matchResult[1] != 0) {
            responseString += String.format("%s스트라이크 ", matchResult[1]);
        }

        if (matchResult[1] == GameNumber.NUMBER_LENGTH) {
            gameStatus = GameStatus.DONE;
        }

        return responseString;
    }

    public GameNumber generateGameNumber() {
        ArrayList<Integer> arr = new ArrayList<>();
        while (arr.size() < 3) {
            int i = RandomUtils.nextInt(1, 9);
            if (!arr.contains(i)) arr.add(i);
        }
        StringBuilder b = new StringBuilder();
        arr.forEach(b::append);
        return new GameNumber(b.toString());
    }
}
