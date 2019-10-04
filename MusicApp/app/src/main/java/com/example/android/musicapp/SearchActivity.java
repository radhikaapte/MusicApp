package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent searchIntent = getIntent();
        final int searchPlaylist = searchIntent.getIntExtra("PLAYLIST", 0);
        final String searchSong = searchIntent.getStringExtra("NOW_PLAYING");
        final String searchArtist = searchIntent.getStringExtra("ARTIST_PLAYING");
        final String searchGenre = searchIntent.getStringExtra("GENRE_PLAYING");


        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(SearchActivity.this, MyPlaylistActivity.class);
                startActivity(playlistButtonIntent);
            }

        });

        Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(SearchActivity.this, SearchActivity.class);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(SearchActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "MySearchActivity");
                if (searchPlaylist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING", searchSong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", searchArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", searchGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });

        //Add the genre of songs
        ArrayList<Genre> genre = new ArrayList<Genre>();
        genre.add(new Genre("Pop", R.drawable.shrink_pop));
        genre.add(new Genre("Indian", R.drawable.shrink_indian));
        genre.add(new Genre("TV & Movies", R.drawable.shrink_movie));
        genre.add(new Genre("Workout", R.drawable.shrink_workout));

        SearchAdapter genreAdapter = new SearchAdapter(this, genre);

        GridView gridView = (GridView) findViewById(R.id.grid);

        gridView.setAdapter(genreAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //The code in this method will be executed when an item from grid view is clicked
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                final Intent intent;
                switch (i) {

                    case 0:
                        intent = new Intent(SearchActivity.this, PopMusicActivity.class);
                        break;

                    case 1:
                        intent = new Intent(SearchActivity.this, IndianMusicActivity.class);
                        break;
                    case 2:
                        intent = new Intent(SearchActivity.this, MoviesMusicActivity.class);
                        break;
                    case 3:
                        intent = new Intent(SearchActivity.this, WorkoutMusicActivity.class);
                        break;
                    default:
                        intent = new Intent(SearchActivity.this, SearchActivity.class);
                        break;

                }
                intent.putExtra("PLAYLIST",searchPlaylist);
                intent.putExtra("NOW_PLAYING", searchSong);
                intent.putExtra("ARTIST_PLAYING", searchArtist);
                intent.putExtra("GENRE_PLAYING", searchGenre);
                startActivity(intent);
            }

        });

    }

}
