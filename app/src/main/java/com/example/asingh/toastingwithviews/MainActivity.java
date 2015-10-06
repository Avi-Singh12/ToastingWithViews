package com.example.asingh.toastingwithviews;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SharedPreferences clickSP = getApplicationContext().getSharedPreferences("ClickCounts", 0);
        final SharedPreferences.Editor editor = clickSP.edit();
        final Integer[] clicks = {clickSP.getInt("blueClicks",0),clickSP.getInt("redClicks",0),clickSP.getInt("yellowClicks",0),clickSP.getInt("aquaClicks",0)};

        View blueView = (View) findViewById(R.id.topLeft);
        blueView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks[0]++;
                Toast.makeText(MainActivity.this, "blueView Presses: " + clicks[0], Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "blueView has been pressed " + clicks[0] + " times.");
                editor.putInt("blueClicks", clicks[0]);
                editor.commit();
            }
        });

        View redView = (View) findViewById(R.id.topRight);
        redView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks[1]++;
                Toast.makeText(MainActivity.this, "redView Presses: " + clicks[1], Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "redView has been pressed " + clicks[1] + " times.");
                editor.putInt("redClicks", clicks[1]);
                editor.commit();
            }
        });

        View yellowView = (View) findViewById(R.id.bottomRight);
        yellowView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks[2]++;
                Toast.makeText(MainActivity.this, "yellowView Presses: " + clicks[2], Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "yellowView has been pressed " + clicks[2] + " times.");
                editor.putInt("yellowClicks", clicks[2]);
                editor.commit();
            }
        });

        View aquaView = (View) findViewById(R.id.bottomLeft);
        aquaView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks[3]++;
                Toast.makeText(MainActivity.this, "aquaView Presses: " + clicks[3], Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "aquaView has been pressed " + clicks[3] + " times.");
                editor.putInt("aquaClicks", clicks[3]);
                editor.commit();
            }
        });

        Button resetButton = (Button) findViewById(R.id.center);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks[0] = 0;
                clicks[1] = 0;
                clicks[2] = 0;
                clicks[3] = 0;
                editor.putInt("blueClicks", clicks[0]);
                editor.putInt("redClicks", clicks[1]);
                editor.putInt("yellowClicks", clicks[2]);
                editor.putInt("aquaClicks", clicks[3]);
                editor.commit();

                Toast.makeText(MainActivity.this, "All Counts Reset", Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "All Counts Reset");
            }
        });

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
