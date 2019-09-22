package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myPlaylist = (TextView) findViewById(R.id.myPlaylist);
        myPlaylist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, MyPlaylistActivity.class);
                startActivity(playlistIntent);
            }

        });

        TextView search = (TextView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);

            }

        });

        TextView myLibrary = (TextView) findViewById(R.id.myLibrary);
        myLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent libraryIntent = new Intent(MainActivity.this, MyLibraryActivity.class);
                startActivity(libraryIntent);


            }
        });

    }
}

