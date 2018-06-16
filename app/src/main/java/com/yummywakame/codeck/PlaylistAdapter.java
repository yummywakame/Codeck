package com.yummywakame.codeck;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * {@link PlaylistAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Playlist} objects.
 * */
public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    private static final String LOG_TAG = PlaylistAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param Playlists A List of Playlist objects to display in a list
     */
    public PlaylistAdapter(Activity context, ArrayList<Playlist> Playlists) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for multiple TextViews and an ImageView, the adapter
        // is not going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, Playlists);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Playlist} object located at this position in the list
        final Playlist currentPlaylist = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID playlist_title
        TextView playlistTitleTextView = gridItemView.findViewById(R.id.playlist_title);
        // Get the version name from the current Playlist object and
        // set this text on the title TextView
        playlistTitleTextView.setText(currentPlaylist.getPlaylistTitle());

        // Find the ImageView in the list_item.xml layout with the ID playlist_video_image
        ImageView playlistVideoImageView = gridItemView.findViewById(R.id.playlist_video_image);
        // Get the image resource ID from the current Playlist object and
        // set the image to the playlist image
        playlistVideoImageView.setImageResource(currentPlaylist.getPlaylistVideoImage());

        // Find the ImageView in the list_item.xml layout with the ID playlist_author_image
        ImageView playlistAuthorImageView = gridItemView.findViewById(R.id.playlist_author_image);
        // Get the image resource ID from the current Playlist object and
        // set the image to the playlist image
        playlistAuthorImageView.setImageResource(currentPlaylist.getPlaylistAuthorImage());

        // Set the OnClick listener for the layout
        gridItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nowPlayingIntent = new Intent(getContext(), PlaylistActivity.class);
                // Add the song name and artist name to the intent sent to NowPlayingActivity

                nowPlayingIntent.putExtra("KEY_PLAYLIST_TITLE", currentPlaylist.getPlaylistTitle());
                nowPlayingIntent.putExtra("KEY_PLAYLIST_AUTHOR", currentPlaylist.getPlaylistAuthor());
                nowPlayingIntent.putExtra("KEY_PLAYLIST_VIDEO_URL", currentPlaylist.getPlaylistVideoURL());
                nowPlayingIntent.putExtra("KEY_PLAYLIST_VIDEO_IMAGE", currentPlaylist.getPlaylistVideoImage());
                nowPlayingIntent.putExtra("KEY_PLAYLIST_AUTHOR_IMAGE", currentPlaylist.getPlaylistAuthorImage());
                getContext().startActivity(nowPlayingIntent);
            }
        });

        // Return the whole grid item layout
        // so that it can be shown in the GridView
        return gridItemView;
    }

}
