package com.collectionexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.collectionexample.layout.RecycleViewItem;
import com.collectionexample.layout.RecyclerViewLayout;
import com.collectionexample.model.BitmapCache;
import com.collectionexample.model.RecyclerViewImageList;
import com.collectionexample.model.SingleVolleyQueue;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerViewLayout layout;
    private RecycleViewItem item;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout = new RecyclerViewLayout(this));

        RequestQueue queue = SingleVolleyQueue.get(this);
        imageLoader = new ImageLoader(queue, new BitmapCache());

        //設定 RecyclerView 的 Adapter
        layout.recyclerView.setAdapter(adapter);

    }

    private RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
        //建立 RecycleViewItem 的畫面
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(item = new RecycleViewItem(RecycleViewActivity.this)) {
            };
        }

        //設定 RecycleViewItem 的畫面
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            item.imageView.setDefaultImageResId(R.drawable.loading);
            item.imageView.setErrorImageResId(R.drawable.loaderror);
            item.imageView.setImageUrl(RecyclerViewImageList.list[position], imageLoader);
        }

        //RecycleViewItem 的數量
        @Override
        public int getItemCount() {
            return RecyclerViewImageList.list.length;
        }
    };
}



