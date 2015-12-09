package com.sizhuo.xinwenshow.bean;

/**
 * 项目名称: XinWenShow
 * 类描述:新闻列表bean
 * Created by My灬xiao7
 * date: 2015/12/9
 *
 * @version 1.0
 */
public class NewsBean {
    /**
     * 标题
     */
    public String title;
     /**
     * 内容
     */
    public String url;
     /**
     * 缩略图
     */
    public String image_url;

    public NewsBean(String title, String url, String image_url) {
        this.title = title;
        this.url = url;
        this.image_url = image_url;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
