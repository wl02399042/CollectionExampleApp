package com.collectionexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sdcardSample = getButton("Sdcard存取範例");
        Button mediaPlayerSample = getButton("Media Player播放範例");
        Button recycleView = getButton("RecycleView使用範例");
        Button volleyRequest = getButton("volley網路存取範例");

        sdcardSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SdcardActivity.class);
                startActivity(intent);
            }
        });
        mediaPlayerSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MediaPlayerActivity.class);
                startActivity(intent);
            }
        });

        recycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                startActivity(intent);
            }
        });
        volleyRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VolleyActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        container.setOrientation(LinearLayout.VERTICAL);
        container.addView(sdcardSample);
        container.addView(mediaPlayerSample);
        container.addView(recycleView);
        container.addView(volleyRequest);
        NumberPicker picker = new NumberPicker(new ContextThemeWrapper(this, android.R.style.Theme_Holo_Light));
        picker.setMaxValue(10);
        container.addView(picker);

        setContentView(container);
    }

    private Button getButton(String text) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        Button v = new Button(this);
        v.setLayoutParams(params);
        v.setText(text);

        return v;
    }
}
