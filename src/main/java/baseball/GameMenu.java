package baseball;

public enum GameMenu {
    START(1),
    QUIT(2),
    ;

    private int value;

    GameMenu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static GameMenu of(int value) {
        for (GameMenu m : GameMenu.values()) {
            if (m.getValue() == value) return m;
        }
        throw new IllegalStateException();
    }
}
