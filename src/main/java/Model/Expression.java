package Model;

import Stack.LinkedStack;

import java.util.regex.Matcher;

public class Expression {

    private String expressionString;
    private String notationType;

    public Expression(String expressionString) {
        if ((!expressionString.isEmpty()) || !(expressionString != " ")) {
            this.expressionString = expressionString;

            if (isPostfix()) {
                notationType = "Postfix";
            } else if (isInfix()) {
                notationType = "Infix";
            } else if (isPrefix()) {
                notationType = "Prefix";
            } else {
                notationType = "Unknown";
            }
        } else {
            this.expressionString = "";
            notationType = "Empty String";
        }
    }

    public String getExpressionString() {
        return "(" + expressionString + ")";
    }

    public String getNotationType() {
        return notationType;
    }

    public void setExpressionString(String expressionString) {
        this.expressionString = expressionString;
    }

    public boolean isBalanced() {
        int counter = 0;
        LinkedStack parentheses = new LinkedStack<>();
        while (counter != expressionString.length()) {
            if (expressionString.charAt(counter) == '(' || expressionString.charAt(counter) == '{' || expressionString.charAt(counter) == '[') {
                parentheses.push(expressionString.charAt(counter));
            } else if (expressionString.charAt(counter) == ')' || expressionString.charAt(counter) == '}' || expressionString.charAt(counter) == ']') {
                if (parentheses.isEmpty()) {
                    return false;
                } else {
                    if (expressionString.charAt(counter) == ')' && !parentheses.peek().equals('(')) {
                        return false;
                    } else if (expressionString.charAt(counter) == '}' && !parentheses.peek().equals('{')) {
                        return false;
                    } else if (expressionString.charAt(counter) == ']' && !parentheses.peek().equals('[')) {
                        return false;
                    }
                    parentheses.pop();
                }
            }
            counter++;
        }
        return parentheses.isEmpty();
    }

    private boolean isDigit(int index) {
        return Character.isDigit(expressionString.charAt(index));
    }

    private boolean isAlphabetic(int index) {
        return Character.isAlphabetic(expressionString.charAt(index));
    }

    private boolean isInfix() {
        try {
            int first = 0;
            while (expressionString.charAt(first) == '(' || expressionString.charAt(first) == ' ') {
                first++;
            }
            int last = expressionString.length() - 1;
            while (expressionString.charAt(last) == ')' || expressionString.charAt(last) == ' ') {
                last--;

            }

            return ((isDigit(first) || expressionString.charAt(first) == '-') && isDigit(last))
                    || ((isAlphabetic(first) || expressionString.charAt(first) == '-') && isDigit(last))
                    || ((isDigit(first) || expressionString.charAt(first) == '-') && isAlphabetic(last))
                    || ((isAlphabetic(first) || expressionString.charAt(first) == '-') && isAlphabetic(last));
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean isPostfix() {
        try {
            int counter = expressionString.length() - 1;
            while (expressionString.charAt(counter) == ')' || expressionString.charAt(counter) == ' ') {
                counter--;
            }
            return !isDigit(counter) && !isAlphabetic(counter);
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean isPrefix() {
        try {
            int counter = 0;
            while (expressionString.charAt(counter) == '(' || expressionString.charAt(counter) == ' ') {
                counter++;
            }
            return !isDigit(counter) && !isAlphabetic(counter);
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

//    public boolean isExpression(){
//        return isInfix() || isPrefix() || isPostfix();
//    }

    @Override
    public String toString() {
        return expressionString;
    }
}
