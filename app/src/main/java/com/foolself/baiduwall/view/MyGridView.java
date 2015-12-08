package com.foolself.baiduwall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by root on 15-12-7.
 */
public class MyGridView extends GridView{

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //get the page size
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int exPectHeight = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, exPectHeight);
    }
}
