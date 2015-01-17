package com.example.tylerreardon.cointoss;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    //seeds the random number
    Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    /**
     * Flips coin and changes the text on a label
     * @param v
     */
    public void flipCoin(View v){
        TextView view = (TextView) findViewById(R.id.tossOutcome); //finds the label
        ImageView image = (ImageView) findViewById(R.id.coinImage); //finds the ImageView


        //initializes the toss value with a number between 1 and 2
        int toss = rand.nextInt()%2+1;

        //if the value is 1, then it's heads otherwise it's tails
        if (toss == 1){
          image.setImageResource(R.drawable.heads); //sets the image to heads
          view.setText("Heads!");
        }else{
          image.setImageResource(R.drawable.tails); //sets the image to tails
          view.setText("Tails!");
        }



    }
}
