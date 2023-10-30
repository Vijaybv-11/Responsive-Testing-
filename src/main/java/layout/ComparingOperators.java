package layout;


public enum ComparingOperators {
    EQUAL("="),
    GREATER_THAN(">"),
    GREATER_THAN_EQUAL(">="),
    LESS_THAN("<"),
    LESS_THAN_EQUAL("<=");

    private final String name;

    ComparingOperators(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
