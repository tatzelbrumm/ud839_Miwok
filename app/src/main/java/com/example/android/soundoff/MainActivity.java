package com.example.android.soundoff;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer playa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playa = MediaPlayer.create(this, R.raw.feinkost_zipp_uhr);
        playa.start(); // no need to call prepare(); create() does that for you
    }
}
