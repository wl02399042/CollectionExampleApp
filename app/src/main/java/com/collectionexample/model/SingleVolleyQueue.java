package com.collectionexample.model;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Kevin on 2015/11/11.
 */
// 使用 singleton pattern 避免產生多個 RequestQueue，最後導致 Out of Memory。
public final class SingleVolleyQueue {
    // volatile 避免操作重排序，static 設定全部方法只能存取到唯一實體
    private volatile static RequestQueue queue;

    // 私有建構式，避免透過匿名類別修改到唯一實體
    private SingleVolleyQueue() {
    }

    // 利用雙重鎖定和同步區塊，避免兩個執行緒因為細部操作差異，同時進入產生 RequestQueue 實體的程式區塊。
    public static RequestQueue get(Context context) {
        if (queue == null) {
            synchronized (SingleVolleyQueue.class) {
                if (queue == null)
                    queue = Volley.newRequestQueue(context);
            }
        }
        return queue;
    }

}
