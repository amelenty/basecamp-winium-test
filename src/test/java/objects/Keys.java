package objects;

public enum Keys {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    ZERO("0"),
    DIVIDE("/"),
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("x"),
    CLEAR("C"),
    EQUAL("="),
    DOT(".");

    private final String text;

    private Keys(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
