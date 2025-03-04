package com.ugb.holamundo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button; // Se mueven los imports aquí
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private int currentSongIndex = 0;
    private final int[] songResources = {R.raw.cancion1, R.raw.cancion2, R.raw.cancion3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.playButton); // Línea 17: Variables locales
        Button pauseButton = findViewById(R.id.pauseButton);
        Button stopButton = findViewById(R.id.stopButton);
        Button nextButton = findViewById(R.id.nextButton);
        Button previousButton = findViewById(R.id.previousButton);
        findViewById(R.id.songTitle);// Línea 18: Variable local

        initializeMediaPlayer();
        updateSongTitle();

        playButton.setOnClickListener(v -> playMusic()); // Lambdas
        pauseButton.setOnClickListener(v -> pauseMusic());
        stopButton.setOnClickListener(v -> stopMusic());
        nextButton.setOnClickListener(v -> playNextSong());
        previousButton.setOnClickListener(v -> playPreviousSong());
    }

    private void initializeMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, songResources[currentSongIndex]);
        mediaPlayer.setOnCompletionListener(mp -> playNextSong()); // Lambda
    }

    private void playMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            initializeMediaPlayer();
            updateSongTitle();
        }
    }

    private void playNextSong() {
        currentSongIndex = (currentSongIndex + 1) % songResources.length;
        initializeMediaPlayer();
        playMusic();
        updateSongTitle();
    }

    private void playPreviousSong() {
        currentSongIndex = (currentSongIndex - 1 + songResources.length) % songResources.length;
        initializeMediaPlayer();
        playMusic();
        updateSongTitle();
    }

    private void updateSongTitle() {
        String songName = getResources().getResourceEntryName(songResources[currentSongIndex]);
        songTitle.setText("Now Playing: " + songName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}