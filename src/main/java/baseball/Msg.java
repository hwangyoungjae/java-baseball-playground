package baseball;

public enum Msg {
    INPUT_PITCHING_NUMBER("숫자를 입력해주세요 : "),
    INPUT_GAME_MENU("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    DISPLAY_GAME_DONE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    BALL("%s볼 "),
    STRIKE("%s스트라이크"),
    NOTHING("낫싱")
    ;
    private String value;

    Msg(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
