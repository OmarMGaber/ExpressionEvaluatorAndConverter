package View;

import Application.Main;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LandingScene implements Scene {

    ConvertersScene convertersScene = new ConvertersScene();
    EvaluatorScene evaluatorScene = new EvaluatorScene();

    Label titleLabel;

    Button evaluateButton;
    Button converterButton;

    static GridPane gridPane;

    public LandingScene() {
        initializeControls();
        renderScene();
        applyStyles();
        addActions();
    }

    @Override
    public void initializeControls() {
        titleLabel = new Label("Expression Evaluator and Converter");
        evaluateButton = new Button("Evaluate an Expression");
        converterButton = new Button("Convert an Expression");
        gridPane = new GridPane();
    }

    @Override
    public void renderScene() {
        gridPane.add(titleLabel, 0, 0, 4, 1);

        gridPane.add(evaluateButton, 1, 10);
        gridPane.add(converterButton, 3, 10);

        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setValignment(titleLabel, VPos.TOP);

    }

    @Override
    public void applyStyles() {
        titleLabel.getStyleClass().add("title");
        evaluateButton.getStyleClass().add("button");
        converterButton.getStyleClass().add("button");
    }

    @Override
    public void addActions() {
        converterButton.setOnAction(actionEvent -> {
            Stage stage = Main.getStage();
            stage.setTitle("Expression Converter");
            stage.setScene(convertersScene.getScene());
        });

        evaluateButton.setOnAction(actionEvent -> {
            Stage stage = Main.getStage();
            stage.setTitle("Expression Evaluator");
            stage.setScene(evaluatorScene.getScene());
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
