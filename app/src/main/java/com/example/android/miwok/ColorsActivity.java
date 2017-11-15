package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends VocabularyActivity {
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
        int[] soundId = new int[] {
                R.raw.color_red,
                R.raw.color_mustard_yellow,
                R.raw.color_dusty_yellow,
                R.raw.color_green,
                R.raw.color_brown,
                R.raw.color_gray,
                R.raw.color_black,
                R.raw.color_white
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
        // It is ESSENTIAL that words be declared final, so that they can be used by OnItemClickListener
        final ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (int n = 0; n < word.length;  n++) {
            words.add(new Word(word[n][0], word[n][1], soundId[n], imgId[n]));
        }

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        // anonymous OnItemClick() method override
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(ColorsActivity.this, words.get(position).getSoundResourceId());
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
        );
    }
}
