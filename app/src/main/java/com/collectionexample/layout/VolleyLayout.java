package com.collectionexample.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.collectionexample.model.WH;

/**
 * Created by Lucas on 2015/10/24.
 */
public class VolleyLayout extends LinearLayout{
    private TextView StringText,JsonText;
    private WH WH;
    public ImageView Image;
    public VolleyLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        init();
    }
    private void init(){
        WH= new WH(getContext());
        {
            StringText = new TextView(getContext());
            StringText.setId(getRandomId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,WH.getH(25));
            StringText.setLayoutParams(layoutParams);
            StringText.setTextSize(WH.getTextSize(10));
            this.addView(StringText);
        }
        {
            Image = new ImageView(getContext());
            Image.setId(getRandomId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(WH.getW(20),WH.getH(20));
            Image.setLayoutParams(layoutParams);
            this.addView(Image);
        }
        {
            JsonText = new TextView(getContext());
            JsonText.setId(getRandomId());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,WH.getH(25));
            JsonText.setLayoutParams(layoutParams);
            JsonText.setTextSize(WH.getTextSize(10));
            this.addView(JsonText);
        }
    }
    public TextView getStringText(){
        return StringText;
    }
    public TextView getJsonText(){  return JsonText;}
    public ImageView getImage(){
        return Image;
    }
    protected int getRandomId() {
        return (int) (Math.random() * 1000000);
    }
}
