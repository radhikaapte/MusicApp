package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WorkoutMusicActivity extends AppCompatActivity {
    //Songs for music type Workout Music
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Intent workoutIntent = getIntent();
        final int workoutPlaylist = workoutIntent.getIntExtra("PLAYLIST", 0);
        final String workoutSong = workoutIntent.getStringExtra("NOW_PLAYING");
        final String workoutArtist = workoutIntent.getStringExtra("ARTIST_PLAYING");
        final String workoutGenre = workoutIntent.getStringExtra("GENRE_PLAYING");

        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(WorkoutMusicActivity.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(WorkoutMusicActivity.this, MyPlaylistActivity.class);
                startActivity(playlistButtonIntent);
            }

        });

        Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(WorkoutMusicActivity.this, SearchActivity.class);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(WorkoutMusicActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "WorkoutMusicActivity");
                if (workoutPlaylist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING",workoutSong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", workoutArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", workoutGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });



        ArrayList<Music> workoutMusic = new ArrayList<Music>();
        workoutMusic.add(new Music("Shape of You", "Ed Sheeran ", "Workout"));
        workoutMusic.add(new Music("Titanium", "David Guetta ", "Workout"));
        workoutMusic.add(new Music("Stronger", "Kayne West", "Workout"));
        workoutMusic.add(new Music("Feel it Still", "Portugal", "Workout"));
        workoutMusic.add(new Music("Telephone", "Lady Gaga", "Workout"));

        MusicAdapter itemsAdapter = new MusicAdapter(this, workoutMusic);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }

}
