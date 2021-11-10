package baseball;

public enum GameStatus {
    WAIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    PLAY("숫자를 입력해주세요 : "),
    DONE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    QUIT(),
    ;
    private String statusMessage = null;

    GameStatus() {
    }

    GameStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
