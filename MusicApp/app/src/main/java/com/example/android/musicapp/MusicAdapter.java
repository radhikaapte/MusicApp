package com.example.android.musicapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    //Music Adapter to get the songs from playlist and also display current playing song
    public MusicAdapter(@NonNull Context context, ArrayList<Music> musicSongs) {
        super(context, 0, musicSongs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_music, parent, false);
        }

        final Music currentSong = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        songTextView.setText(currentSong.getSongName());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentSong.getArtistName());

        listItemView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyLibraryActivity.class);
                intent.putExtra("ACTIVITY_ID", "MyPlaylist");
                intent.putExtra("NOW_PLAYING", currentSong.getSongName());
                intent.putExtra("ARTIST_PLAYING", currentSong.getArtistName());
                intent.putExtra("GENRE_PLAYING", currentSong.getMusicType());
                getContext().startActivity(intent);
            }

        });

        return listItemView;
    }
}

