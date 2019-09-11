package com.mellakhi.foudhil.abc;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;


public class SelectedNum extends AppCompatActivity {

    RelativeLayout bgDraw;
    PaintView paintView;
    ImageView gomme, home, nextBtn, prevBtn;
    Button black, blue, green, orange, purple, red, sky, yellow;

    Bundle x;
    int currentInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_num);

        final Intent intent = NavUtils.getParentActivityIntent(this);
        final SelectedNum nav = this;
        ArrayList<Button> ColorBtns = new ArrayList<>();

        x = getIntent().getExtras();

        assert x != null;
        currentInt = x.getInt("selected");

        home = findViewById(R.id.numberBtn);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);

        bgDraw = findViewById(R.id.bgDrawImage);
        gomme = findViewById(R.id.gommeBtn);

        black = findViewById(R.id.blackBtn);
        ColorBtns.add(black);
        blue = findViewById(R.id.blueBtn);
        ColorBtns.add(blue);
        green = findViewById(R.id.greenBtn);
        ColorBtns.add(green);
        orange = findViewById(R.id.orangeBtn);
        ColorBtns.add(orange);
        purple = findViewById(R.id.purpleBtn);
        ColorBtns.add(purple);
        red = findViewById(R.id.redBtn);
        ColorBtns.add(red);
        sky = findViewById(R.id.skyBtn);
        ColorBtns.add(sky);
        yellow = findViewById(R.id.yellowBtn);
        ColorBtns.add(yellow);

        paintView = findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        for (int i = 0; i <= 9; i++) {
            int resID = getResources().getIdentifier("wnum" + i, "drawable", getPackageName());
            if (currentInt == i) {
                bgDraw.setBackground(getDrawable(resID));
                break;
            }
        }

        Selected.setHome(nav, intent, home);

        checkCurrnetChar();
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setView("next");
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setView("prev");

            }
        });

        Selected.setColor(ColorBtns,paintView);

        //!!! under ctor
        gomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.trans();
            }
        });
    }

    void checkCurrnetChar() {
        if (currentInt == 0)
            prevBtn.setVisibility(View.INVISIBLE);
        else if (currentInt == 9)
            nextBtn.setVisibility(View.INVISIBLE);
        else {
            prevBtn.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.VISIBLE);
        }
    }

    void setView(String direction) {

        for (int i = 0; i <= 9; i++) {
            int resID = 0;

            if (direction.equals("next"))
                resID = getResources().getIdentifier("wnum" + (i + 1), "drawable", getPackageName());
            else if (direction.equals("prev"))
                resID = getResources().getIdentifier("wnum" + (i - 1), "drawable", getPackageName());

            if (currentInt == (char) i) {
                bgDraw.setBackground(getDrawable(resID));

                if (direction.equals("next"))
                    currentInt++;
                else if (direction.equals("prev"))
                    currentInt--;

                checkCurrnetChar();
                paintView.clear();
                break;
            }
        }

    }
}
