package com.example.mperminov.droid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        //find PlaylistActivity button from layout
        Button playlistButton = findViewById(R.id.but_playlist);
        //set new button listener which leads to activity_playlist
        playlistButton.setOnClickListener(this);
        Button diskogsButton = findViewById(R.id.but_diskogs);
        //set new button listener which leads to browser with search query on diskogs.com site
        diskogsButton.setOnClickListener(this);
        Button infoButton = findViewById(R.id.but_info);
        //set new button listener which leads to activity with artist information
        infoButton.setOnClickListener(this);
        Intent incomingIntent = getIntent();
        final TextView tvCurrentArtist = findViewById(R.id.tv_artist);
        tvCurrentArtist.setText(incomingIntent.getStringExtra(IntentExtraStrings.getArtist()));
        TextView tvSongTitle = findViewById(R.id.tv_songtitle);
        tvSongTitle.setText(incomingIntent.getStringExtra(IntentExtraStrings.getmTitle()));
        TextView tvLength = findViewById(R.id.length);
        tvLength.setText(incomingIntent.getStringExtra(IntentExtraStrings.getLength()));
        TextView tvAlbum = findViewById(R.id.tv_album);
        tvAlbum.setText(incomingIntent.getStringExtra(IntentExtraStrings.getAlbum()));
        ImageView ivAlbumCover = findViewById(R.id.iv_cover);
        ivAlbumCover.setImageResource(incomingIntent.getIntExtra(IntentExtraStrings.getCover(), 0));
    }

    @Override
    public void onClick(View v) {
        // Perform action on click
        final TextView tvCurrentArtist = findViewById(R.id.tv_artist);
        switch (v.getId()) {
            case R.id.but_info:
                Intent artistIntent = new Intent(NowPlayingActivity.this, ArtistInfoActivity.class);
                artistIntent.putExtra(IntentExtraStrings.getArtist(), tvCurrentArtist.getText());
                startActivity(artistIntent);
                break;
            case R.id.but_diskogs:
                String currentArtist = tvCurrentArtist.getText().toString();
                currentArtist = currentArtist.replaceAll(" ", "+");
                String searchUrl = "https://www.discogs.com/search/?q=" + currentArtist
                        + "&type=artist";
                Intent diskogsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl));
                startActivity(diskogsIntent);
                break;
            case R.id.but_playlist:
                Intent playlistIntent = new Intent(NowPlayingActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
                break;
        }
    }
}
