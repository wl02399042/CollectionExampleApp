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
import com.collectionexample.model.GenerateViewId;
import com.collectionexample.model.WH;

/**
 * Created by Kevin on 2015/10/24.
 */
public class RecyclerViewLayout extends RelativeLayout {
    public RecyclerView recyclerView;
    public RelativeLayout layout;

    public RecyclerViewLayout(Context context) {
        super(context);

        recyclerView = recyclerView();
        addView(recyclerView);
    }

    //建立 RecyclerView 的畫面
    private RecyclerView recyclerView() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        DefaultItemAnimator itemAnimator = new DefaultItemAnimator();

        RecyclerView v = new RecyclerView(getContext());

        v.setId(GenerateViewId.get());
        v.setLayoutParams(params);
        v.setLayoutManager(layoutManager);
        v.setItemAnimator(itemAnimator);
        return v;
    }

}
