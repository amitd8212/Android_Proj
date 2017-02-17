package com.example.amit.hideandshowdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;


    public void showClick(View view) {
        if (myTextView.getVisibility() == myTextView.VISIBLE) {

            Log.i("Shown", "Text is Shown");

        } else {
            Log.i("Hidden", "Unhiding Text");
            myTextView.setVisibility(myTextView.VISIBLE);
        }
    }

    public void hideClick(View view) {
        if (myTextView.getVisibility() == myTextView.GONE) {

            Log.i("Hidden", "Text is Hidden");

        } else {
            Log.i("Shown", "Hiding Text");
            myTextView.setVisibility(myTextView.GONE);
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button hideButton = (Button) findViewById(R.id.hideButton);
//        Button showButton = (Button) findViewById(R.id.showButton);

        myTextView = (TextView) findViewById(R.id.myTextView);

        myTextView.setVisibility(myTextView.VISIBLE);
    }



}

