package com.collectionexample.layout;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.collectionexample.model.WH;


/**
 * Created by Kevin on 2015/10/15.
 */
public class SDCardLayout extends RelativeLayout {
    private RelativeLayout RL;
    public TextView Savetext, Readtext, SDCardtext;
    public EditText Edit;
    public Button Savebtn, Readbtn;
    protected WH WH;
    public SDCardLayout(Context context) {
        super(context);
        init();
    }

    public void init() {
        WH=new WH(getContext());
        setLayout();
        setTextView();
        setEditText();
        setButton();
    }


    private void setLayout() {
        RL = new RelativeLayout(getContext());
        RL.setId(getRandomId());
        RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        RL.setLayoutParams(Params);
        RL.setBackgroundColor(Color.BLACK);
        this.addView(RL);
    }

    private void setTextView() {
        {//Save Text
            Savetext = new TextView(getContext());
            Savetext.setId(getRandomId());
            RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            Params.setMargins(WH.getW(5), WH.getH(20), 0, 0);
            Savetext.setLayoutParams(Params);
            Savetext.setText("儲存文字");
            Savetext.setTextColor(Color.WHITE);
            Savetext.setTextSize( WH.getTextSize(30));
            RL.addView(Savetext);
        }
        {//Read Text
            Readtext = new TextView(getContext());
            Readtext.setId(getRandomId());
            RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            Params.setMargins(WH.getW(5), WH.getH(50), 0, 0);
            Readtext.setLayoutParams(Params);
            Readtext.setText("讀取文字");
            Readtext.setTextColor(Color.WHITE);
            Readtext.setTextSize(WH.getTextSize(30));
            RL.addView(Readtext);
        }
        {//SDCard Text
            SDCardtext = new TextView(getContext());
            SDCardtext.setId(getRandomId());
            RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            Params.addRule(BELOW, Readtext.getId());
            Params.setMargins(WH.getW(5), 0, 0, 0);
            SDCardtext.setLayoutParams(Params);
            SDCardtext.setText("");
            SDCardtext.setTextColor(Color.WHITE);
            SDCardtext.setTextSize( WH.getTextSize(30));
            RL.addView(SDCardtext);
        }
    }

    private void setEditText() {
        Edit = new EditText(getContext());
        Edit.setId(getRandomId());
        RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        Params.addRule(BELOW, Savetext.getId());
        Params.setMargins(WH.getW(10), 0, WH.getW(10), 0);
        Edit.setLayoutParams(Params);
        Edit.setTextSize(WH.getTextSize(25));
        Edit.setTextColor(Color.WHITE);
        RL.addView(Edit);
    }

    private void setButton() {
        {//Save Button
            Savebtn = new Button(getContext());
            Savebtn.setId(getRandomId());
            RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            Params.addRule(BELOW, Edit.getId());
            Params.setMargins(WH.getW(10), 0, WH.getW(10), 0);
            Savebtn.setLayoutParams(Params);
            Savebtn.setText("儲存文字到SD卡");
            Savebtn.setTextColor(Color.WHITE);
            Savebtn.setTextSize(WH.getTextSize(20));
            RL.addView(Savebtn);
        }
        {//Read Button
            Readbtn = new Button(getContext());
            Readbtn.setId(getRandomId());
            RelativeLayout.LayoutParams Params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            Params.addRule(BELOW, SDCardtext.getId());
            Params.setMargins(WH.getW(10), 0, WH.getW(10), 0);
            Readbtn.setLayoutParams(Params);
            Readbtn.setText("讀取SD卡的文字");
            Readbtn.setTextColor(Color.WHITE);
            Readbtn.setTextSize(WH.getTextSize(20));
            RL.addView(Readbtn);
        }
    }
    protected int getRandomId(){ return (int)(Math.random()*1000000);}

}
