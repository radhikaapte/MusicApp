package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SearchAdapter extends ArrayAdapter<Genre> {

    //Diplay the Genre of Music and also the music type
    public SearchAdapter(@NonNull Context context, ArrayList<Genre> musicGenre) {
        super(context, 0, musicGenre);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_search, parent, false);
        }

        Genre currentGenre = getItem(position);

        TextView searchTextView = (TextView) listItemView.findViewById(R.id.search_text_view);
        searchTextView.setText(currentGenre.getMusicGenre());

        ImageView searchImageView = (ImageView) listItemView.findViewById(R.id.search_image_view);
        searchImageView.setImageResource(currentGenre.getMusicImageId());

        return listItemView;
    }
}


