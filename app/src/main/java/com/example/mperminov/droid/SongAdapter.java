package com.example.mperminov.droid;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom ArrayAdapter for Song object
 */

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> songList) {
        super(context, 0, songList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songview, parent, false);
        }
        // Get the Song object located at this position in the list
        Song currentSong = getItem(position);
        // Find the TextView in the songview.xml layout with the ID version_name
        TextView artistTextView = listItemView.findViewById(R.id.tv_artist_songview);
        // Get the Artist name  from the current Song object and
        // set this text on the TextView
        artistTextView.setText(currentSong.getmArtist());
        //the same for Song title, album and length
        TextView titleTextView = listItemView.findViewById(R.id.tv_songname_songview);
        titleTextView.setText(currentSong.getmTitle());
        TextView albumTextView = listItemView.findViewById(R.id.tv_album_songview);
        albumTextView.setText(currentSong.getmAlbum());
        TextView lengthTextView = listItemView.findViewById(R.id.tv_length_songview);
        lengthTextView.setText(currentSong.getmLength());
        return listItemView;
    }
}
