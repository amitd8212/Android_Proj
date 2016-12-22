package com.android.videodemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView) findViewById(R.layout.id.videoView);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.layout.raw.SampleVideo_1280x720_1mb);

        videoView.start();

    }
}
