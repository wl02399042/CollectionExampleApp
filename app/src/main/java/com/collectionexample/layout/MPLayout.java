package com.collectionexample.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.collectionexample.model.WH;


/**
 * Created by Story on 2015/10/21.
 */
public class MPLayout extends RelativeLayout {
    public RelativeLayout RL;
    public Button startBtn, pasueBtn, restartBtn,stopBtn,Btn;
    public SurfaceView surfaceView;
    public SeekBar seekBar;
    protected com.collectionexample.model.WH WH;

    public MPLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        WH=new WH(getContext());
        setlayout();
        setButton();
        setSefaceview();
        setSeekbar();
    }

    public void setlayout() {
        RL = new RelativeLayout(getContext());
        RL.setId(getRandomId());
        LayoutParams Params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        RL.setLayoutParams(Params);
        RL.setBackgroundColor(Color.BLACK);
        this.addView(RL);
    }

    public void setSefaceview() {
        surfaceView = new SurfaceView(getContext());
        surfaceView.setId(getId());
        LayoutParams Params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                WH.getH(70));
        surfaceView.setLayoutParams(Params);
        this.addView(surfaceView);
    }

    public void setButton() {
        {
            pasueBtn = new Button(getContext());
            pasueBtn.setId(getRandomId());
            LayoutParams Params = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            Params.addRule(CENTER_HORIZONTAL);
            Params.setMargins(0, WH.getH(80), 0, 0);
            pasueBtn.setLayoutParams(Params);
            pasueBtn.setText("暫停");
            pasueBtn.setTextColor(Color.WHITE);
            pasueBtn.setTextSize( WH.getTextSize(20));
            RL.addView(pasueBtn);
        }
        {
            startBtn = new Button(getContext());
            startBtn.setId(getRandomId());
            LayoutParams Params = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            Params.addRule(LEFT_OF, pasueBtn.getId());
            Params.addRule(ALIGN_TOP, pasueBtn.getId());
            startBtn.setLayoutParams(Params);
            startBtn.setText("開始");
            startBtn.setTextColor(Color.WHITE);
            startBtn.setTextSize(WH.getTextSize(20));
            RL.addView(startBtn);
        }
        {
            restartBtn = new Button(getContext());
            restartBtn.setId(getRandomId());
            LayoutParams Params = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            Params.addRule(RIGHT_OF, pasueBtn.getId());
            Params.addRule(ALIGN_TOP, pasueBtn.getId());
            restartBtn.setLayoutParams(Params);
            restartBtn.setText("重新");
            restartBtn.setTextColor(Color.WHITE);
            restartBtn.setTextSize(WH.getTextSize(20));
            RL.addView(restartBtn);
        }

    }
    public void setSeekbar(){
        {
            seekBar = new SeekBar(getContext());
            seekBar.setId(getRandomId());
            LayoutParams Params = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT);
            Params.addRule(ABOVE,pasueBtn.getId());
            Params.setMargins(0, WH.getH(5), 0, 0);
            seekBar.setLayoutParams(Params);
            RL.addView(seekBar);
        }
    }
    protected int getRandomId(){return (int)(Math.random()*1000000);}
}
