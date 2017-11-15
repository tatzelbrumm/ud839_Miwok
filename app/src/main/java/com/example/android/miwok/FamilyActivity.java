package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        String[][] word = new String[][]{
            {"father", "әpә"},
            {"mother", "әṭa"},
            {"son", "angsi"},
            {"daughter", "tune"},
            {"older brother", "taachi"},
            {"younger brother", "chalitti"},
            {"older sister", "teṭe"},
            {"younger sister", "kolliti"},
            {"grandmother ", "ama"},
            {"grandfather", "paapa"}
        };
        int[] soundId = new int[] {
                R.raw.family_father,
                R.raw.family_mother,
                R.raw.family_son,
                R.raw.family_daughter,
                R.raw.family_older_brother,
                R.raw.family_younger_brother,
                R.raw.family_older_sister,
                R.raw.family_younger_sister,
                R.raw.family_grandmother,
                R.raw.family_grandfather
        };
        int[] imgId = new int[] {
                R.drawable.family_father,
                R.drawable.family_mother,
                R.drawable.family_son,
                R.drawable.family_daughter,
                R.drawable.family_older_brother,
                R.drawable.family_younger_brother,
                R.drawable.family_older_sister,
                R.drawable.family_younger_sister,
                R.drawable.family_grandmother,
                R.drawable.family_grandfather
        };

        ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (int n = 0; n < word.length;  n++) {
            words.add(new Word(word[n][0], word[n][1], soundId[n], imgId[n]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
