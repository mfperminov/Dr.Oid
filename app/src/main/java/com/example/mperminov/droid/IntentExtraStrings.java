package com.example.mperminov.droid;

/**
 * Class contains strings that passed as "name" values of extra with intents.
 */

public  class IntentExtraStrings {
    final static String artist = "artist";
    final static String title = "songTitle";
    final static String length = "length";
    final static String album = "album";
    final static String cover = "cover";

    public static String getArtist() {
        return artist;
    }

    public static String getmTitle() {
        return title;
    }

    public static String getLength() {
        return length;
    }

    public static String getAlbum() {
        return album;
    }

    public static String getCover() {
        return cover;
    }
}
