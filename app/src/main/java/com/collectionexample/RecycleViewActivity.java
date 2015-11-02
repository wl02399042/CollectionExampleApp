package com.collectionexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.collectionexample.layout.RecyclerViewLayout;
import com.collectionexample.model.BitmapCache;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerViewLayout RVL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(RVL = new RecyclerViewLayout(this));

        //設定圖片的URL
        final String[] imageURL = {
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a01.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a02.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a03.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a04.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a05.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a06.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a07.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a08.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a09.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a10.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a11.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a12.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a13.jpg",
                "http://o.arcww.com.tw/www.mcdonalds.com.tw/coupon20150916/images/a14.jpg"
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        final ImageLoader imageLoader = new ImageLoader(queue, new BitmapCache());

        //設定 RecyclerView 的 Adapter
        RVL.recyclerView.setAdapter(new RecyclerView.Adapter() {

            //放入 ItemView 的畫面
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerView.ViewHolder(RVL.getItemView()) {
                };
            }

            //設定 ItemView 的內容
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                RVL.imageView.setDefaultImageResId(R.drawable.loading);
                RVL.imageView.setErrorImageResId(R.drawable.loaderror);
                RVL.imageView.setImageUrl(imageURL[position], imageLoader);
            }

            //設定 ItemView 的數量
            @Override
            public int getItemCount() {
                return imageURL.length;
            }
        });
    }

}

