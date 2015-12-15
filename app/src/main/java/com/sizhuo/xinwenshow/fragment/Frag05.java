package com.sizhuo.xinwenshow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.MapView;
import com.sizhuo.xinwenshow.R;

/**
 * 项目名称: XinWenShow
 * 类描述:地图
 * Created by My灬xiao7
 * date: 2015/12/11
 *
 * @version 1.0
 */
public class Frag05 extends Fragment{
    private View mView;
    MapView mMapView = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
           mView = inflater.inflate(R.layout.frag05,container,false);
//            mMapView = (MapView) mView.findViewById(R.id.frag05_map);
        }
        return mView;
    }


}
