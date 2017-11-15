package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer playa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playa = MediaPlayer.create(this, R.raw.feinkost_zipp_uhr);

        playa.start(); // no need to call prepare(); create() does that for you
        // OnCompletionListener needs to be set AFTER start of media player
        playa.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this, "Danke. Kein Wirsing.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
