package com.foolself.baiduwall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.foolself.baiduwall.R;

import java.util.zip.Inflater;

/**
 * Created by root on 15-12-10.
 */
public class SettingItemView extends LinearLayout {
    TextView myLeftText;
    TextView myRightText;

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.setting_view, this);
        findView(view);
    }

    private void findView(View view) {
        myLeftText = (TextView) view.findViewById(R.id.myLeftText);
        myRightText = (TextView) view.findViewById(R.id.myRightText);
    }
    public TextView getLeftText() {
        return myLeftText;
    }
    public TextView getRightText() {
        return myRightText;
    }

    public void setLeftText(String text) {
        myLeftText.setText(text);
    }
    public void setRightText(String text) {
        myRightText.setText(text);
    }
    public void setRightBitMap(int resId) {
        myRightText.setBackgroundResource(resId);
    }

}
