package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyPlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Intent playlistIntent = getIntent();
        final int playPlaylist = playlistIntent.getIntExtra("PLAYLIST", 0);
        final String playlistSong = playlistIntent.getStringExtra("NOW_PLAYING");
        final String playlistArtist = playlistIntent.getStringExtra("ARTIST_PLAYING");
        final String playlistGenre = playlistIntent.getStringExtra("GENRE_PLAYING");


        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(MyPlaylistActivity.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(MyPlaylistActivity.this, MyPlaylistActivity.class);
                startActivity(playlistButtonIntent);
            }

        });

        Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(MyPlaylistActivity.this, SearchActivity.class);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(MyPlaylistActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "MyPlaylistActivity");
                if (playPlaylist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING",playlistSong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", playlistArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", playlistGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });

        //Add the songs in your playlist
        final ArrayList<Music> playlist = new ArrayList<Music>();
        playlist.add(new Music("Something Just Like This", "ColdPlay,Chris Martin", "Pop"));
        playlist.add(new Music("Doori", "Gully Boy, Ranveer Singh", "Indian"));
        playlist.add(new Music("The Night King", "Game of Thrones,Ramin Djawadi", "TV & Movies"));
        playlist.add(new Music("Dreaming of the Crash", "Interstellar, Hans Zimmer", "TV & Movies"));
        playlist.add(new Music("Naina Da Kya Kasoor", "Andhadhun,Amit Trivedi ", "Indian"));
        playlist.add(new Music("Teri Deewani", "Kailasa,Kailash Kher ", "Indian"));
        playlist.add(new Music("Shape of You", "Ed Sheeran ", "Workout"));
        playlist.add(new Music("Titanium", "David Guetta ", "Workout"));
        playlist.add(new Music("Beautiful People", "Ed Sheeran and Khalid", "Pop"));
        playlist.add(new Music("We Built Our Own World", "Inception, Hans Zimmer ", "TV & Movies"));

        MusicAdapter itemsAdapter = new MusicAdapter(this, playlist);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}