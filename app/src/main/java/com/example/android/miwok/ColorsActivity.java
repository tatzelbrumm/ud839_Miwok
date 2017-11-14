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

        ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (String[] w : word) {
            words.add(new Word(w[0], w[1]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
