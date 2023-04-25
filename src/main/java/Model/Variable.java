package Model;

public class Variable {

    private String value;
    private boolean sign;

    public Variable() {
        this.value = "";
        this.sign = true;
    }

    public Variable(String s) {
        this.value = s;
        this.sign = true;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public void append(char value) {
        this.value += value;
    }

    public String getString() {
        return value;
    }

    public double getValue() {
        if (sign) {
            return Double.parseDouble(value);
        } else {
            return -Double.parseDouble(value);
        }
    }

    public void clear() {
        this.value = "";
        this.sign = true;
    }
}
