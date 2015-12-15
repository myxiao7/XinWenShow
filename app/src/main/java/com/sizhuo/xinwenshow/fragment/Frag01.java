package com.sizhuo.xinwenshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jorge.circlelibrary.ImageCycleView;
import com.sizhuo.xinwenshow.R;
import com.sizhuo.xinwenshow.bean.NewsBean;
import com.sizhuo.xinwenshow.dao.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称: XinWenShow
 * 类描述: 热点
 * Created by My灬xiao7
 * date: 2015/12/9
 * @version 1.0
 */
public class Frag01 extends Fragment{


    private View mView;
    private ImageCycleView imageCycleView;//轮播
    private RequestQueue queue;
    private Context context;

    private static final String URL = Const.URL_LUNBO;//轮播URL
    private static final String APPIKEY = Const.APIKEY_LUNBO;//轮播APIKEY

    private List<NewsBean> lbDatas = new ArrayList<NewsBean>();//轮播数据
    private ArrayList<String> lbTitles = new ArrayList<String>();//轮播标题
    private ArrayList<String> lbImgs = new ArrayList<String>();//轮播图片URL
    private JsonObjectRequest jsonObjectRequest;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
       if(mView == null){
           initViews(inflater, container);
       }
        context = container.getContext();
        queue = Volley.newRequestQueue(getContext());
        //获取数据
        jsonObjectRequest = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    Log.d("xinwen",jsonObject.toString());
                    //获取返回信息（success表示成功）
                    String errMsg = jsonObject.getString("errMsg").toString();
                    //新闻列表
                    String info =  jsonObject.getString("retData").toString();
                    Log.d("xinwen",errMsg);
                    Log.d("xinwen",info);

                    //解析数据
                    lbDatas = new Gson().fromJson(info, new TypeToken<List<NewsBean>>(){}.getType());
                    Log.d("xinwen","--------------------"+lbDatas.size());
                    for (int i = 0; i < lbDatas.size(); i++) {
                        lbTitles.add(lbDatas.get(i).getTitle());
                        lbImgs.add(lbDatas.get(i).getImage_url());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("xinwen", volleyError.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> header = new HashMap<String,String>();
                header.put("apikey",APPIKEY);
                return header;
            }
        };
        queue.add(jsonObjectRequest);
        return mView;
    }

    private void initViews(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.frag01, container, false);
    }


}
