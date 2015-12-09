package com.foolself.baiduwall.fragment;

import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

import com.foolself.baiduwall.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.LogRecord;


/**
 * Created by root on 15-12-5.
 */
public class SearchFragment extends Fragment {
    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    AbsoluteLayout myLayout1;
    AbsoluteLayout myLayout2;
    int scrrenWidth;
    int indexPage = 0;
    GestureDetector detector;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {
        view.setClickable(true);
        view.setOnTouchListener(new MyOnTouchLister());
        myLayout1 = (AbsoluteLayout) view.findViewById(R.id.myLayout1);
        myLayout2 = (AbsoluteLayout) view.findViewById(R.id.myLayout2);


    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private class MyOnTouchLister implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return detector.onTouchEvent(event);
        }
    }


    private class MyGestureLister implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() < e2.getX()) {  //left fling to right
                indexPage++;
                if (indexPage == data.size()) indexPage = 0;
                switch (myLayout1.getVisibility()) {
                    case 0:   // is display, zoom in it and hide, zoom in other one and to display
                        setState(100);
                        setState(101);
                        break;
                    case 4:   // is hide but occupy the space
                        break;
                    case 8:   // is hide
                        setState(200);
                        setState(201);
                        break;
                }
            }
            return false;
        }
    }

    private void setState(final int i) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(i);

            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    //myLayout zoom in and hide
                    scalCancer(myLayout1, 1000, 0);
                    myLayout1.setVisibility(8);
                    break;
                case 101:
                    setDataToPage(myLayout2, indexPage);
                    scalIn(myLayout2, 2000, 0);
                    myLayout2.setVisibility(0);
                    break;
                case 200:
                    //myLayout zoom in and hide
                    scalCancer(myLayout2, 1000, 0);
                    myLayout2.setVisibility(8);
                    break;
                case 201:
                    setDataToPage(myLayout1, indexPage);
                    scalIn(myLayout1, 2000, 0);
                    myLayout1.setVisibility(0);
                    break;
            }
        }
    };

    private void scalIn(AbsoluteLayout myLayout2, int time, int deLayTime) {
        ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        animation.setStartOffset(deLayTime);
        animation.setDuration(time);

        AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
        animation1.setDuration(time);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(animation);
        animationSet.addAnimation(animation1);

        myLayout1.startAnimation(animationSet);
    }

    //zoom in myLayout1
    private void scalCancer(AbsoluteLayout myLayout1, int time, int deLayTime) {
        ScaleAnimation animation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        animation.setStartOffset(deLayTime);
        animation.setDuration(time);

        AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
        animation1.setDuration(time);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(animation);
        animationSet.addAnimation(animation1);

        myLayout1.startAnimation(animationSet);


    }


    private void init() {
        detector = new GestureDetector(getActivity(), new MyGestureLister());
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        scrrenWidth = metrics.widthPixels;
        initData();
        setDataToPage(myLayout1, indexPage);
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            switch (i) {
                case 0:
                    ArrayList<String> newData1 = new ArrayList<String>();
                    for (int j = 0; j < 10; j++) {
                        newData1.add("China");
                    }
                    data.add(newData1);
                    break;
                case 1:
                    ArrayList<String> newData2 = new ArrayList<String>();
                    for (int j = 0; j < 10; j++) {
                        newData2.add("America");
                    }
                    data.add(newData2);
                    break;
            }
        }
    }

    private void setDataToPage(AbsoluteLayout myLayout1, int indexPage) {
        myLayout1.removeAllViews();
        int startY = 50;
        for (int i = 0; i < data.get(indexPage).size(); i++) {
            int x = getRandom(50, scrrenWidth - 50);
            int y = startY;
            TextView textView = new TextView(getActivity());
            textView.setTextSize(10);
            textView.setText(data.get(indexPage).get(i));
            AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(80, 50, x, y);
            myLayout1.addView(textView, layoutParams);
            startY += 50;
        }

    }

    private int getRandom(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }
}
