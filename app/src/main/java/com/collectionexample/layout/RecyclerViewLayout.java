package com.collectionexample.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.collectionexample.model.WH;

/**
 * Created by Kevin on 2015/10/24.
 */
public class RecyclerViewLayout extends RelativeLayout {
    public RecyclerView recyclerView;
    public RelativeLayout layout;
    public NetworkImageView imageView;
    private WH WH;

    public RecyclerViewLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        WH = new WH(getContext());
        setRecyclerView();
    }

    //建立 RecyclerView 的畫面
    private void setRecyclerView() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);

        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutParams(params);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        this.addView(recyclerView);
    }

    //建立 ItemView 的畫面
    public RelativeLayout getItemView() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                WH.getW(50),
                WH.getH(22));

        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(
                WH.getW(45),
                WH.getH(22));
        imageParams.addRule(CENTER_IN_PARENT);

        imageView = new NetworkImageView(getContext());
        imageView.setLayoutParams(imageParams);

        layout = new RelativeLayout(getContext());
        layout.setLayoutParams(params);
        layout.addView(imageView);
        return layout;
    }

}
