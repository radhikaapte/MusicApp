package com.example.android.musicapp;

public class Music {

    //name of the song
    private String mSongName;

    //name of the artist and album
    private String mArtistName;

    //name of the song Genre
    private String mMusicType;

    public Music(String songName, String artistName, String musicType) {

        mSongName = songName;
        mArtistName = artistName;
        mMusicType = musicType;

    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public String getMusicType() {
        return mMusicType;
    }

}
