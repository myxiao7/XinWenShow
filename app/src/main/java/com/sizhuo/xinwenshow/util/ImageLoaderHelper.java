package com.sizhuo.xinwenshow.util;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * 项目名称: XinWenShow
 * 类描述:  网络图片加载（UIL）
 * Created by My灬xiao7
 * date: 2015/12/9
 *
 * @version 1.0
 */
public class ImageLoaderHelper {
    private static ImageLoaderHelper imageLoaderHelper;
    private DisplayImageOptions options;
    private ImageLoader imageLoader;

    public static ImageLoaderHelper getInstance(){
        if(imageLoaderHelper == null){
            imageLoaderHelper = new ImageLoaderHelper();
        }
        return imageLoaderHelper;
    }

    private ImageLoaderHelper() {
        init();
    }

    private void init() {
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
    }
    /**
     * 加载图片
     * @param url
     * @param imageView
     */
    public  void loadImage(String url,ImageView imageView){
        url=url.trim();
        ImageLoader.getInstance().displayImage(url, imageView, options, new SimpleImageLoadingListener(), new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String s, View view, int i, int i1) {
            }
        });
    }
}
