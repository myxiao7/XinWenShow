package com.sizhuo.xinwenshow;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Queue;

/**
 * 项目名称: XinWenShow
 * 类描述 初始化Volley
 * Created by My灬xiao7
 * date: 2015/12/7
 *
 * @version 1.0
 */
public class MyApplication extends Application {
    public RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration imageLoaderConfiguration = ImageLoaderConfiguration.createDefault(this);
        //Initialize ImageLoader with configuration.
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(imageLoaderConfiguration);
    }

    public RequestQueue getHttpQueue(){
        return  queue;
    }
}
