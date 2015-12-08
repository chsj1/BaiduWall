package com.foolself.baiduwall.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsoluteLayout;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.foolself.baiduwall.view.Ad_scroll;
import com.foolself.baiduwall.image.SmartImageView;
import com.foolself.baiduwall.R;
import com.foolself.baiduwall.entity.HomeGrid;

import java.util.ArrayList;

/**
 * Created by root on 15-12-5.
 */
public class HomeFragment extends Fragment {
    Ad_scroll ad_scroll;
    ViewPager myPageView;
    GridView myGridView;
    ScrollView myScrollView;
    ArrayList<View> bitMap = new ArrayList<View>();
    ArrayList<HomeGrid> gridData = new ArrayList<HomeGrid>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        finalView(view);
        return view;
    }

    private void finalView(View view) {
        ad_scroll = (Ad_scroll) view.findViewById(R.id.myAdScroll);
        myPageView = ad_scroll.getViewPage();
        myGridView = (GridView) view.findViewById(R.id.myGridView);
        myScrollView = (ScrollView) view.findViewById(R.id.myScrollView);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        initAdData();
        initGridData();
        myPageView.setAdapter(new MyAdapter());
        ad_scroll.setPageFromTime(3000);
        myGridView.setAdapter(new MyAdapter1(getActivity()));
        myScrollView.smoothScrollTo(0, 0);
    }

    private void initGridData() {
        for (int i = 0; i < 10; i++) {
            HomeGrid grid = new HomeGrid();
            grid.setImg(R.drawable.img1);
            grid.setIntroduce("a picture to show");
            gridData.add(grid);
        }
    }

    private void initAdData() {
        LayoutInflater inflater1 = getActivity().getLayoutInflater();
        View view1 = inflater1.inflate(R.layout.ad_scroll_item, null);
        view1.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img1);
        bitMap.add(view1);
        LayoutInflater inflater2 = getActivity().getLayoutInflater();
        View view2 = inflater2.inflate(R.layout.ad_scroll_item, null);
        view2.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img2);
        bitMap.add(view2);
        LayoutInflater inflater3 = getActivity().getLayoutInflater();
        View view3 = inflater3.inflate(R.layout.ad_scroll_item, null);
        view3.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img3);
        bitMap.add(view3);
        LayoutInflater inflater4 = getActivity().getLayoutInflater();
        View view4 = inflater4.inflate(R.layout.ad_scroll_item, null);
        view4.findViewById(R.id.adImg).setBackgroundResource(R.drawable.img4);
        bitMap.add(view4);
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return bitMap.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView(bitMap.get(position));
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager)container).addView(bitMap.get(position));
            return bitMap.get(position);
        }
    }

    //GridView adapter
    private class MyAdapter1 extends BaseAdapter {
        Context context;
        LayoutInflater inflater;

        MyAdapter1(Context context) {
            this.context = context;
            inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return gridData.size();
        }

        @Override
        public Object getItem(int position) {
            return gridData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.home_fragment_grid_item, null);
                holder = new ViewHolder();
                holder.img = (SmartImageView) convertView.findViewById(R.id.mySmartImage);
                holder.introduce = (TextView) convertView.findViewById(R.id.introduce);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.img.setBackgroundResource(gridData.get(position).getImg());
            convertView.setLayoutParams(new AbsListView.LayoutParams(AbsoluteLayout.LayoutParams.FILL_PARENT, 400));
            holder.introduce.setText(gridData.get(position).getIntroduce());
            return convertView;
        }
    }

    static class ViewHolder {
        SmartImageView img;
        TextView introduce;
    }
}
