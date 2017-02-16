package com.example.amit.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFriends = (ListView) findViewById(R.id.friendlist);

        String[] friends = new String[]{"Bob", "Joe", "Doug", "Peter"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                                                                android.R.id.text1, friends);

        myFriends.setAdapter(adapter);

        myFriends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String friendName = (String) myFriends.getItemAtPosition(position);


                Toast.makeText(getApplicationContext(),"Hi: "+friendName, Toast.LENGTH_LONG).show();

            }
        });

    }







}
