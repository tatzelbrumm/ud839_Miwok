package com.example.android.miwok;

import android.os.Bundle;

import java.util.ArrayList;

public class PhrasesActivity extends VocabularyActivity {
    /**
     * onCreate sets up the dictionary list entries
     * @param savedInstanceState
     */
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
        int[] soundId = new int[] {
                R.raw.phrase_where_are_you_going,
                R.raw.phrase_what_is_your_name,
                R.raw.phrase_my_name_is,
                R.raw.phrase_how_are_you_feeling,
                R.raw.phrase_im_feeling_good,
                R.raw.phrase_are_you_coming,
                R.raw.phrase_yes_im_coming,
                R.raw.phrase_im_coming,
                R.raw.phrase_lets_go,
                R.raw.phrase_come_here
        };
        // It is ESSENTIAL that words be declared final, so that they can be used by OnItemClickListener
        final ArrayList<Word> words = new ArrayList<Word>(word.length);
        for (int n = 0; n < word.length; n++) {
            words.add(new Word(word[n][0], word[n][1], soundId[n]));
        }

        fillList(this, words, R.color.category_phrases);
    }
}
