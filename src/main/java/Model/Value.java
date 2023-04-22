package Model;

public class Value {

    private String value;
    private boolean sign;
    public Value() {
        this.value = "";
        this.sign = true;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public void append(char value) {
        this.value += value;
    }

    public int getValue() {
        if (sign) {
            return Integer.parseInt(value);
        } else {
            return -Integer.parseInt(value);
        }
    }
}
