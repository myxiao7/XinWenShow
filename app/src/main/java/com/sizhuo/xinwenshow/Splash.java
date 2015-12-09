package com.sizhuo.xinwenshow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sizhuo.xinwenshow.bean.SplashBean;
import com.sizhuo.xinwenshow.dao.Const;
import com.sizhuo.xinwenshow.util.ImageLoaderHelper;
import com.sizhuo.xinwenshow.util.MyBitmapCache;
import com.sizhuo.xinwenshow.util.NetworkCheck;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;

import static com.sizhuo.xinwenshow.R.id.splash_ship_btn;

/**
 * 项目名称: XinWenShow
 * 类描述: 主程序闪屏
 * Created by My灬xiao7
 * date: 2015/12/7
 * @version 1.0
 *
 */
public class Splash extends Activity {
    private ImageView img;//动态新闻
    private Button btn;//标题
    private RequestQueue queue;
    private JsonObjectRequest jsonObjectRequest;
    private final String URL = Const.URL_SPlash;
    private SplashBean splashBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //初始化控件和配置
        init();

        //获取splash信息
        jsonObjectRequest = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                //获取数据，转化为实体
                splashBean = new Gson().fromJson(jsonObject.toString(), SplashBean.class);
                Log.d("xinwen",jsonObject.toString());
                setBitmap(splashBean);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(queue.getCache().get(URL)!=null){
                    //缓存的数据
                    splashBean = new Gson().fromJson(new String(queue.getCache().get(URL).data), SplashBean.class);
                    setBitmap(splashBean);
                }
            }
        });
        queue.add(jsonObjectRequest);
        jsonObjectRequest.setTag("jsonObjectRequest");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(intent);
                Splash.this.finish();
            }
        });
    }

    /**
     * 加载图片和配置按钮
     * @param splashBean
     */
    private void setBitmap(SplashBean splashBean) {
        //是否需要跳过
        if (splashBean.getSkip().equals("true")) {
            btn.setVisibility(View.VISIBLE);
            Log.d("xinwen", splashBean.getSkip());
        }
      /*  DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        //使用UIL加载图片
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(splashBean.getUrl(), img, options, new SimpleImageLoadingListener(), new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String s, View view, int i, int i1) {
            }
        });*/
        ImageLoaderHelper.getInstance().loadImage(splashBean.getUrl(),img);

    }

    private void init() {
        //网络检查
        NetworkCheck networkCheck = new NetworkCheck(this);
        img = (ImageView) findViewById(R.id.splash_img);
        btn = (Button) findViewById(R.id.splash_ship_btn);
        queue = Volley.newRequestQueue(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        queue.cancelAll("jsonObjectRequest");
    }
}
