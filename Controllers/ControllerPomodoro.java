package PomodoroTimer.Controllers;

import PomodoroTimer.MusicThings;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class ControllerPomodoro {

    @FXML
    private Label minutesLabel;
    @FXML
    private Label secondsLabel;
    @FXML
    private Button start;
    private Timeline timeline = new Timeline();
    private MusicThings music = new MusicThings();


    private void showCountDown(int time) {
        start.setDisable(true);

        int nextFrameTime = 0;

        for (int i = 0; i <= time; time--) {
            int finalTime = time;

            timeline.getKeyFrames().add(new KeyFrame(
                            Duration.millis(nextFrameTime),
                            action -> {
                                minutesLabel.setText(String.format("%02d", finalTime / 60));
                                secondsLabel.setText(String.format("%02d", finalTime % 60));
                                music.turnOnEndOfCountingSound(minutesLabel, secondsLabel);
                            }
                    )
            );
            nextFrameTime += 1000;
        }

        timeline.setOnFinished(action -> start.setDisable(false));

        timeline.setCycleCount(1);
        timeline.play();

    }

    @FXML
    void startTimer() {
        music.turnOnClickSound();

        int amountOfMinutes = Integer.parseInt(minutesLabel.getText());
        int amountOfSeconds = Integer.parseInt(secondsLabel.getText());
        int time = amountOfMinutes * 60 + amountOfSeconds;

        showCountDown(time);
    }

    @FXML
    void stopTimer() {
        start.setDisable(false);
        music.turnOnClickSound();
        timeline.stop();
    }

    @FXML
    void resetTimer() {
        start.setDisable(false);
        music.turnOnClickSound();
        timeline.stop();
        minutesLabel.setText("25");
        secondsLabel.setText("00");
    }

    @FXML
    void initialize() {
        minutesLabel.setText("25");
        secondsLabel.setText("00");
    }
}


