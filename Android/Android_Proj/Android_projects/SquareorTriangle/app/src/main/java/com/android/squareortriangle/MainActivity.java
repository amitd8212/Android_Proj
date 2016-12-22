package com.android.squareortriangle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            }else{

                return false;
            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number){

                x++;

                triangularNumber = triangularNumber + x;

            }

            if (triangularNumber == number) {

                return true;
            }
            else {
                return false;
            }

        }
    }





    public void checkValue(View view) {

        EditText number = (EditText) findViewById(R.id.numberEntry);
        String message = "";

        if(number.getText().toString().isEmpty()){

            message = "Please Enter a Value";

        }else {

            String userValueString = number.getText().toString();
            int userValue = Integer.parseInt(userValueString);
            Number myNumber = new Number();
            myNumber.number = userValue;


            if (myNumber.isSquare()) {

                if (myNumber.isTriangular()) {

                    message = userValue + " is both triangular and square!";
                } else {

                    message = userValue + " is a square number but not triangular";
                }
            } else {

                if (myNumber.isTriangular()) {

                    message = userValue + " is triangular but not square";

                } else {

                    message = userValue + " is neither square nor triangular ";
                }
            }
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


