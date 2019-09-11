package com.mellakhi.foudhil.abc;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Test1 extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout main;
    ImageView[] choices = new ImageView[4];
    String imageID;
    int resID;
    Intent intent;
    String current;
    MediaPlayer clapeffect,faileffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        intent = NavUtils.getParentActivityIntent(this);
        final Test1 nav = this;

        main = findViewById(R.id.mainImage);

        for (int i = 1; i <= 4; i++) {
            //set Image UI for choice
            imageID = "choice" + i;
            resID = getResources().getIdentifier(imageID, "id", getPackageName());

            choices[i - 1] = findViewById(resID);
            choices[i - 1].setOnClickListener(this);
        }

        current = "_a1";
        shuffle();

    }

    @Override
    public void onClick(View view) {

        if (view.getTag().equals("1")){
            clapeffect=MediaPlayer.create(Test1.this,R.raw.clap);
            clapeffect.start();
            pass();
            faileffect.release();
        }
        else {
            faileffect = MediaPlayer.create(Test1.this, R.raw.fail);
            faileffect.start();
            shuffle();
        }
    }

    void shuffle() {
        resetInit();
        resetTag();
        Collections.shuffle(Arrays.asList(choices));
        for (int i = 1; i <= 4; i++) {
            imageID = "btn" + i + current;
            resID = getResources().getIdentifier(imageID, "drawable", getPackageName());
            choices[i - 1].setImageResource(resID);
            choices[i - 1].setTag(String.valueOf(i));
        }

    }

    void pass() {
        char lastID = current.charAt(current.length() - 1);
        char lastChar = current.charAt(current.length() - 2);

        if (lastChar == 'z' && lastID == '3') {
            startActivity(intent);
            return;
        }

        if (lastID < '3') {
            lastID++;
        } else {
            lastChar++;
            lastID = '1';
        }

        current = "_" + lastChar + lastID;
        String imageID = lastChar + String.valueOf(lastID);
        int resID = getResources().getIdentifier(imageID, "drawable", getPackageName());
        main.setBackground(getDrawable(resID));

        shuffle();
    }

    void resetTag() {
        for (int i = 0; i < 4; i++) {
            choices[i].setTag(null);
        }
    }

    void resetInit() {
        for (int i = 1; i <= 4; i++) {
            imageID = "choice" + i;
            resID = getResources().getIdentifier(imageID, "id", getPackageName());
            choices[i - 1] = findViewById(resID);
        }
    }
}
