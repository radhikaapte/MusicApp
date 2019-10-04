package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LibraryAdapter extends ArrayAdapter<Music> {

    public LibraryAdapter(@NonNull Context context, ArrayList<Music> musicLibrary) {
        super(context, 0, musicLibrary);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_library, parent, false);
        }

        Music nowPlayingMusic = getItem(position);

        TextView nowPlayingSongView = (TextView) listItemView.findViewById(R.id.nowPlayingSong);
        nowPlayingSongView.setText(nowPlayingMusic.getSongName());

        TextView nowPlayingArtistView = (TextView) listItemView.findViewById(R.id.nowPlayingArtist);
        nowPlayingArtistView.setText(nowPlayingMusic.getArtistName());

        return listItemView;
    }
}



