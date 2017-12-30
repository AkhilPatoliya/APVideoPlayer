package com.akhilpatoliya.videoplayerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.akhilpatoliya.androidvideoplayer.AbstractYouTubeListener;
import com.akhilpatoliya.androidvideoplayer.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    YouTubePlayerView videoplayer;
    private FullScreenManager fullScreenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoplayer=(YouTubePlayerView)findViewById(R.id.youtube_player_view);
        PlayVideo();
    }

    public void PlayVideo() {
        videoplayer.initialize(new AbstractYouTubeListener() {

            @Override
            public void onReady() {
//                videoplayer.loadVideo("vimeo.com/210059723", 0);
                videoplayer.loadVideo("6JYIGclVQdw",0);
            }

        }, true);

    }
}
