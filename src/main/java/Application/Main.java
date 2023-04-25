package Application;

import View.ConvertersScene;
import View.EvaluatorScene;
import View.LandingScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static LandingScene landingScene = new LandingScene();
//    static ConvertersScene convertersScene = new ConvertersScene();
//    static EvaluatorScene evaluatorScene = new EvaluatorScene();

    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;

        Scene scene = landingScene.getScene();
        scene.getStylesheets().add("ApplicationStyles.css");

        Image img = new Image("https://cdn2.iconfinder.com/data/icons/ios7-inspired-mac-icon-set/512/Calculator_512.png");

        stage.setResizable(false);
        stage.getIcons().add(img);
        stage.setTitle("Expression Evaluator and Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch();
    }
}