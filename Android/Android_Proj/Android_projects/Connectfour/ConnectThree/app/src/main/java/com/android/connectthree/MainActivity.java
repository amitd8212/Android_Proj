package com.android.connectthree;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    // 0 = Orange, 1 = Red, 2 = unplayed

    int activePlayer = 0;

    boolean gameIsActive = true;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11},{12,13,14,15},
            {0,4,8,12}, {1,5,9,13}, {2,6,10,14}, {3,7,11,15}, {3,6,9,12}, {0,5,10,15}};

    public void dropin(View view) {

        ImageView counter = (ImageView) view;

        counter.getTag().toString();

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.orange);
                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }


            counter.animate().translationYBy(1000f).setDuration(300);

            for (int[] winningPosition : winningPositions){

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[2]] == gameState[winningPosition[3]] &&
                        gameState[winningPosition[0]] != 2){

                    gameIsActive = false;

                    String winner = "Red";

                    if (gameState[winningPosition[0]] == 0){

                        winner = "Orange";

                    }

                    //Someone Has won!

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerText);

                    winnerMessage.setText(winner + " has won!");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                } else {

                    boolean gameIsOver = true;

                    for (int counterState : gameState){

                        if (counterState == 2) gameIsOver = false;


                        }

                    if (gameIsOver){

                        TextView winnerMessage = (TextView) findViewById(R.id.winnerText);

                        winnerMessage.setText("Tie Game");

                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                        layout.setVisibility(View.VISIBLE);

                    }
                }
            }

        }
    }

    public void playAgain(View view){

        gameIsActive = true;

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for (int i = 0; i < gameState.length; i++){

            gameState[i] = 2;

        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (int i = 0; i<gridLayout.getChildCount(); i++ ){

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }

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
