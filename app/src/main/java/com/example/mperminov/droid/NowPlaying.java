package com.example.mperminov.droid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        //find Playlist button from layout
        Button playlistButton = findViewById(R.id.but_playlist);
        //set new button listener which leads to activity_playlist
        playlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(NowPlaying.this, Playlist.class);
                startActivity(playlistIntent);
            }
        });

        final TextView tvCurrentArtist = findViewById(R.id.tv_artist);
        Button diskogsButton = findViewById(R.id.but_diskogs);
        //set new button listener which leads to browser with search query on diskogs.com site
        diskogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentArtist = tvCurrentArtist.getText().toString();
                currentArtist = currentArtist.replaceAll(" ", "+");
                String searchUrl = "https://www.discogs.com/search/?q=" + currentArtist
                        + "&type=artist";
                Intent diskogsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl));
                startActivity(diskogsIntent);
            }
        });
        Button infoButton = findViewById(R.id.but_info);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistIntent = new Intent(NowPlaying.this, ArtistInfo.class);
                artistIntent.putExtra("artist",tvCurrentArtist.getText());
                startActivity(artistIntent);
            }
        });
        Intent incomingIntent = getIntent();
        tvCurrentArtist.setText(incomingIntent.getStringExtra("artist"));
        TextView tvSongTitle = findViewById(R.id.tv_songtitle);
        tvSongTitle.setText(incomingIntent.getStringExtra("songTitle"));
        TextView tvLength = findViewById(R.id.length);
        tvLength.setText(incomingIntent.getStringExtra("length"));
        TextView tvAlbum = findViewById(R.id.tv_album);
        tvAlbum.setText(incomingIntent.getStringExtra("album"));
        ImageView ivAlbumCover = findViewById(R.id.iv_cover);
        ivAlbumCover.setImageResource(incomingIntent.getIntExtra("cover", 0));
    }


}
