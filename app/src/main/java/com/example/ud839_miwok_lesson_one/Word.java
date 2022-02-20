package com.example.ud839_miwok_lesson_one;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and Miwok translation for that word.
 */
public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
     */
    public Word(String defaultTranslation , String miwokTranslation,int imageResourceId,int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation , String miwokTranslation,int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation
     */
    public String getDefaultTranslation(){ return mDefaultTranslation; }
    /**
     * Get the Miwok Translation
     */
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    /**
     * Get image resource id
     */
    public int getImageResourceId(){return mImageResourceId;}

    /**
     * Return whether or not there is an image for this word
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    /**
     * ALt+INSERT shortcut key to select getter setter, toString() ,counstructor etc.
     * Returns the string representation of {@link Word} object
     * @return String
     */
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
