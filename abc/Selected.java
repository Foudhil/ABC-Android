package com.mellakhi.foudhil.abc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public abstract class Selected {
    static void setHome(final Activity nav, final Intent intent, ImageView home) {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(nav, intent);
            }
        });
    }
    static void setColor(ArrayList<Button> btn, final PaintView paintView) {
        btn.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(0, 0, 0));
            }
        });
        btn.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(1, 9, 182));
            }
        });
        btn.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(15, 162, 19));
            }
        });
        btn.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(251, 140, 0));
            }
        });
        btn.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(151, 26, 143));
            }
        });
        btn.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(244, 0, 2));
            }
        });
        btn.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(2, 254, 255));
            }
        });
        btn.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paintView.setColor(Color.rgb(254, 255, 5));
            }
        });
    }
}
