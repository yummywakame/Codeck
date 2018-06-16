package com.yummywakame.codeck;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.yummywakame.codeck.BlurUtils;

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
        ImageView nowPlayingAuthorImageView = findViewById(R.id.playlist_author_image);

        // Set the layout song name and artist name to the values pulled from the intent
        nowPlayingTitleTextView.setText(nowPlayingIntent.getStringExtra("KEY_PLAYLIST_TITLE"));
        nowPlayingAuthorTextView.setText(nowPlayingIntent.getStringExtra("KEY_PLAYLIST_AUTHOR"));
        nowPlayingVideoURLTextView.setText(nowPlayingIntent.getStringExtra("KEY_PLAYLIST_VIDEO_URL"));
        nowPlayingVideoImageImageView.setImageResource(nowPlayingIntent.getIntExtra("KEY_PLAYLIST_VIDEO_IMAGE", 0));
        nowPlayingAuthorImageView.setImageResource(nowPlayingIntent.getIntExtra("KEY_PLAYLIST_AUTHOR_IMAGE", 0));

        // Blur background image
        ImageView nowPlayingVideoImageImageViewBlur = findViewById(R.id.playlist_video_image_blur);
        nowPlayingVideoImageImageViewBlur.setImageResource(nowPlayingIntent.getIntExtra("KEY_PLAYLIST_VIDEO_IMAGE", 0));
        Bitmap bitmap = ((BitmapDrawable) nowPlayingVideoImageImageViewBlur.getDrawable()).getBitmap();
        nowPlayingVideoImageImageViewBlur.setImageBitmap(new BlurUtils().blur(PlaylistActivity.this, bitmap, 8.5f));

        // Top back button toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // find buttons for onClickListeners
        final ImageView buttonPlay = findViewById(R.id.button_play);
        final ImageView buttonSkipNext = findViewById(R.id.button_skip_next);
        final ImageView buttonSkipPrevious = findViewById(R.id.button_skip_previous);

        // do a simple fade effect animation on the button when clicked
        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);

        // play / pause button click listener
        buttonPlay.setTag(1);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonPlay.getTag().equals(1)) {
                    buttonPlay.setImageResource(R.drawable.icon_play);
                    buttonPlay.startAnimation(buttonClick);
                    buttonPlay.setTag(2);
                } else {
                    buttonPlay.setImageResource(R.drawable.icon_pause);
                    buttonPlay.startAnimation(buttonClick);
                    buttonPlay.setTag(1);
                }
            }
        });

        // skip previous button click listener
        buttonSkipPrevious.setTag(1);
        buttonSkipPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSkipPrevious.startAnimation(buttonClick);
            }
        });

        // skip next button click listener
        buttonSkipNext.setTag(1);
        buttonSkipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSkipNext.startAnimation(buttonClick);
            }
        });
    }
}