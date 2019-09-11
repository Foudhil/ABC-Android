package com.mellakhi.foudhil.abc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView abc, num, num1, abcSong, test;
    MediaPlayer mysong;
    Button song;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mysong = MediaPlayer.create(MainActivity.this, R.raw.welcomesong);
        mysong.start();

        abc = findViewById(R.id.abcBtn);

        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = new Intent(getApplicationContext(), ABC.class);
                startActivity(t);
            }
        });

        num = findViewById(R.id.nmBtn);

        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = new Intent(getApplicationContext(), NUM.class);
                startActivity(t);
            }
        });
        num1 = findViewById(R.id.nm1Btn);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = new Intent(getApplicationContext(), NUM.class);
                startActivity(t);
            }
        });

        abcSong = findViewById(R.id.songBtn);

        abcSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = new Intent(getApplicationContext(), ABCSong.class);
                startActivity(t);
            }
        });

        test = findViewById(R.id.playNow);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t = new Intent(getApplicationContext(), TestLevel.class);
                startActivity(t);
            }
        });

        song = findViewById(R.id.sound);

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mysong.isPlaying()) {
                    mysong.pause();
                    song.setBackgroundResource(R.drawable.sound_off);
                } else {
                    mysong.start();
                    song.setBackgroundResource(R.drawable.sound_on);
                }
            }

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mysong.stop();
    }
}
