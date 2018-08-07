package PomodoroTimer.Controllers;

import PomodoroTimer.Music;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;


public class ControllerPomodoro {

    @FXML
    private Label minutesLabel;
    @FXML
    private Label secondsLabel;
    private Timeline timeline = new Timeline();
    private Music music = new Music();


    private void showCountDown(int time) {
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
        music.turnOnClickSound();
        timeline.stop();
    }

    @FXML
    void resetTimer() {
        music.turnOnClickSound();
        minutesLabel.setText("01");
        secondsLabel.setText("00");
    }

    @FXML
    void initialize() {
        minutesLabel.setText("01");
        secondsLabel.setText("00");
    }
}


