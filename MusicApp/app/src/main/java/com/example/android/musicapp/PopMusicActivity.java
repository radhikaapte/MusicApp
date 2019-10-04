package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PopMusicActivity extends AppCompatActivity {
    //Songs for music type Pop Music
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Intent popIntent = getIntent();
        final int popPlaylist = popIntent.getIntExtra("PLAYLIST", 0);
        final String popSong = popIntent.getStringExtra("NOW_PLAYING");
        final String popArtist = popIntent.getStringExtra("ARTIST_PLAYING");
        final String popGenre = popIntent.getStringExtra("GENRE_PLAYING");

        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(PopMusicActivity.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(PopMusicActivity.this, MyPlaylistActivity.class);
                startActivity(playlistButtonIntent);
            }

        });

        Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(PopMusicActivity.this, SearchActivity.class);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(PopMusicActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "PopActivity");
                if (popPlaylist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING",popSong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", popArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", popGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });


        ArrayList<Music> popMusic = new ArrayList<Music>();
        popMusic.add(new Music("Something Just Like This", "ColdPlay,Chris Martin", "Pop"));
        popMusic.add(new Music("Beautiful People", "Ed Sheeran and Khalid", "Pop"));
        popMusic.add(new Music("Lonely", "Jonas Brothers", "Pop"));
        popMusic.add(new Music("Right Back", "Khalid", "Pop"));
        popMusic.add(new Music("Wanted", "OneRepublic ", "Pop"));

        MusicAdapter itemsAdapter = new MusicAdapter(this, popMusic);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }

}
