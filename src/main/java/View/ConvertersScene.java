package View;

import Application.Main;
import Model.Expression;
import Controller.ExpressionConverter;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConvertersScene implements Scene {

    final int WIDTH = 800, HEIGHT = 600;

    Label titleLabel;
    Label enterLabel;
    Label resultLabel;

    TextField resultMessage;
    TextField expressionTextField;

    ComboBox options;

    Button convertButton;
    Button evaluateButton;

    GridPane gridPane;

    public ConvertersScene() {
        initializeControls();
        renderScene();
        applyStyles();
        addActions();
    }

    @Override
    public void initializeControls() {
        titleLabel = new Label("Convert infix expression into postfix  ");
        enterLabel = new Label("Enter the expression below");
        resultLabel = new Label("Postfix:");
        resultMessage = new TextField("");
        expressionTextField = new TextField("");
        convertButton = new Button("Convert");
        evaluateButton = new Button("Evaluate");
        options = new ComboBox<>();
        gridPane = new GridPane();
    }

    @Override
    public void renderScene() {
        gridPane.add(titleLabel, 0, 3, 5, 1);
        gridPane.add(enterLabel, 0, 8, 2, 1);
        gridPane.add(expressionTextField, 0, 9, 2, 1);
        gridPane.add(options, 2, 9);
        gridPane.add(convertButton, 0, 10);
        gridPane.add(resultLabel, 0, 16);
        gridPane.add(resultMessage, 0, 17);
        gridPane.add(evaluateButton, 2, 25);

        expressionTextField.setPrefWidth(400);

        resultMessage.setEditable(false);
        resultMessage.setPrefWidth(400);

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void applyStyles() {
        titleLabel.getStyleClass().add("title");

        enterLabel.getStyleClass().add("label");

        options.getItems().addAll("Infix to Postfix", "Infix to Prefix", "Postfix to Infix", "Postfix to Prefix", "Prefix to Infix", "Prefix to Postfix");

        resultLabel.getStyleClass().add("label");
        resultLabel.setStyle("-fx-font-weight: bold");
        resultMessage.getStyleClass().add("text-field");

        expressionTextField.getStyleClass().add("text-field");

        convertButton.getStyleClass().add("button");
    }

    @Override
    public void addActions() {
        convertButton.setOnAction(actionEvent -> {
            Expression expression = new Expression(expressionTextField.getText());
            if (expression.isBalanced()) {
                resultMessage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                ExpressionConverter expressionConverter = new ExpressionConverter();
                resultMessage.setText(expressionConverter.infixToPostfix(expression));
            } else {
                resultMessage.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                resultMessage.setText("Invalid input (Unbalanced expression)");
            }
        });



        evaluateButton.setOnAction(actionEvent -> {
            //LandingScene landingScene = new LandingScene();
            EvaluatorScene evaluatorScene = new EvaluatorScene();

            Stage stage = Main.getStage();
            stage.setTitle("Expression Converter");
            stage.setScene(evaluatorScene.getScene());
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
