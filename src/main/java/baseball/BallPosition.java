package baseball;

public class BallPosition {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;
    private final int position;

    public BallPosition(int position) {
        validation(position);
        this.position = position;
    }

    private void validation(int n) {
        if (n < MIN_POSITION || n > MAX_POSITION) {
            throw new IllegalStateException();
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BallPosition that = (BallPosition) o;

        return position == that.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
