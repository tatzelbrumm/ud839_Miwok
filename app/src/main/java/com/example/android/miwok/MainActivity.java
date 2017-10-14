package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static MediaPlayer playa = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (null == playa)
            playa = MediaPlayer.create(this, R.raw.feinkost_zipp_uhr);
        playa.start(); // no need to call prepare(); create() does that for you
    }
}
