package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyLibraryActivity extends AppCompatActivity {
    //This activity is generated from My Playlist as an Intent
    String nowPlaySong;
    String nowPlayArtist;
    String nowPlayGenre;
    int playlist = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(MyLibraryActivity.this, MainActivity.class);
                homeButtonIntent.putExtra("PLAYLIST",playlist);
                homeButtonIntent.putExtra("NOW_PLAYING", nowPlaySong);
                homeButtonIntent.putExtra("ARTIST_PLAYING", nowPlayArtist);
                homeButtonIntent.putExtra("GENRE_PLAYING", nowPlayGenre);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(MyLibraryActivity.this, MyPlaylistActivity.class);
                playlistButtonIntent.putExtra("PLAYLIST",playlist);
                playlistButtonIntent.putExtra("NOW_PLAYING", nowPlaySong);
                playlistButtonIntent.putExtra("ARTIST_PLAYING", nowPlayArtist);
                playlistButtonIntent.putExtra("GENRE_PLAYING", nowPlayGenre);
                startActivity(playlistButtonIntent);
            }

        });

        final Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(MyLibraryActivity.this, SearchActivity.class);
                searchButtonIntent.putExtra("PLAYLIST",playlist);
                searchButtonIntent.putExtra("NOW_PLAYING", nowPlaySong);
                searchButtonIntent.putExtra("ARTIST_PLAYING", nowPlayArtist);
                searchButtonIntent.putExtra("GENRE_PLAYING", nowPlayGenre);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(MyLibraryActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryActivity");
                if (playlist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING", nowPlaySong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", nowPlayArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", nowPlayGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });


        Intent intent = getIntent();
        String activity = intent.getStringExtra("ACTIVITY_ID");

        if (intent != null && (activity.equals("MyPlaylist") || activity.equals("MyLibraryAgainActivity"))) {
            nowPlaySong = intent.getStringExtra("NOW_PLAYING");
            nowPlayArtist = intent.getStringExtra("ARTIST_PLAYING");
            nowPlayGenre = intent.getStringExtra("GENRE_PLAYING");
            playlist++;
        } else {
            nowPlaySong = "No Song Playing Now";
            nowPlayArtist = "Unknown";
            nowPlayGenre = "Unknown";
        }

        ArrayList<Music> nowPlaying = new ArrayList<Music>();

        nowPlaying.add(new Music(nowPlaySong, nowPlayArtist, nowPlayGenre));

        LibraryAdapter playingAdapter = new LibraryAdapter(this, nowPlaying);

        ListView playView = (ListView) findViewById(R.id.library);

        playView.setAdapter(playingAdapter);

    }

}