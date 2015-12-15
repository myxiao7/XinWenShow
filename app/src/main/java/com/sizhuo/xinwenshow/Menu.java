package com.sizhuo.xinwenshow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sizhuo.xinwenshow.fragment.Frag01;
import com.sizhuo.xinwenshow.fragment.Frag02;
import com.sizhuo.xinwenshow.fragment.Frag03;
import com.sizhuo.xinwenshow.fragment.Frag04;
import com.sizhuo.xinwenshow.fragment.Frag05;
import com.sizhuo.xinwenshow.util.StatusBar;

/**
 * 项目名称: XinWenShow
 * 类描述: 主菜单
 * Created by My灬xiao7
 * date: 2015/12/14
 *
 * @version 1.0
 */
public class Menu extends FragmentActivity implements View.OnClickListener {
    private Toolbar toolbar;//标题栏
    private FrameLayout frameLayout;
    private TextView tab01, tab02, tab03, tab04, tab05;//新闻，最新，视听，地图，我的
    private Fragment fragment01, fragment02, fragment03, fragment04, fragment05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        new StatusBar(this).initStatusBar();
        //初始化控件
        initViews();
        //绑定事件
        initEvents();
        //默认切换到Tab01
        setSelect(01);
    }

    private void initEvents() {
        tab01.setOnClickListener(this);
        tab02.setOnClickListener(this);
        tab03.setOnClickListener(this);
        tab04.setOnClickListener(this);
        tab05.setOnClickListener(this);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.menu_toolbar);
        frameLayout = (FrameLayout) findViewById(R.id.menu_frame);
        tab01 = (TextView) findViewById(R.id.menu_tab01);
        tab02 = (TextView) findViewById(R.id.menu_tab02);
        tab03 = (TextView) findViewById(R.id.menu_tab03);
        tab04 = (TextView) findViewById(R.id.menu_tab04);
        tab05 = (TextView) findViewById(R.id.menu_tab05);
    }

    @Override
    public void onClick(View v) {
        //将所有Tab背景色置为默认
        initBg();
        int id = v.getId();
        switch (id) {
            case R.id.menu_tab01:
                //切换到所选Tab的Fragment
                setSelect(01);
                break;

            case R.id.menu_tab02:
                setSelect(02);
                break;

            case R.id.menu_tab03:
                setSelect(03);
                break;

            case R.id.menu_tab04:
                setSelect(04);
                break;

            case R.id.menu_tab05:
                setSelect(05);
                break;
        }
    }

    /**
     * 切换到所选Tab的Fragment
     *
     * @param i tab所在索引
     */
    private void setSelect(int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //隐藏所有的Fragment
        hideAllFragment(transaction);
        switch (i) {
            case 01:
                if (fragment02 == null) {
                    fragment02 = new Frag02();
                    transaction.add(R.id.menu_frame, fragment02);
                } else {
                    transaction.show(fragment02);
                }
                tab01.setBackgroundColor(getResources().getColor(R.color.colorGray));
                break;
            case 02:
                if (fragment01 == null) {
                    fragment01 = new Frag01();
                    transaction.add(R.id.menu_frame, fragment01);
                } else {
                    transaction.show(fragment01);
                }
                tab02.setBackgroundColor(getResources().getColor(R.color.colorGray));
                break;
            case 03:
                if (fragment03 == null) {
                    fragment03 = new Frag03();
                    transaction.add(R.id.menu_frame, fragment03);
                } else {
                    transaction.show(fragment03);
                }
                tab03.setBackgroundColor(getResources().getColor(R.color.colorGray));
                break;
            case 04:
                if (fragment04 == null) {
                    fragment04 = new Frag04();
                    transaction.add(R.id.menu_frame, fragment04);
                } else {
                    transaction.show(fragment04);
                }
                tab04.setBackgroundColor(getResources().getColor(R.color.colorGray));
                break;
            case 05:
                if (fragment05 == null) {
                    fragment05 = new Frag05();
                    transaction.add(R.id.menu_frame, fragment05);
                } else {
                    transaction.show(fragment05);
                }
                tab05.setBackgroundColor(getResources().getColor(R.color.colorGray));
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏所有的Fragment
     *
     * @param transaction
     */
    private void hideAllFragment(FragmentTransaction transaction) {
        if (fragment01 != null) {
            transaction.hide(fragment01);
        }
        if (fragment02 != null) {
            transaction.hide(fragment02);
        }
        if (fragment03 != null) {
            transaction.hide(fragment03);
        }
        if (fragment04 != null) {
            transaction.hide(fragment04);
        }
        if (fragment05 !=  null) {
            transaction.hide(fragment05);
        }

    }

    /**
     * 将所有Tab背景色置为默认
     */
    private void initBg() {
        tab01.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        tab02.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        tab03.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        tab04.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        tab05.setBackgroundColor(getResources().getColor(R.color.colorWhite));
    }

}
