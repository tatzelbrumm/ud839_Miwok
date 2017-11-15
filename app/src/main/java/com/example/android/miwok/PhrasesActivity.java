package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[][] word = new String[][]{
            {"Where are you going?", "minto wuksus"},
            {"What is your name?", "tinnә oyaase'nә"},
            {"My name is...", "oyaaset..."},
            {"How are you feeling?", "michәksәs?"},
            {"I’m feeling good.", "kuchi achit"},
            {"Are you coming?", "әәnәs'aa?"},
            {"Yes, I’m coming.", "hәә’ әәnәm"},
            {"I’m coming.", "әәnәm"},
            {"Let’s go.", "yoowutis"},
            {"Come here.", "әnni'nem"}
        };

        ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (String[] w : word) {
            words.add(new Word(w[0], w[1]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
