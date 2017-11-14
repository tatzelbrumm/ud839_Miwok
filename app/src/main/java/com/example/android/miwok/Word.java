package com.example.android.miwok;

/**
 * Created by cmaier on 14.11.17.
 */

/**
 * {@link Word} contains a word in default and Miwok languages
 */
public class Word {
    /** Word in default language */
    private String mDefault;
    /** Word in Miwok language */
    private String mMiwok;
    /**
     * Constructor
     * @param en    Word in default language
     * @param miwok Word in Miwok language
     */
    public Word(String en, String miwok) {
        mDefault = en;
        mMiwok = miwok;
    }
    /** get word in default language */
    public String getDefault() {return mDefault;}
    /** get word in Miwok language */
    public String getMiwok() {return mMiwok;}
}
