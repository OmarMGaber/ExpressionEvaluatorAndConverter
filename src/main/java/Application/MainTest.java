package Application;

import Model.Expression;
import Controller.ExpressionConverter;
import Model.Value;

public class MainTest {
    public static void main(String[] args) {
        Expression expression = new Expression("a+b*c");
        System.out.println(ExpressionConverter.infixToPostfix(expression));
        System.out.println(ExpressionConverter.infixToPrefix(expression));

        Value v1 = new Value();
        v1.append('4');
        v1.append('3');

        Value v2 = new Value();
        v2.append('7');
        v2.setSign(false);

        System.out.println(v1.getValue() + v2.getValue());
    }
}