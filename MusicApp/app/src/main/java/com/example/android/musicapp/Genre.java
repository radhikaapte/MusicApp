package com.example.android.musicapp;

public class Genre {

    private String mMusicGenre;

    private int mMusicImageId;

    public Genre(String musicGenre, int musicImageId) {

        mMusicGenre = musicGenre;
        mMusicImageId = musicImageId;

    }

    public String getMusicGenre() {
        return mMusicGenre;
    }

    public int getMusicImageId() {
        return mMusicImageId;
    }

}
