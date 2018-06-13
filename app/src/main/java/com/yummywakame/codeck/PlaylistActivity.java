package com.yummywakame.codeck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The Playlist Activity displays data from the clicked GridView item:
 * Playlist's YouTube video/image, the playlist's author, author image and playlist Title.
 */

public class PlaylistActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // Get the intent that was used to start this activity
        Intent nowPlayingIntent = getIntent();

        // Grab the TextViews and Resource IDs for selected playlist
        TextView nowPlayingTitleTextView = findViewById(R.id.playlist_title);
        TextView nowPlayingAuthorTextView = findViewById(R.id.playlist_author);
        TextView nowPlayingVideoURLTextView = findViewById(R.id.playlist_video_url);
        ImageView nowPlayingVideoImageImageView = findViewById(R.id.playlist_video_image);
        //TextView nowPlayingAuthorImageView = (TextView) findViewById(R.id.playlist_author_image);

        // Set the layout song name and artist name to the values pulled from the intent
        nowPlayingTitleTextView.setText(nowPlayingIntent.getStringExtra("KEY_PLAYLIST_TITLE"));
        nowPlayingAuthorTextView.setText(nowPlayingIntent.getStringExtra("KEY_PLAYLIST_AUTHOR"));
        nowPlayingVideoURLTextView.setText(nowPlayingIntent.getStringExtra("KEY_PLAYLIST_VIDEO_URL"));
        nowPlayingVideoImageImageView.setImageResource(nowPlayingIntent.getIntExtra("KEY_PLAYLIST_VIDEO_IMAGE", 0));
        //nowPlayingAuthorImageView.setImageResource(nowPlayingIntent.getIntExtra("KEY_PLAYLIST_AUTHOR_IMAGE", 0));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}