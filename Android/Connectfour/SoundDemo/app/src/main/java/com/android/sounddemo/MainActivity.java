package com.android.sounddemo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;

    AudioManager audioManager;





    public void startClick(View view){

        mPlayer.start();

    }

    public void pauseClick (View view){

        if(mPlayer.isPlaying()) {
            mPlayer.pause();
        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayer = MediaPlayer.create(this, R.raw.jack);

        int trackLength = mPlayer.getDuration();

        SeekBar trackControl = (SeekBar) findViewById(R.id.trackSeek);



        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeBar);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {



                Log.i("Seekbar value ", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }


}
