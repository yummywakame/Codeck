package com.yummywakame.codeck;

/**
 * {@link Playlist} represents a YouTube playlist.
 * Each object has 5 properties: playlist name, playlist author, playlist video URL, video image resource ID, and author image resource ID.
 */
public class Playlist {

    // Title of the playlist (e.g. lonely day - lofi hiphop mix)
    private String mPlaylistTitle;

    // Author of the playlist (e.g. cloudx music)
    private String mPlaylistAuthor;

    // YouTube URL for the playlist's video (e.g. wOMwO5T3yT4)
    private String mPlaylistVideoURL;

    // Image of the playlist video
    private int mPlaylistVideoImage;

    // Image of the playlist author
    private int mPlaylistAuthorImage;


    /**
     * Create a new Playlist object.
     *
     * @param pTitle       is the playlist title (e.g. Programming Mix)
     * @param pAuthor      is the playlist author (e.g. programmersmusic)
     * @param pVideoURL    is the YouTube URL to the playlist's video (wOMwO5T3yT4)
     * @param pVideoImage  is drawable reference ID that corresponds to video's thumbnail image
     * @param pAuthorImage is drawable reference ID that corresponds to the playlist author image
     **/
    public Playlist(String pTitle, String pAuthor, String pVideoURL, int pVideoImage, int pAuthorImage) {
        mPlaylistTitle = pTitle;
        mPlaylistAuthor = pAuthor;
        mPlaylistVideoURL = pVideoURL;
        mPlaylistVideoImage = pVideoImage;
        mPlaylistAuthorImage = pAuthorImage;
    }

    /**
     * Get the playlist title
     */
    public String getPlaylistTitle() {
        return mPlaylistTitle;
    }

    /**
     * Get the playlist author
     */
    public String getPlaylistAuthor() {
        return mPlaylistAuthor;
    }

    /**
     * Get the YouTube URL for the playlist's video
     */
    public String getPlaylistVideoURL() {
        return mPlaylistVideoURL;
    }

    /**
     * Get the playlist video image resource ID
     */
    public int getPlaylistVideoImage() {
        return mPlaylistVideoImage;
    }

    /**
     * Get the playlist author image resource ID
     */
    public int getPlaylistAuthorImage() {
        return mPlaylistAuthorImage;
    }

}