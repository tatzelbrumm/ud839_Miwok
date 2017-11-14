package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        String[][] word = new String[][]{
            {"one", "lutti"},
            {"two", "otiiko"},
            {"three", "tolookosu"},
            {"four", "oyyisa"},
            {"five", "massokka"},
            {"six", "temmokka"},
            {"seven", "kenekaku"},
            {"eight", "kawinta"},
            {"nine", "wo’e"},
            {"ten", "na’aacha"}
        };

        ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (String[] w : word) {
            words.add(new Word(w[0], w[1]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
