package com.foolself.baiduwall.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.foolself.baiduwall.R;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by root on 15-12-6.
 */
public class Ad_scroll extends LinearLayout {
    ViewPager myViewPage;
    ImageView img1, img2, img3, img4;
    Timer timer;
    TimerTask task;
    int index = 0;
    public Ad_scroll(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.ad_scroll, this);
        findView(view);
        myViewPage.setOnPageChangeListener(new MyPageChangeLister());
    }
    private class MyPageChangeLister implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int id) {
            index = id;
            hand();
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    private void findView(View view) {
        myViewPage = (ViewPager) view.findViewById(R.id.myViewPage);
        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
        img3 = (ImageView) view.findViewById(R.id.img3);
        img4 = (ImageView) view.findViewById(R.id.img4);
    }

    public void setPageFromTime(int delayTime) {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                hand();
                index++;
                if (index == 4){
                    index = 0;
                }
            }
        };
        timer.schedule(task, delayTime, delayTime);
    }

    private void hand() {
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        Message msg = new Message();
        msg.setData(bundle);
        msg.what = 100;
        handler.sendMessage(msg);
    }

    android.os.Handler handler = new android.os.Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    int index = msg.getData().getInt("index");
                    initPic(index);
                    break;
            }
        }

    };

    /**
     * update the ad_scroll
     * @param index2:the current page should set index2
     */
    private void initPic(int index2) {
        //update the page
        myViewPage.setCurrentItem(index2);
        //update the point of page
        switch (index2) {
            case 0:
                img1.setBackgroundResource(R.drawable.point_selected);
                img2.setBackgroundResource(R.drawable.point_normal);
                img3.setBackgroundResource(R.drawable.point_normal);
                img4.setBackgroundResource(R.drawable.point_normal);
                break;
            case 1:
                img1.setBackgroundResource(R.drawable.point_normal);
                img2.setBackgroundResource(R.drawable.point_selected);
                img3.setBackgroundResource(R.drawable.point_normal);
                img4.setBackgroundResource(R.drawable.point_normal);
                break;
            case 2:
                img1.setBackgroundResource(R.drawable.point_normal);
                img2.setBackgroundResource(R.drawable.point_normal);
                img3.setBackgroundResource(R.drawable.point_selected);
                img4.setBackgroundResource(R.drawable.point_normal);
                break;
            case 3:
                img1.setBackgroundResource(R.drawable.point_normal);
                img2.setBackgroundResource(R.drawable.point_normal);
                img3.setBackgroundResource(R.drawable.point_normal);
                img4.setBackgroundResource(R.drawable.point_selected);
                break;
        }

    }
    public ViewPager getViewPage() {
        return myViewPage;
    }
}
