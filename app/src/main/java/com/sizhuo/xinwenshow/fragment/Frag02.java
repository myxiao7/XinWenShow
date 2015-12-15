package com.sizhuo.xinwenshow.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.map.MapView;
import com.sizhuo.xinwenshow.R;
import com.sizhuo.xinwenshow.adapter.MyFragPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: XinWenShow
 * 类描述:地图
 * Created by My灬xiao7
 * date: 2015/12/11
 *
 * @version 1.0
 */
public class Frag02 extends Fragment{
    private View mView;
    private TabLayout tabLayout;//tab切换
    private ViewPager viewPager;//viewpager
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private MyFragPageAdapter myFragPageAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            initViews(inflater, container);
        }
        for (int i = 0; i < 5; i++) {
            Fragment fragment = new Frag01();
            fragments.add(fragment);
        }
        myFragPageAdapter = new MyFragPageAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myFragPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(myFragPageAdapter);
        return mView;
    }

    private void initViews(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.frag02,container,false);
        tabLayout = (TabLayout) mView.findViewById(R.id.frag02_tablayout);
        viewPager = (ViewPager) mView.findViewById(R.id.frag02_viewpager);
    }


}
