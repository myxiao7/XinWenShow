package com.sizhuo.xinwenshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 项目名称: XinWenShow
 * 类描述: Viewpager+Fragment Adapter
 * Created by My灬xiao7
 * date: 2015/12/9
 *
 * @version 1.0
 */
public class MyFragPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String []titles;
    public MyFragPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragPageAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
