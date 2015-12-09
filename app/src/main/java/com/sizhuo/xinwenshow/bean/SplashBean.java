package com.sizhuo.xinwenshow.bean;

/**
 * 项目名称: XinWenShow
 * 类描述:闪屏实体（标题，图片URL）
 * Created by My灬xiao7
 * date: 2015/12/7
 *
 * @version 1.0
 */
public class SplashBean {
    public String title;//标题
    public String url;//图片url
    public String skip;//是否跳过

    public SplashBean(String title, String url, String skip) {
        this.title = title;
        this.url = url;
        this.skip = skip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }
}
