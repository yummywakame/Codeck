package com.yummywakame.codeck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * {@link MainActivity} shows a list of playlists.
 * For each playlist, display the title, author, YouTube URL, video image and author image.
 */
public class MainActivity extends AppCompatActivity {

    // Create keys for playlist's GridView item data
    public static final String KEY_PLAYLIST_TITLE = "";
    public static final String KEY_PLAYLIST_AUTHOR = "";
    public static final String KEY_PLAYLIST_VIDEO_URL = "";
    public static final int KEY_PLAYLIST_VIDEO_IMAGE = 0;
    public static final int KEY_PLAYLIST_AUTHOR_IMAGE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Playlist objects
        ArrayList<Playlist> Playlists = new ArrayList<Playlist>();
        Playlists.add(new Playlist("Chill Study Beats Vol. 1 • Instrumental Hip Hop & Jazz Music [2016]",
                "Chillhop Music",
                "FlXDVH5dZsA", R.drawable.preview_chill_study_beats_1, R.drawable.author_chillhop_music));
        Playlists.add(new Playlist("Chill Study Beats 2 • Instrumental & Jazz Hip Hop Music [2016]",
                "Chillhop Music",
                "gwDoRPcPxtc", R.drawable.preview_chill_study_beats_2, R.drawable.author_chillhop_music));
        Playlists.add(new Playlist("Chill study beats 3 • A jazz & lofi hiphop Mix [2017]",
                "Chillhop Music",
                "6M78EWZlCvE", R.drawable.preview_chill_study_beats_3, R.drawable.author_chillhop_music));
        Playlists.add(new Playlist("Chill Study Beats 4 • jazz & lofi hiphop Mix [2017]",
                "Chillhop Music",
                "8iU8LPEa4o0", R.drawable.preview_chill_study_beats_4, R.drawable.author_chillhop_music));
        Playlists.add(new Playlist("Chill Study Beats 5 • jazz & lofi hiphop Mix [2018]",
                "Chillhop Music",
                "yUpl_HQrBnM", R.drawable.preview_chill_study_beats_5, R.drawable.author_chillhop_music));
        Playlists.add(new Playlist("Warm summer nights • instrumental hip hop - chillhop - lofi hip hop mix",
                "Chillhop Music",
                "98MQOJWdEME", R.drawable.preview_warm_summer_nights, R.drawable.author_chillhop_music));
        Playlists.add(new Playlist("Lofi hip hop mix - Beats to Relax/Study to [2018]",
                "ChilledCow",
                "-FlxM_0S2lA", R.drawable.preview_lofi_hip_hop_mix_2018, R.drawable.author_chilled_cow));
        Playlists.add(new Playlist("lonely day - lofi hiphop mix",
                "Cloudx Music",
                "eSjSozKL_EA", R.drawable.preview_lonely_day__lofi_hiphop_mix, R.drawable.author_cloudx));
        Playlists.add(new Playlist("Whispers Wonder ~ Japanese Trance & Progressive Mix (Harmonically Mixed)",
                "BeyondSkys09",
                "IVvpfQjR6jQ", R.drawable.preview_whispers_wonder, R.drawable.author_beyondskys09));
        Playlists.add(new Playlist("'READY PLAYER ONE' | Best of Synthwave and Cyberpunk Music Mix",
                "ThePrimeThanos",
                "bn42kmMuRkE", R.drawable.preview_ready_player_1, R.drawable.author_theprimethanos));
        Playlists.add(new Playlist("Night Prowl [Synthwave/Chillwave/Retrowave mix]",
                "moodwave",
                "J2H6kXJn6v4", R.drawable.preview_night_prowl, R.drawable.author_moodwave));
        Playlists.add(new Playlist("ＳＰＡＣＥ　ＴＲＩＰ [ Chillwave - Synthwave - Retrowave Mix ]",
                "Asthenic",
                "wOMwO5T3yT4", R.drawable.preview_space_trip, R.drawable.author_asthenic));
        Playlists.add(new Playlist("ＮＩＧＨＴＲＵＮ [ Synthwave - Retrowave - Chillwave Mix ]",
                "Asthenic",
                "arzw0tFK5O4", R.drawable.preview_nightrun, R.drawable.author_asthenic));
        Playlists.add(new Playlist("ＭＥＭＯＲＩＥＳ [ Synthwave - Dreamwave - Retrowave Mix ]",
                "Asthenic",
                "_AXIOfilxi0", R.drawable.preview_memories, R.drawable.author_asthenic));
        Playlists.add(new Playlist("Cybercity - A Synthwave Mix ⚡ (Synthwave, Futuresynth, Retro Electro)",
                "Gelbar",
                "ghvdhJRBMzE", R.drawable.preview_cybercity, R.drawable.author_gelbar));
        Playlists.add(new Playlist("Synth Runner 2049 - A Music Mix (Cyberpunk, Futuresynth, Darksynth)",
                "Gelbar",
                "OpYS5ATpI-U", R.drawable.preview_synth_runner_2049, R.drawable.author_gelbar));
        Playlists.add(new Playlist("SYNTHWAVE ► Dark Gaming Mix (80 minutes - 2016)",
                "Gelbar",
                "nomNAAMDReE", R.drawable.preview_synthwave_dark_gaming, R.drawable.author_gelbar));

        // Create an {@link PlaylistAdapter}, whose data source is a list of
        // {@link Playlist}s. The adapter knows how to create list item views for each item
        // in the list.
        final PlaylistAdapter playlistAdapter = new PlaylistAdapter(this, Playlists);

        // Get a reference to the GridView, and attach the adapter to the gridView.
        GridView gridView = findViewById(R.id.gridview_playlist);
        gridView.setAdapter(playlistAdapter);
    }
}
