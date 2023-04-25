package Controller;

import Model.Expression;
import Model.Variable;
import Stack.LinkedStack;

public class ExpressionEvaluator {

    static ExpressionConverter expressionConverter = new ExpressionConverter();

    public static double evaluateExpression(Expression exp) {
        if (exp.isPostfix()) {
            return evaluatePostfix(exp);
        } else if (exp.isInfix()) {
            return evaluatePostfix(new Expression(expressionConverter.infixToPostfix(exp)));
        } else if (exp.isPrefix()) {
            return evaluatePostfix(new Expression(expressionConverter.infixToPostfix(exp)));
        } else {
            return -1.0;
        }
    }

    private static double evaluatePostfix(Expression postfixExpression) {
        StringBuilder postfix = new StringBuilder(postfixExpression.toString());
        LinkedStack<Double> operandsStack = new LinkedStack();
        Variable operand = new Variable();
        int counter = 0;
        Character currentChar;

        while (counter != postfix.length()) {
            currentChar = postfix.charAt(counter);

            if (currentChar == ' ' && !operand.getString().equals("")) {
                operandsStack.push(operand.getValue());
                operand.clear();
            } else if (Character.isDigit(currentChar) || currentChar.equals('.')) {
                operand.append(currentChar);
            } else if (currentChar == '-') {
                if (counter == postfix.length() - 1 || (operandsStack.size() > 1)) {
                    double operand1 = operandsStack.pop();
                    double operand2 = operandsStack.pop();
                    operandsStack.push(operand2 - operand1);
                } else {
                    Variable var = new Variable(String.valueOf(operandsStack.pop()));
                    var.setSign(false);
                    operandsStack.push(var.getValue());
                }
            } else if (currentChar == '+') {
                double operand1 = operandsStack.pop();
                double operand2 = operandsStack.pop();
                operandsStack.push(operand2 + operand1);
            } else if (currentChar == '*') {
                double operand1 = operandsStack.pop();
                double operand2 = operandsStack.pop();
                operandsStack.push(operand2 * operand1);
            } else if (currentChar == '^') {
                double operand1 = operandsStack.pop();
                double operand2 = operandsStack.pop();
                operandsStack.push(Math.pow(operand2, operand1));
            } else if (currentChar == '/') {
                double operand1 = operandsStack.pop();
                double operand2 = operandsStack.pop();
                operandsStack.push(operand2 / operand1);
            }
            counter++;

            System.out.println(counter);
            operandsStack.display();
            System.out.println(currentChar);
            System.out.println("-------------");
        }
        return Double.parseDouble(operandsStack.peek().toString());
    }
}
