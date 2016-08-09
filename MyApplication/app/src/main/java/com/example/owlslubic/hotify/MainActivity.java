package com.example.owlslubic.hotify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.owlslubic.hotify.services.MusicService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =  "MainActivity";
    Button mPlay,mPause,mStop;
    public static final String PLAYBACK_KEY = "playback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPause = (Button) findViewById(R.id.button_pause);
        mPlay = (Button) findViewById(R.id.button_play);
        mStop = (Button) findViewById(R.id.button_stop);





        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playbackIntent = new Intent(MainActivity.this, MusicService.class);
                startService(playbackIntent);
                Log.i(TAG, "onClick: start service worked");

                Toast.makeText(MainActivity.this, "playing!", Toast.LENGTH_SHORT).show();

            }
        });
        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicService.pauseSong();

                Toast.makeText(MainActivity.this, "paused!", Toast.LENGTH_SHORT).show();

            }
        });
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicService.stopSong();

                Toast.makeText(MainActivity.this, "stopped!", Toast.LENGTH_SHORT).show();

            }
        });




    }






}
