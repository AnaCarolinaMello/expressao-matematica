public class Item {
    private final int priority;
    private final char value;

    public Item(char value) {
        this.value = value;
        this.priority = checkPriority(value);
    }

    private int checkPriority(char value) {
        if (value == '(')
            return 1;
        else if (value == '+' || value == '-')
            return 2;
        return 3;

    }

    public int getPriority() {
        return this.priority;
    }

    public char getValue() {
        return this.value;
    }

}
