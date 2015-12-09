package com.sizhuo.xinwenshow.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * 项目名称: XinWenShow
 * 类描述: 网络检查
 * Created by My灬xiao7
 * date: 2015/12/7
 *
 * @version 1.0
 */
public class NetworkCheck {
    private Context context;

    public NetworkCheck() {
        super();
    }
    public NetworkCheck(Context context) {
        this.context = context;
    }

    /**
     * 网络检查
     * @return true  已连接
     * @return false 无网络
     */
    public Boolean isConnect(){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
//        State wifiState = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        boolean wifiFlag = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean mobileFlag = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
        if(wifiFlag||mobileFlag){
            return true;
        }else{
            return false;
        }
    }
}
