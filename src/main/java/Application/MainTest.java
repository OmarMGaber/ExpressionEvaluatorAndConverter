package Application;

import Controller.ExpressionEvaluator;
import Model.Expression;
import Controller.ExpressionConverter;
import Model.Variable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

public class MainTest {
    public static void main(String[] args) throws IOException {
//        Expression expression = new Expression("a+b*c");
//        System.out.println(ExpressionConverter.infixToPostfix(expression));
//        System.out.println(ExpressionConverter.infixToPrefix(expression));
//
//        Variable v1 = new Variable();
//        v1.append('4');
//        v1.append('3');
//
//        Variable v2 = new Variable();
//        v2.append('7');
//        v2.setSign(false);
//
//        System.out.println(v1.getValue() + v2.getValue());

//        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
//        ExpressionConverter expressionConverter = new ExpressionConverter();
//
//        Expression exp = new Expression("4 5 +");
//        System.out.println(expressionEvaluator);
//        System.out.println(expressionConverter.infixToPostfix(exp));
//        System.out.println(expressionEvaluator.evaluateExpression(exp));


        Expression e = new Expression("");
        System.out.println("isBalanced: " + e.isBalanced());
    }
}