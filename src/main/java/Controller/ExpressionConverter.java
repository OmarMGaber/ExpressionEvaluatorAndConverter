package Controller;

import Model.Expression;
import Stack.LinkedStack;

import java.util.ArrayList;

public class ExpressionConverter {

    public void drawTable() {
    }

    public static String infixToPostfix(Expression infixExpression) {
        StringBuilder infix = new StringBuilder(infixExpression.getExpressionString());
        StringBuilder postfix = new StringBuilder();
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();
        int counter = 0;

        while (counter != infix.length()) {
            Character currentChar = infix.charAt(counter);
            counter++;

            if (Character.isAlphabetic(currentChar) || Character.isDigit(currentChar) || currentChar.equals('.')) {
                postfix.append(currentChar);
//                postfixForm.add(postfix);
            } else if (currentChar == '^') {
                postfix.append(" ");
                operatorStack.push(currentChar);
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operatorStack.isEmpty() && getPrecedence(currentChar) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(" ");
                    postfix.append(operatorStack.pop());
                }
                postfix.append(" ");
                operatorStack.push(currentChar);
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                Character lastOperator = operatorStack.pop();
                while (lastOperator != '(') {
                    postfix.append(" ");
                    postfix.append(lastOperator);
                    lastOperator = operatorStack.pop();
                }
            }
        }
        return postfix.toString();
    }

    public static String infixToPrefix(Expression infixExpression) {
        return "";
    }

    public static String postfixToInfix(Expression postfixExpression) {
        return "";
    }

    public static String postfixToPrefix(Expression postfixExpression) {
        Expression infixExpression = new Expression(postfixToInfix(postfixExpression));
        return infixToPrefix(infixExpression);
    }

    public static String prefixToInfix(Expression prefixExpression){
        return "";
    }

    public static String prefixToPostfix(Expression prefixExpression){
        Expression infixExpression = new Expression(prefixToInfix(prefixExpression));
        return infixToPostfix(infixExpression);
    }


    public static int getPrecedence(Character operator) {
        int precedence = 0;
        switch (operator) {
            case '+':
                precedence = 1;
                break;
            case '-':
                precedence = 1;
                break;
            case '*':
                precedence = 2;
                break;
            case '/':
                precedence = 2;
                break;
            case '^':
                precedence = 3;
                break;
        }
        return precedence;
    }
}