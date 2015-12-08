package com.foolself.baiduwall.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.foolself.baiduwall.R;

public class MyBottomLayout extends LinearLayout {
    RelativeLayout homeLayout;
    RelativeLayout selectLayout;
    RelativeLayout searchLayout;
    RelativeLayout locationLayout;
    RelativeLayout settingLayout;
    LayoutInflater inflater;

    public MyBottomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.layout_tab_item, this);
        findView(view);
        setOnClick();
        initData();
    }

    private void initData() {
        homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
        TextView text0 = (TextView) homeLayout.findViewById(R.id.tabText);
        text0.setText("Home");
        text0.setTextColor(Color.WHITE);
        selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
        TextView text1 = (TextView) selectLayout.findViewById(R.id.tabText);
        text1.setText("Selection");
        text1.setTextColor(Color.GRAY);
        searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
        TextView text2 = (TextView) searchLayout.findViewById(R.id.tabText);
        text2.setText("Search");
        text2.setTextColor(Color.GRAY);
        locationLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
        TextView text3 = (TextView) locationLayout.findViewById(R.id.tabText);
        text3.setText("Location");
        text3.setTextColor(Color.GRAY);
        settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
        TextView text4 = (TextView) settingLayout.findViewById(R.id.tabText);
        text4.setText("Setting");
        text4.setTextColor(Color.GRAY);

    }

    private void setOnClick() {
        homeLayout.setOnClickListener(new listener());
        selectLayout.setOnClickListener(new listener());
        searchLayout.setOnClickListener(new listener());
        locationLayout.setOnClickListener(new listener());
        settingLayout.setOnClickListener(new listener());
    }

    public interface ICallbackLister{
        public void click(int id);
    }
    ICallbackLister callbackLister = null;
    public void setOnCallbackLister(ICallbackLister callbackLister) {
        this.callbackLister = callbackLister;
    }

    private void findView(View view) {
        homeLayout = (RelativeLayout) view.findViewById(R.id.homeLayout);
        selectLayout = (RelativeLayout) view.findViewById(R.id.selectLayout);
        searchLayout = (RelativeLayout) view.findViewById(R.id.searchLayout);
        locationLayout = (RelativeLayout) view.findViewById(R.id.locationLayout);
        settingLayout = (RelativeLayout) view.findViewById(R.id.settingLayout);

    }

    private class listener implements OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.homeLayout:
                    initPic(0);
                    break;
                case R.id.selectLayout:
                    initPic(1);
                    break;
                case R.id.searchLayout:
                    initPic(2);
                    break;
                case R.id.locationLayout:
                    initPic(3);
                    break;
                case R.id.settingLayout:
                    initPic(4);
                    break;
            }
            callbackLister.click(view.getId());
        }
    }

    public void initPic(int i) {
        switch (i) {
            case 0:
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home_down);
                TextView text0 = (TextView) homeLayout.findViewById(R.id.tabText);
                text0.setTextColor(Color.WHITE);
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView text1 = (TextView) selectLayout.findViewById(R.id.tabText);
                text1.setTextColor(Color.GRAY);
                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView text2 = (TextView) searchLayout.findViewById(R.id.tabText);
                text2.setTextColor(Color.GRAY);
                locationLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView text3 = (TextView) locationLayout.findViewById(R.id.tabText);
                text3.setTextColor(Color.GRAY);
                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView text4 = (TextView) settingLayout.findViewById(R.id.tabText);
                text4.setTextColor(Color.GRAY);
                break;
            case 1:
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView text00 = (TextView) homeLayout.findViewById(R.id.tabText);
                text00.setTextColor(Color.GRAY);
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search_down);
                TextView text10 = (TextView) selectLayout.findViewById(R.id.tabText);
                text10.setTextColor(Color.WHITE);
                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView text20 = (TextView) searchLayout.findViewById(R.id.tabText);
                text20.setTextColor(Color.GRAY);
                locationLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView text30 = (TextView) locationLayout.findViewById(R.id.tabText);
                text30.setTextColor(Color.GRAY);
                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView text40 = (TextView) settingLayout.findViewById(R.id.tabText);
                text40.setTextColor(Color.GRAY);
                break;
            case 2:
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView text01 = (TextView) homeLayout.findViewById(R.id.tabText);
                text01.setTextColor(Color.GRAY);
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView text11 = (TextView) selectLayout.findViewById(R.id.tabText);
                text11.setTextColor(Color.GRAY);
                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find_down);
                TextView text21 = (TextView) searchLayout.findViewById(R.id.tabText);
                text21.setTextColor(Color.WHITE);
                locationLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView text31 = (TextView) locationLayout.findViewById(R.id.tabText);
                text31.setTextColor(Color.GRAY);
                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView text41 = (TextView) settingLayout.findViewById(R.id.tabText);
                text41.setTextColor(Color.GRAY);
                break;
            case 3:
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView text02 = (TextView) homeLayout.findViewById(R.id.tabText);
                text02.setTextColor(Color.GRAY);
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView text12 = (TextView) selectLayout.findViewById(R.id.tabText);
                text12.setTextColor(Color.GRAY);
                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView text22 = (TextView) searchLayout.findViewById(R.id.tabText);
                text22.setTextColor(Color.GRAY);
                locationLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage_down);
                TextView text32 = (TextView) locationLayout.findViewById(R.id.tabText);
                text32.setTextColor(Color.WHITE);
                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more);
                TextView text42 = (TextView) settingLayout.findViewById(R.id.tabText);
                text42.setTextColor(Color.GRAY);
                break;
            case 4:
                homeLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_home);
                TextView text03 = (TextView) homeLayout.findViewById(R.id.tabText);
                text03.setTextColor(Color.GRAY);
                selectLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_search);
                TextView text13 = (TextView) selectLayout.findViewById(R.id.tabText);
                text13.setTextColor(Color.GRAY);
                searchLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_find);
                TextView text23 = (TextView) searchLayout.findViewById(R.id.tabText);
                text23.setTextColor(Color.GRAY);
                locationLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_manage);
                TextView text33 = (TextView) locationLayout.findViewById(R.id.tabText);
                text33.setTextColor(Color.GRAY);
                settingLayout.findViewById(R.id.tabImg).setBackgroundResource(R.drawable.image_tabbar_button_more_down);
                TextView text43 = (TextView) settingLayout.findViewById(R.id.tabText);
                text43.setTextColor(Color.WHITE);
                break;
        }
    }
}
