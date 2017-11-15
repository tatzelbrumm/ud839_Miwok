package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
        int[] imgId = new int[] {
                R.drawable.number_one,
                R.drawable.number_two,
                R.drawable.number_three,
                R.drawable.number_four,
                R.drawable.number_five,
                R.drawable.number_six,
                R.drawable.number_seven,
                R.drawable.number_eight,
                R.drawable.number_nine,
                R.drawable.number_ten
        };

        ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (int n = 0; n < word.length;  n++) {
            words.add(new Word(word[n][0], word[n][1], imgId[n]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
