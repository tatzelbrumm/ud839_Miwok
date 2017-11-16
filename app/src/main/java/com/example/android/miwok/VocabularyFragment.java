package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VocabularyFragment extends Fragment {
    /** media player instance */
    protected MediaPlayer mMediaPlayer;
    /** audio manager instance */
    protected AudioManager mAudioManager;

    /** onCompletionListener for media player */
    protected MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
            mAudioManager.abandonAudioFocus(audiatur);
        }
    };

    /** OnAudioFocusChangeListener */
    protected AudioManager.OnAudioFocusChangeListener audiatur = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focus_change) {
            switch (focus_change) {
                case AudioManager.AUDIOFOCUS_LOSS:
                    //mMediaPlayer.stop();
                    releaseMediaPlayer();
                    mAudioManager.abandonAudioFocus(audiatur);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_GAIN:
                case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                    startAudio();
                    break;
                default:
            }
        }
    };



    public VocabularyFragment() {
        // Required empty public constructor
    }


    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to {@link Activity#onStop() Activity.onStop} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
        mAudioManager.abandonAudioFocus(audiatur);
    }

    /**
     * Fill vocabulary list
     * @param rootView      root view of fragment
     * @param words         ArrayList<Word> with words, translations, audio, and optional images
     * @param colorResId    text background color resource ID for screens
     */
    protected void fillList(View rootView, final ArrayList<Word> words, int colorResId) {
        FragmentActivity context = getActivity();
        //setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        WordAdapter itemsAdapter = new WordAdapter(context, words, colorResId);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        // anonymous OnItemClick() method override
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(getActivity(), words.get(position).getSoundResourceId());
                        int focus = mAudioManager.requestAudioFocus(audiatur, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                        if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == focus) {
                            startAudio();
                        }
                    }
                }
        );
    }
    /**
     * start playing audio
     */
    private void startAudio() {
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(mCompletionListener);
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
