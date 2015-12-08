package com.foolself.baiduwall.entity;

/**
 * Created by root on 15-12-7.
 */
public class HomeGrid {
    private int img;
    private String introduce;

    public HomeGrid(int img, String introduce) {
        super();
        this.img = img;
        this.introduce = introduce;
    }
    public HomeGrid() {
        super();
    }
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
