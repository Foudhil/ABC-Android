package com.mellakhi.foudhil.abc;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class TestLevel extends AppCompatActivity implements View.OnClickListener {

    ImageView[] imageView = new ImageView[6];
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        for (int j = 1; j <= 6; j++) {
            String ImageId = "test" + j;
            int resID = getResources().getIdentifier(ImageId, "id", getPackageName());
            imageView[j - 1] = findViewById(resID);
            imageView[j - 1].setOnClickListener(this);
        }


        final Intent intent = NavUtils.getParentActivityIntent(this);
        final TestLevel nav = this;

        ImageView home = findViewById(R.id.homeTest);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Sound Great :)");
                NavUtils.navigateUpTo(nav, intent);
            }
        });
    }

    void completPrev() {
        CompletePrev dialog = new CompletePrev();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onClick(View view) {
        String id = view.getResources().getResourceName(view.getId());
        id = id.substring(id.length() - 2);
        if (id.equals("t1"))
            i = new Intent(this, Test1.class);
        else {
            completPrev();
            return;
        }

        startActivity(i);
    }
}
