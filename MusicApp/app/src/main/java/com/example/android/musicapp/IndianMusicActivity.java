package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class IndianMusicActivity extends AppCompatActivity {
    //songs for Music type Indian Music
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Intent indianIntent = getIntent();
        final int indianPlaylist = indianIntent.getIntExtra("PLAYLIST", 0);
        final String indianSong = indianIntent.getStringExtra("NOW_PLAYING");
        final String indianArtist = indianIntent.getStringExtra("ARTIST_PLAYING");
        final String indianGenre = indianIntent.getStringExtra("GENRE_PLAYING");

        Button homeButton = (Button)findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent homeButtonIntent = new Intent(IndianMusicActivity.this, MainActivity.class);
                startActivity(homeButtonIntent);
            }

        });

        Button playlistButton = ( Button)findViewById(R.id.playlistButton);

        playlistButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent playlistButtonIntent = new Intent(IndianMusicActivity.this, MyPlaylistActivity.class);
                startActivity(playlistButtonIntent);
            }

        });

        Button searchButton = ( Button)findViewById(R.id.searchButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(IndianMusicActivity.this, SearchActivity.class);
                startActivity(searchButtonIntent);
            }

        });

        Button libraryButton = ( Button)findViewById(R.id.libraryButton);

        libraryButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the My Playlist View is clicked on.
            public void onClick(View view) {
                Intent libraryButtonIntent = new Intent(IndianMusicActivity.this, MyLibraryActivity.class);
                libraryButtonIntent.putExtra("ACTIVITY_ID", "IndianMusicActivity");
                if (indianPlaylist != 0){
                    libraryButtonIntent.putExtra("ACTIVITY_ID", "MyLibraryAgainActivity");
                    libraryButtonIntent.putExtra("NOW_PLAYING",indianSong);
                    libraryButtonIntent.putExtra("ARTIST_PLAYING", indianArtist);
                    libraryButtonIntent.putExtra("GENRE_PLAYING", indianGenre);
                }
                startActivity(libraryButtonIntent);
            }

        });


        ArrayList<Music> indianMusic = new ArrayList<Music>();
        indianMusic.add(new Music("Teri Deewani", "Kailasa,Kailash Kher ", "Indian"));
        indianMusic.add(new Music("Doori", "Gully Boy, Ranveer Singh", "Indian"));
        indianMusic.add(new Music("Soorma Anthem", "Soorma, Shankar Mahadevan", "Indian"));
        indianMusic.add(new Music("Rowdy Baby", "Maari 2, Dhanush and Sai Pallavi", "Indian"));
        indianMusic.add(new Music("Naina Da Kya Kasoor", "Andhadhun,Amit Trivedi ", "Indian"));

        MusicAdapter itemsAdapter = new MusicAdapter(this, indianMusic);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }

}
