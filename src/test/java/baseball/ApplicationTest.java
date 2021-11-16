package baseball;

import baseball.exceptions.InvalidError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ApplicationTest {

    private Application app;

    @BeforeEach
    void setUp() {
        this.app = new Application();
    }

    @Test
    void menuNumberToMenu() {
        assertThat(app.menuNumberToMenu("1")).isEqualTo(Menu.START);
        assertThat(app.menuNumberToMenu("2")).isEqualTo(Menu.QUIT);
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat(app.menuNumberToMenu("3")).isEqualTo(Menu.QUIT);
                });
    }

//    @Test
//    void inputMenuNumber() {
//        String input = "1";
//        String outputString = Msg.INPUT_GAME_MENU.getValue();
//        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        OutputStream outputStream = new ByteArrayOutputStream();
//
//        System.setIn(inputStream);
//        System.setOut(new PrintStream(outputStream));
//
//        String r = app.inputMenuNumber();
//        assertThat(Objects.equals(outputStream.toString(), outputString)).isTrue();
//        assertThat(r).isEqualTo(input);
//    }

    @Test
    void pitchingNumberToBalls() throws InvalidError {
        String ballNumber = "123";
        Balls actual = app.pitchingNumberToBalls(ballNumber);
        Balls predict = Balls.ofString(ballNumber);
        System.out.println(actual.equals(predict));
        assertThat(actual.equals(predict)).isTrue();
    }

//    @Test
//    void inputPitchingNumber() {
//        String inputString = "123";
//        String outputString = Msg.INPUT_PITCHING_NUMBER.getValue();
//        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
//        OutputStream outputStream = new ByteArrayOutputStream();
//
//        System.setIn(inputStream);
//        System.setOut(new PrintStream(outputStream));
//
//        String r = app.inputPitchingNumber();
//        assertThat(Objects.equals(outputStream.toString(), outputString)).isTrue();
//        assertThat(r).isEqualTo(inputString);
//    }

    @Test
    void newGame() {
        app.newGame();
        assertThat(app.game).isNotNull();
    }
}