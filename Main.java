package PomodoroTimer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/PomodoroTimer.fxml"));
        primaryStage.setTitle("Pomodoro Timer");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("PomodoroTimer.css");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
