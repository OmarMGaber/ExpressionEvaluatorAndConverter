package Model;

import Stack.LinkedStack;

public class Expression {

    private String expressionString;

    public Expression(String expressionString) {
        this.expressionString = expressionString.replaceAll("\\s", "");
    }

    public String getExpressionString() {
        return '(' + expressionString + ')';
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }

    public boolean isBalanced() {
        int counter = 0;
        LinkedStack parentheses = new LinkedStack<>();
        while (counter != expressionString.length()) {
            if (expressionString.charAt(counter) == '(') {
                parentheses.push(expressionString.charAt(counter));
            } else if (expressionString.charAt(counter) == ')') {
                if (parentheses.isEmpty()) {
                    return false;
                } else {
                    parentheses.pop();
                }
            }
            counter++;
        }
        return parentheses.isEmpty();
    }



    @Override
    public String toString() {
        return '(' + expressionString + ')';
    }
}
