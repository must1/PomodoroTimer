package PomodoroTimer;

import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MusicThings {
    private Media sound;
    private String musicFile;
    private MediaPlayer mediaPlayer;

    public void turnOnClickSound() {
        musicFile = "MusicSounds/Click.mp3";
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void turnOnEndOfCountingSound(Label minutesLabel, Label secondsLabel) {
        if (minutesLabel.getText().equals("00") && secondsLabel.getText().equals("00")) {
            musicFile = "MusicSounds/Ping-sound.mp3";
            sound = new Media(new File(musicFile).toURI().toString());
            mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        }
    }
}
