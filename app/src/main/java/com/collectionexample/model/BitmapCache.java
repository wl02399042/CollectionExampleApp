package com.collectionexample.model;

import android.graphics.Bitmap;
import android.util.LruCache;

import static com.android.volley.toolbox.ImageLoader.ImageCache;

//使用 LruCache 實現圖片緩存
public class BitmapCache implements ImageCache {
    private LruCache<String, Bitmap> bitmapCache;

    public BitmapCache() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        bitmapCache = new LruCache<String, Bitmap>(cacheSize) {
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return bitmapCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        synchronized (bitmapCache) {
            if (bitmapCache.get(url) == null) {
                bitmapCache.put(url, bitmap);
            }
        }
    }
}
