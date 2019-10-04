package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MoviesMusicActivity extends AppCompatActivity {
    //songs for music type Moves Music
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Intent moviesIntent = getIntent();
        final int moviesPlaylist = moviesIntent.getIntExtra("PLAYLIST", 0);
        final String moviesSong = moviesIntent.getStringExtra("NOW_PLAYING");
        final String moviesArtist = moviesIntent.getStringExtra("ARTIST_PLAYING");
        final String moviesGenre = moviesIntent.getStringExtra("GENRE_PLAYING");


        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(MoviesMusicActivity.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(MoviesMusicActivity.this, MyPlaylistActivity.class);
                startActivity(playlistButtonIntent);
            }

        });

        Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(MoviesMusicActivity.this, SearchActivity.class);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(MoviesMusicActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "MoviesMusicActivity");
                if (moviesPlaylist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING",moviesSong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", moviesArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", moviesGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });


        ArrayList<Music> moviesMusic = new ArrayList<Music>();
        moviesMusic.add(new Music("We Built Our Own World", "Inception, Hans Zimmer ", "TV & Movies"));
        moviesMusic.add(new Music("Circle of Life", "Lindiwe Mkhize", "TV & Movies"));
        moviesMusic.add(new Music("The Night King", "Game of Thrones,Ramin Djawadi", "TV & Movies"));
        moviesMusic.add(new Music("Dreaming of the Crash", "Interstellar, Hans Zimmer", "TV & Movies"));
        moviesMusic.add(new Music("We'll Meet Again", "Vera Lynn ", "TV & Movies"));

        MusicAdapter itemsAdapter = new MusicAdapter(this, moviesMusic);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }

}
