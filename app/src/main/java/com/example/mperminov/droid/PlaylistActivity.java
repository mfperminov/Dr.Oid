package com.example.mperminov.droid;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

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
        //when user tap on list item it must return to now_playing activity and set chosen song for playing
        playlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object tappedSong = playlist.getItemAtPosition(i);
                Song song = (Song) tappedSong;
                Intent nowPlayingIntent = new Intent(PlaylistActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra(IntentExtraStrings.getArtist(), song.getmArtist());
                nowPlayingIntent.putExtra(IntentExtraStrings.getmTitle(), song.getmTitle());
                nowPlayingIntent.putExtra(IntentExtraStrings.getLength(), song.getmLength());
                nowPlayingIntent.putExtra(IntentExtraStrings.getAlbum(), song.getmAlbum());
                nowPlayingIntent.putExtra(IntentExtraStrings.getCover(), song.getmAlbumArt());
                startActivity(nowPlayingIntent);
            }
        });
    }
    /* method to respond on selection of menu items
    * now it's only Up button, which actually works even without it.
    * But for future app expanding and development
    * I will remain it here
    */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
