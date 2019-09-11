package com.mellakhi.foudhil.abc;


import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NUM extends AppCompatActivity implements View.OnClickListener {

    ImageView[] imageView = new ImageView[10];
    Intent i;
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);

        i = new Intent(getApplicationContext(), SelectedNum.class);

        for (int i = 0; i <= 9; i++) {
            String buttonID = "n" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            imageView[i] = findViewById(resID);
            imageView[i].setOnClickListener(this);
        }

        final Intent intent = NavUtils.getParentActivityIntent(this);
        final NUM nav = this;

        ImageView home = findViewById(R.id.homeTest);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(nav, intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

        String id = view.getResources().getResourceName(view.getId());
        id = id.substring(id.length() - 2);

        for (int i = 0; i <= 9; i++)
            if (id.equals("n" + i)) {
                b.putInt("selected", i);
                break;
            }

        i.putExtras(b);
        startActivity(i);
    }
}
