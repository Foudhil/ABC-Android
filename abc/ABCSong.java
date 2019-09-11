package com.mellakhi.foudhil.abc;


import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class ABCSong extends AppCompatActivity {

    ImageView upper, lower;
    Intent i;
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abcsong);

        i = new Intent(this,VideoPlayer.class);

        lower=findViewById(R.id.videoLower);
        upper=findViewById(R.id.videoUpper);

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("video","lower");
                i.putExtras(b);
                startActivity(i);
            }
        });
        upper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.putString("video","upper");
                i.putExtras(b);
                startActivity(i);
            }
        });

        final Intent intent = NavUtils.getParentActivityIntent(this);
        final ABCSong nav = this;

        ImageView home = findViewById(R.id.homeVideo);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(nav, intent);
            }
        });
    }
}
