package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        String[] word = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        ArrayList<String> words = new ArrayList<String>(word.length);
        for (int n = 0; n < word.length; words.add(word[n++]));
        for (int n = 0; n < words.size(); Log.i("NumbersActivity","Word [" + n +"] is: " + words.get(n++)));
    }
}
