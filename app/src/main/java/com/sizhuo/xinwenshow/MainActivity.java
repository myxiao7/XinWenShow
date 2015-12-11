package com.sizhuo.xinwenshow;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.sizhuo.xinwenshow.adapter.MyFragPageAdapter;
import com.sizhuo.xinwenshow.fragment.Frag01;
import com.sizhuo.xinwenshow.fragment.tab01;
import com.sizhuo.xinwenshow.util.StatusBar;
import com.sizhuo.xinwenshow.util.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;//标题栏
    private TabLayout tabLayout;//导航栏
    private ViewPager viewPager;
    private String[] titles = {"热点","体育","烟台","视频","其他"};
    private List<Fragment> fragments = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        for (int i = 0; i < 5; i++) {
            Fragment frag01 = new Frag01();
            fragments.add(frag01);
        }
        Log.d("xinwen",fragments.size()+"----------");
        MyFragPageAdapter myFragPageAdapter = new MyFragPageAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myFragPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(myFragPageAdapter);
    }

    private void initViews() {
        new StatusBar(this).initStatusBar();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新闻");
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        /*tabLayout.addTab(tabLayout.newTab().setText("热点"));
        tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("烟台"));
        tabLayout.addTab(tabLayout.newTab().setText("财经"));
        tabLayout.addTab(tabLayout.newTab().setText("视频"));
        tabLayout.addTab(tabLayout.newTab().setText("其他"));*/

    }


}
