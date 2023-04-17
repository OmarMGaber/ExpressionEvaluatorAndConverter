package Model;

import Stack.LinkedStack;

import java.util.ArrayList;

public class ExpressionConverter {

    public static String infixToPostfix(Expression infixExpression) {
        StringBuilder infix = new StringBuilder(infixExpression.getExpressionString());
        StringBuilder postfix = new StringBuilder();
        LinkedStack<Character> operatorStack = new LinkedStack<Character>();
        int counter = 0;

        ArrayList current = new ArrayList<>();
        ArrayList postfixForm = new ArrayList<>();
        ArrayList stackForm = new ArrayList<>();

        while (counter != infix.length()) {
            Character currentCharacter = infix.charAt(counter);
            counter++;
            current.add(currentCharacter);

            if (Character.isAlphabetic(currentCharacter) || Character.isDigit(currentCharacter)) {
                postfix.append(currentCharacter);
                postfixForm.add(postfix);
            } else if (currentCharacter == '^') {
                //postfix.append(" ");
                operatorStack.push(currentCharacter);
            } else if (currentCharacter == '+' || currentCharacter == '-' || currentCharacter == '*' || currentCharacter == '/') {
                while (!operatorStack.isEmpty() && getPrecedence(currentCharacter) <= getPrecedence(operatorStack.peek())) {
                    //postfix.append(" ");
                    postfix.append(operatorStack.pop());
                    postfixForm.add(postfix);
                    //postfix.append(" ");
                }
                operatorStack.push(currentCharacter);
            } else if (currentCharacter == '(') {
                operatorStack.push(currentCharacter);
            } else if (currentCharacter == ')') {
                Character lastOperator = operatorStack.pop();
                while (lastOperator != '(') {
                    //postfix.append(" ");
                    postfix.append(lastOperator);
                    postfixForm.add(postfix);
                    lastOperator = operatorStack.pop();
                }
            }
            stackForm.add(operatorStack.peek());
            System.out.println(counter);
            System.out.println("current:" + current);
            System.out.println("postfix:" + postfixForm);
            System.out.println("operator stack:" + stackForm);
            System.out.println(" ");
        }
        return postfix.toString();
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