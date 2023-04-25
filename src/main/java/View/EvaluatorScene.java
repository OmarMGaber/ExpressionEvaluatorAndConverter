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

    final int WIDTH = 800, HEIGHT = 600;

    ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    Label titleLabel;
    Label enterLabel;
    Label resultLabel;
    Label notationTypeLabel;
    Label typeLabel;

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
            Expression expression = new Expression(expressionTextField.getText());
            typeLabel.setText(expression.getNotationType());
            resultMessage.setText(String.valueOf(expressionEvaluator.evaluateExpression(expression)));
        });
    }

    @Override
    public javafx.scene.Scene getScene() {
        javafx.scene.Scene scene = new javafx.scene.Scene(gridPane, WIDTH, HEIGHT);
        scene.getStylesheets().add("ApplicationStyles.css");
        return scene;
    }

    @Override
    public Node getAsElement() {
        return gridPane;
    }
}
