package com.foolself.baiduwall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.os.Handler;
import com.foolself.baiduwall.R;

public class PullLoadRefreshView extends LinearLayout {
    public static final String LOAD = "load";
    MyScrollLoadView myScrollLoadView;
    MyGridView myGridView;
    LinearLayout myLinearLayout;
    static boolean bottomOrTop = false;

    public PullLoadRefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.pull_load_refresh, this);
        findView(view);
        setCallBack();
    }

    private void setCallBack() {
        myScrollLoadView.setICallBack(new MyCallBack());
    }

    public interface IPullCallBack {
        public void Load();
        public void refresh();
    }
    IPullCallBack pullCallBack = null;
    public void setIPullClick(IPullCallBack pullCallBack) {
        this.pullCallBack = pullCallBack;
    }

    private class MyCallBack implements MyScrollLoadView.ICallBack {

        @Override
        public void click(String bottomOrTop) {
            if (bottomOrTop.equals(LOAD)) {
                pullCallBack.Load();
            } else {
                pullCallBack.refresh();
            }
        }
    }

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 100:
                    setBottomShow();
                    bottomOrTop = true;
                    break;
                case 101:
                    setBottomGone();
                    bottomOrTop = false;
                    break;
            }
        }
    };

    private void findView(View view) {
        myScrollLoadView = (MyScrollLoadView) view.findViewById(R.id.myScrollLoadView);
        myGridView = (MyGridView) view.findViewById(R.id.myGridView);
        myLinearLayout = (LinearLayout) view.findViewById(R.id.myLinearLayout);
    }

    //load or refresh ing or not
    public static boolean getBottomOrTop() {
        return bottomOrTop;
    }

    public void setBottomShow() {
        myLinearLayout.setVisibility(View.VISIBLE);
    }

    public void setBottomGone() {
        myLinearLayout.setVisibility(View.GONE);

    }

    public void dataFinish() {
        handler.sendEmptyMessage(101);
    }

    public MyScrollLoadView getMyScrollLoadView() {
        return myScrollLoadView;
    }
    public MyGridView getMyGridView() {
        return myGridView;
    }
}
