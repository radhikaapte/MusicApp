package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        Intent homeIntent = getIntent();
        final int homePlaylist = homeIntent.getIntExtra("PLAYLIST", 0);
        final String homeSong = homeIntent.getStringExtra("NOW_PLAYING");
        final String homeArtist = homeIntent.getStringExtra("ARTIST_PLAYING");
        final String homeGenre = homeIntent.getStringExtra("GENRE_PLAYING");

        TextView myPlaylist = (TextView) findViewById(R.id.myPlaylist);
        myPlaylist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, MyPlaylistActivity.class);
                startActivity(playlistIntent);
            }

        });

        TextView search = (TextView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Search View is clicked on.
            @Override
            public void onClick(View view) {

                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);

            }

        });

        TextView myLibrary = (TextView) findViewById(R.id.myLibrary);
        myLibrary.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Library View is clicked on.
            @Override
            public void onClick(View view) {

                Intent libraryIntent = new Intent(MainActivity.this, MyLibraryActivity.class);
                libraryIntent.putExtra("ACTIVITY_ID", "MainActivity");
                if (homePlaylist!= 0){
                    libraryIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryIntent.putExtra("NOW_PLAYING", homeSong);
                    libraryIntent.putExtra("ARTIST_PLAYING", homeArtist);
                    libraryIntent.putExtra("GENRE_PLAYING", homeGenre);
                }
                startActivity(libraryIntent);


            }
        });

        ImageView myMusic = (ImageView) findViewById(R.id.myMusic);
        myMusic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Music Image is clicked on.
            @Override
            public void onClick(View view) {

                Intent musicIntent = new Intent(MainActivity.this, MyLibraryActivity.class);
                musicIntent.putExtra("ACTIVITY_ID","MainActivity");
                startActivity(musicIntent);
            }
        });

        TextView myMusicList = (TextView) findViewById(R.id.playlistText);
        myMusicList.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Your Playist View is clicked on.
            @Override
            public void onClick(View view) {

                Intent musicListIntent = new Intent(MainActivity.this, MyLibraryActivity.class);
                musicListIntent.putExtra("ACTIVITY_ID","MainActivity");
                startActivity(musicListIntent);


            }
        });

    }
}

