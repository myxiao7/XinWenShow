package com.sizhuo.xinwenshow;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.sizhuo.xinwenshow.util.StatusBar;
import com.sizhuo.xinwenshow.util.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;//标题栏
    private TabLayout tabLayout;//导航栏
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        new StatusBar(this).initStatusBar();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新闻");
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        tabLayout.addTab(tabLayout.newTab().setText("热点"));
        tabLayout.addTab(tabLayout.newTab().setText("体育"));
        tabLayout.addTab(tabLayout.newTab().setText("烟台"));
        tabLayout.addTab(tabLayout.newTab().setText("财经"));
        tabLayout.addTab(tabLayout.newTab().setText("视频"));
        tabLayout.addTab(tabLayout.newTab().setText("其他"));

    }


}
