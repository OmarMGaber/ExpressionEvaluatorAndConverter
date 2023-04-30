package View;

import Application.Main;
import Controller.ExpressionEvaluator;
import Model.Expression;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EvaluatorScene implements Scene {

    ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    Label titleLabel;
    Label enterLabel;
    Label resultLabel;
    Label notationTypeLabel;
    Label typeLabel;
    Label noteLabel;

    TextField resultMessage;
    TextField expressionTextField;

    Button evaluateButton;
    Button convertButton;

    GridPane gridPane;

    public EvaluatorScene() {
        initializeControls();
        renderScene();
        applyStyles();
        addActions();
    }

    @Override
    public void initializeControls() {
        titleLabel = new Label("Evaluate Expression\t\t\t\t");
        enterLabel = new Label("Enter the expression below");
        resultLabel = new Label("Result:");
        notationTypeLabel = new Label("Notation Type:");
        typeLabel = new Label("");
        noteLabel = new Label("Note: Enter any type of expression and press evaluate to get the result,\n" +
                "the program will automatically detect the notation type of expression and evaluate it");

        resultMessage = new TextField("");
        expressionTextField = new TextField(ConvertersScene.resultMessageString);

        convertButton = new Button("Convert");
        evaluateButton = new Button("Evaluate");

        gridPane = new GridPane();
    }

    @Override
    public void renderScene() {
        gridPane.add(titleLabel, 0, 3, 5, 1);
        gridPane.add(enterLabel, 0, 8, 2, 1);
        gridPane.add(expressionTextField, 0, 9, 2, 1);
        gridPane.add(notationTypeLabel, 2, 9);
        gridPane.add(typeLabel, 3, 9);
        gridPane.add(evaluateButton, 0, 10);
        gridPane.add(noteLabel, 0, 11, 5, 1);
        gridPane.add(resultLabel, 0, 16);
        gridPane.add(resultMessage, 0, 17);
        gridPane.add(convertButton, 2, 25);

        expressionTextField.setPrefWidth(400);

        resultMessage.setEditable(false);
        resultMessage.setPrefWidth(400);
        resultMessage.setPrefWidth(400);

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void applyStyles() {
        titleLabel.getStyleClass().add("title");

        enterLabel.getStyleClass().add("label");

        resultLabel.getStyleClass().add("label");
        resultLabel.setStyle("-fx-font-weight: bold");

        notationTypeLabel.getStyleClass().add("label");
        notationTypeLabel.setStyle("-fx-font-weight: bold");

        noteLabel.getStyleClass().add("note");

        resultMessage.getStyleClass().add("text-field");

        expressionTextField.getStyleClass().add("text-field");

        convertButton.getStyleClass().add("button");
    }

    @Override
    public void addActions() {
        convertButton.setOnAction(actionEvent -> {
            ConvertersScene convertersScene = new ConvertersScene();

            Stage stage = Main.getStage();
            stage.setTitle("Expression Converter");
            stage.setScene(convertersScene.getScene());
        });

        evaluateButton.setOnAction(actionEvent -> {

            String exp = expressionTextField.getText();
            if (exp == null) {
                typeLabel.setText("Empty String");
                resultMessage.setText("Please enter an expression");
            } else {
                Expression expression = new Expression(exp);
                if (expression.isBalanced()) {
                    resultMessage.setStyle("-fx-text-fill: BLACK");
                    typeLabel.setText(expression.getNotationType());
                    resultMessage.setText(String.valueOf(expressionEvaluator.evaluateExpression(expression)));
                } else {
                    typeLabel.setText("Invalid Expression");
                    resultMessage.setStyle("-fx-text-fill: RED");
                    resultMessage.setText("Please enter a valid expression (Unbalanced Parenthesis)");
                }
            }
        });
    }

    @Override
    public javafx.scene.Scene getScene() {
        javafx.scene.Scene scene = new javafx.scene.Scene(gridPane, Scene.WIDTH, Scene.HEIGHT);
        scene.getStylesheets().add("ApplicationStyles.css");
        return scene;
    }

    @Override
    public Node getAsElement() {
        return gridPane;
    }
}
