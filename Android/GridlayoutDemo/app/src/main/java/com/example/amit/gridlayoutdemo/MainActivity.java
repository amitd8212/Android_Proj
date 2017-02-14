package com.example.amit.gridlayoutdemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;


public class MainActivity extends AppCompatActivity {


    public enum Phrase {
        PLEASE, WELCOME, MYNAMEIS, ILIVEIN, HOWAREYOU,
        HELLO, GOODEVENING, DOYOUSPEAKENGLISH
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClicked(View view) {

        int id = view.getId();
        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);

        int resourceId = getResources().getIdentifier(ourId, "raw", "com.example.amit.gridlayoutdemo");

        MediaPlayer mplayer = MediaPlayer.create(this, resourceId);
        mplayer.start();

    }
}
