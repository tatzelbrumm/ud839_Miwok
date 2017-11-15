package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[][] word = new String[][]{
            {"red", "weṭeṭṭi"},
            {"mustard yellow", "chiwiiṭә"},
            {"dusty yellow", "ṭopiisә"},
            {"green", "chokokki"},
            {"brown", "ṭakaakki"},
            {"gray", "ṭopoppi"},
            {"black", "kululli"},
            {"white", "kelelli"}
        };
        int[] imgId = new int[] {
                R.drawable.color_red,
                R.drawable.color_mustard_yellow,
                R.drawable.color_dusty_yellow,
                R.drawable.color_green,
                R.drawable.color_brown,
                R.drawable.color_gray,
                R.drawable.color_black,
                R.drawable.color_white
        };

        ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (int n = 0; n < word.length;  n++) {
            words.add(new Word(word[n][0], word[n][1], imgId[n]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
