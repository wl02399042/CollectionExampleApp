package com.collectionexample.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by chriske on 2015/10/24.
 */
public class MainLayout extends LinearLayout {
    public Button sdcardSample;
    public Button mediaPlayerSample;
    public Button recycleView;
    public Button volleyRequest;

    public MainLayout(Context context) {
        super(context);

        setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        setOrientation(LinearLayout.VERTICAL);

        sdcardSample = getButton("Sdcard存取範例");
        mediaPlayerSample = getButton("Media Player播放範例");
        recycleView = getButton("RecycleView使用範例");
        volleyRequest = getButton("volley網路存取範例");

        addView(sdcardSample);
        addView(mediaPlayerSample);
        addView(recycleView);
        addView(volleyRequest);
    }

    private Button getButton(String text) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        Button v = new Button(getContext());
        v.setLayoutParams(params);
        v.setText(text);

        return v;
    }
}
