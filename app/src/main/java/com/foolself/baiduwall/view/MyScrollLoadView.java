package com.foolself.baiduwall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by root on 15-12-8.
 */
public class MyScrollLoadView extends ScrollView {
    public static final String LOAD = "load";

    public MyScrollLoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        check();
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public interface ICallBack {
        public void click(String bottomOrTop);
    }

    ICallBack callBack = null;

    public void setICallBack(ICallBack callBack) {
        this.callBack = callBack;
    }

    //pull-down listener
    private void check() {
        if (getChildAt(0) != null && getChildAt(0).getMeasuredHeight() <= getScrollY() + getHeight()) {
            if (PullLoadRefreshView.getBottomOrTop()) {
                return;
            }
            callBack.click(LOAD);
        }
    }
}
