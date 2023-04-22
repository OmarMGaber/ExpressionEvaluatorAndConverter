package Application;

import Model.Expression;
import Controller.ExpressionConverter;

public class MainTest {
    public static void main(String[] args) {
        Expression expression = new Expression("a+b*c");
        System.out.println(ExpressionConverter.infixToPostfix(expression));
        System.out.println(ExpressionConverter.infixToPrefix(expression));
    }
}