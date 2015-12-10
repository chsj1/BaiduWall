package com.foolself.baiduwall.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.foolself.baiduwall.R;
import com.foolself.baiduwall.view.SettingItemView;


/**
 * Created by root on 15-12-5.
 */
public class SettingFragment extends Fragment {
    SettingItemView autoChange;
    SettingItemView clearCached;
    SettingItemView feedback;
    SettingItemView contactUs;
    SettingItemView checkUpdate;
    SettingItemView help;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {
        autoChange = (SettingItemView) view.findViewById(R.id.autoChange);
        clearCached = (SettingItemView) view.findViewById(R.id.clearCached);
        feedback = (SettingItemView) view.findViewById(R.id.feedback);
        contactUs = (SettingItemView) view.findViewById(R.id.contactUs);
        checkUpdate = (SettingItemView) view.findViewById(R.id.checkUpdate);
        help = (SettingItemView) view.findViewById(R.id.help);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        autoChange.setLeftText("Auto Change Wall");
        autoChange.setRightBitMap(R.drawable.image_more_subitem_arrow);

        clearCached.setLeftText("Clear Cached Data");

        feedback.setLeftText("feedback your idea");
        feedback.setRightBitMap(R.drawable.image_more_subitem_arrow);

        contactUs.setLeftText("Contact Us");
        contactUs.setRightBitMap(R.drawable.image_more_subitem_arrow);

        checkUpdate.setLeftText("Check Update");

        help.setLeftText("Help");
        help.setRightBitMap(R.drawable.image_more_subitem_arrow);


    }
}
