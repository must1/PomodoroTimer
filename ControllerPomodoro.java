package PomodoroTimer;

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
    Timeline timeline = new Timeline();


    public void showCountDown(int time) {
        int nextFrameTime = 0;

        for (int i = 0; i <= time; time--) {
            int finalTime = time;

            timeline.getKeyFrames().add(new KeyFrame(
                            Duration.millis(nextFrameTime),
                            action -> {
                                minutesLabel.setText(String.format("%02d", finalTime / 60));
                                secondsLabel.setText(String.format("%02d", finalTime % 60));
                            }
                    )
            );
            nextFrameTime += 1000;
        }

        timeline.setCycleCount(3);
        timeline.play();
    }

    @FXML
    void startTimer() {

        int amountOfMinutes = Integer.parseInt(minutesLabel.getText());
        int amountOfSeconds = Integer.parseInt(secondsLabel.getText());
        int time = amountOfMinutes * 60 + amountOfSeconds;

        showCountDown(time);
    }


    @FXML
    void stopTimer() {
        timeline.stop();
    }

    @FXML
    void initialize() {
        minutesLabel.setText("01");
        secondsLabel.setText("00");
    }
}


