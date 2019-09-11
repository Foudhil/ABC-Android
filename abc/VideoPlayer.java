package com.mellakhi.foudhil.abc;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Objects;

public class VideoPlayer extends AppCompatActivity {

    VideoView videoview;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);

        Bundle b = getIntent().getExtras();

        videoview = findViewById(R.id.videoView);
        videoview = findViewById(R.id.videoView);

        if (Objects.equals(b.getString("video"), "upper")) {
            videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.uppercase));
            videoview.requestFocus();
            videoview.start();
        } else if (Objects.equals(b.getString("video"), "lower")) {
            videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lowercase));
            videoview.requestFocus();
            videoview.start();
        }
    }
}
