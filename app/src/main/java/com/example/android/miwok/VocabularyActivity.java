package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Class VocabularyActivity contains common code for the different vocabularies, to save copying
 * Created by cmaier on 15.11.17.
 */
public class VocabularyActivity extends AppCompatActivity {
    /** media player instance */
    protected MediaPlayer mMediaPlayer;
    /** onCompletionListener for media player */
    protected MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * onStop, stop playing sound by releasing any existing media player
     */
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Fill vocabulary list
     * @param context       android.app.Activity calling
     * @param words         ArrayList<Word> with words, translations, audio, and optional images
     * @param colorResId    text background color resource ID for screens
     */
    protected void fillList(final android.app.Activity context, final ArrayList<Word> words, int colorResId) {
        setContentView(R.layout.word_list);

        WordAdapter itemsAdapter = new WordAdapter(context, words, colorResId);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        // anonymous OnItemClick() method override
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(context, words.get(position).getSoundResourceId());
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    protected void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
