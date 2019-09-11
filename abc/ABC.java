package com.mellakhi.foudhil.abc;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class ABC extends AppCompatActivity implements View.OnClickListener {
    ImageView[] imageView = new ImageView[9];
    ImageView prev, next;

    Intent i;
    int page;
    Bundle b = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);

        page = 1;
        i = new Intent(getApplicationContext(), SelectedAlpha.class);

        for (int i = 1; i <= 9; i++) {
            String imageID = "p" + i;
            int resID = getResources().getIdentifier(imageID, "id", getPackageName());
            imageView[i - 1] = findViewById(resID);
            imageView[i - 1].setOnClickListener(this);
        }

        final Intent intent = NavUtils.getParentActivityIntent(this);
        final ABC nav = this;

        ImageView home = findViewById(R.id.homeTest);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(nav, intent);
            }
        });

        prev = findViewById(R.id.Prev);
        prev.setVisibility(View.INVISIBLE);

        next = findViewById(R.id.Next);
    }

    void ArrowDisplayer() {
        if (page == 1) {
            prev.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        } else if (page == 2) {
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
        } else{
            prev.setVisibility(View.VISIBLE);
            next.setVisibility(View.INVISIBLE);
        }
    }

    void ImagesDisplayer() {
        if (page == 1) {
            imageView[0].setImageResource(R.drawable.a);
            imageView[1].setImageResource(R.drawable.b);
            imageView[2].setImageResource(R.drawable.c);
            imageView[3].setImageResource(R.drawable.d);
            imageView[4].setImageResource(R.drawable.e);
            imageView[5].setImageResource(R.drawable.f);
            imageView[6].setImageResource(R.drawable.g);
            imageView[7].setImageResource(R.drawable.h);
            imageView[8].setImageResource(R.drawable.i);
        } else if (page == 2) {
            imageView[0].setImageResource(R.drawable.j);
            imageView[1].setImageResource(R.drawable.k);
            imageView[2].setImageResource(R.drawable.l);
            imageView[3].setImageResource(R.drawable.m);
            imageView[4].setImageResource(R.drawable.n);
            imageView[5].setImageResource(R.drawable.o);
            imageView[6].setImageResource(R.drawable.p);
            imageView[7].setImageResource(R.drawable.q);
            imageView[8].setImageResource(R.drawable.r);
            imageView[8].setVisibility(View.VISIBLE);
        } else{
            imageView[0].setImageResource(R.drawable.s);
            imageView[1].setImageResource(R.drawable.t);
            imageView[2].setImageResource(R.drawable.u);
            imageView[3].setImageResource(R.drawable.v);
            imageView[4].setImageResource(R.drawable.w);
            imageView[5].setImageResource(R.drawable.x);
            imageView[6].setImageResource(R.drawable.y);
            imageView[7].setImageResource(R.drawable.z);
            imageView[8].setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page--;
                ArrowDisplayer();
                ImagesDisplayer();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page++;
                ArrowDisplayer();
                ImagesDisplayer();
            }
        });
    }

    @Override
    public void onClick(View view) {
        String id = view.getResources().getResourceName(view.getId());
        id = id.substring(id.length() - 2);

        int j = 1;
        if (page == 1)
            for (int i = 'a'; i <= 'i'; i++) {
                if (id.equals("p" + j++)) {
                    b.putChar("selected", (char) i);
                    break;
                }
            }
        else if (page == 2)
            for (int i = 'j'; i <= 'r'; i++) {
                if (id.equals("p" + j++)) {
                    b.putChar("selected", (char) i);
                    break;
                }
            }
        else if (page == 3)
            for (int i = 's'; i <= 'z'; i++) {
                if (id.equals("p" + j++)) {
                    b.putChar("selected", (char) i);
                    break;
                }
            }

        i.putExtras(b);
        startActivity(i);
    }
}
