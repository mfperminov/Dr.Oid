package com.example.mperminov.droid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Playlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        //test ArrayList with of custom class Song
        ArrayList<Song> numberOfTheBeast = new ArrayList<>();
        String artist = "Iron Maiden";
        String album = "The Number of the Beast";
        String[] trackTitles = {"Invaders", "Children of the Damned", "The Prisoner",
                "22 Acacia Avenue", "The Number of the Beast", "Run to the Hills",
                "Gangland", "Hallowed Be Thy Name"};
        //length of all tracks are given in seconds
        int[] trackLengths = {204, 276, 363, 398, 291, 234, 229, 433};
        int albumCover = R.drawable.number_of_the_beast_cover;
        //fill ArrayList with Song Object created by pieces of previous Arrays
        for (int i = 0; i < trackTitles.length; i++) {
            numberOfTheBeast.add(new Song(artist, trackTitles[i], album, trackLengths[i], albumCover));
        }
        //set up an adapter to LitView
        SongAdapter adapter = new SongAdapter(this, numberOfTheBeast);
        final ListView playlist = findViewById(R.id.playlist);
        playlist.setAdapter(adapter);
        //when user tap on list item it must return to now_playing actoivity and set chosen song for playing
        playlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object tappedSong = playlist.getItemAtPosition(i);
                Song song = (Song) tappedSong;
                Intent nowPlayingIntent = new Intent(Playlist.this, NowPlaying.class);
                nowPlayingIntent.putExtra("artist", song.getmArtist());
                nowPlayingIntent.putExtra("songTitle", song.getmTitle());
                nowPlayingIntent.putExtra("length", song.getmLength());
                nowPlayingIntent.putExtra("album", song.getmAlbum());
                nowPlayingIntent.putExtra("cover", song.getmAlbumArt());
                startActivity(nowPlayingIntent);
            }
        });

    }
}
