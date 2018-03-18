package com.example.mperminov.droid;

/**
 * {@link Song} class contains three string fields for artist, song title and album.
 * ALso length is represented by int number of seconds
 * Album art use int id.
 * In app song objects should be created by reading tags of (mp3 for example),
 * but for this project I will populate it by hands
 */

public class Song {
    //Correspond to TPE1 in ID3v2 specification
    private String mArtist;
    //Correspond to TIT2 in ID3v2 specification
    private String mTitle;
    //Correspond to TALB in ID3v2 specification
    private String mAlbum;
    //Correspond to TLEN in ID3v2 specification
    private int mLength;
    int mAlbumArt;

    public Song(String artist, String title, String album, int length, int albumArt) {
        mArtist = artist;
        mTitle = title;
        mAlbum = album;
        mLength = length;
        mAlbumArt = albumArt;
    }

    public String getmArtist() {
        return mArtist;
    }

    public String getmAlbum() {
        return mAlbum;
    }

    public String getmTitle() {
        return mTitle;
    }

    /**
      * @return length of Song in format of "MM:SS"
     */

    public String getmLength() {
        int m = mLength / 60;
        int s = mLength % 60;
        //I know, this is total bullshit, on the next project I swear, I will use String.format
        String zeroM = (m < 10) ? "0" : "";
        String zeroS = (s < 10) ? "0" : "";
        return (zeroM + Integer.toString(m) + ":" + zeroS + Integer.toString(s));
    }

    public int getmAlbumArt() {

        return mAlbumArt;
    }
}
