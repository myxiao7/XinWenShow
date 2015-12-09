package com.sizhuo.xinwenshow.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * 项目名称: XinWenShow
 * 类描述: Volley图片缓存
 * Created by My灬xiao7
 * date: 2015/12/7
 *
 * @version 1.0
 */
public class MyBitmapCache implements ImageLoader.ImageCache {
    private LruCache<String, Bitmap> mLruCache;
    private int maxSize = 10 * 1024 * 1024;//分配10M缓存空间
    public MyBitmapCache() {
        if(mLruCache == null){
            mLruCache = new LruCache<String, Bitmap>(maxSize){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };
        }
    }

    @Override
    public Bitmap getBitmap(String s) {
        return mLruCache.get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        mLruCache.put(s, bitmap);
    }
}
