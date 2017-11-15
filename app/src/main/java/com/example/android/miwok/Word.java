package com.example.android.miwok;
/**
 * Created by cmaier on 14.11.17.
 * {@link Word} contains a word in default and Miwok languages and an image ID
 */
public class Word {
    /** Word in default language */
    private String mDefault;
    /** Word in Miwok language */
    private String mMiwok;
    /** Image resource ID */
    private int mImageResourceId;
    /** uninitialized image resource ID */
    private static final int UNINITIALIZED_IMAGE_RESOURCE_ID = R.mipmap.ic_launcher;
    /**
     * Constructor
     * @param en    Word in default language
     * @param miwok Word in Miwok language
     * @param imageID   image resource ID
     */
    public Word(String en, String miwok, int imageID)
    {
        mDefault = en;
        mMiwok = miwok;
        mImageResourceId = imageID;
    }
    /**
     * Constructor
     * @param en    Word in default language
     * @param miwok Word in Miwok language
     */
    public Word(String en, String miwok) {this(en, miwok, UNINITIALIZED_IMAGE_RESOURCE_ID);}
    /** get word in default language */
    public String getDefault() {return mDefault;}
    /** get word in Miwok language */
    public String getMiwok() {return mMiwok;}
    /** get image resource ID */
    public int getImageResourceId() {return mImageResourceId;}
    /** check if image has been initialized */
    public boolean hasImage() {return (UNINITIALIZED_IMAGE_RESOURCE_ID != mImageResourceId);}
}
