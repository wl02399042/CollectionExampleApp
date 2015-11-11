package com.collectionexample.layout;

import android.content.Context;
import android.widget.RelativeLayout;

import com.android.volley.toolbox.NetworkImageView;
import com.collectionexample.model.GenerateViewId;
import com.collectionexample.model.WH;

/**
 * Created by Kevin on 2015/11/11.
 */
public class RecycleViewItem extends RelativeLayout {
    private WH ruler;
    public NetworkImageView imageView;

    public RecycleViewItem(Context context) {
        super(context);
        ruler = new WH(getContext());

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ruler.getW(50),
                ruler.getH(22));

        setId(GenerateViewId.get());
        setLayoutParams(params);
        // 元件初始化
        imageView = imageView();
        // 加入元件
        addView(imageView);
    }

    private NetworkImageView imageView() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ruler.getW(45),
                ruler.getH(22));

        NetworkImageView v = new NetworkImageView(getContext());
        v.setId(GenerateViewId.get());
        v.setLayoutParams(params);

        return v;
    }
}
