package com.collectionexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("RecycleView使用範例");
        Button btn = new Button(this);
        btn.setText("按鈕喔");
        setContentView(btn);
    }
}
