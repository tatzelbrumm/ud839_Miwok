package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        for (int n = 0; n < words.length; Log.i("NumbersActivity","Word [" + n +"] is: " + words[n++]));
    }
}
