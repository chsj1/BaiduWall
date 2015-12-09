package com.foolself.baiduwall.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsoluteLayout;
import android.widget.BaseAdapter;
import android.os.Handler;

import com.foolself.baiduwall.R;
import com.foolself.baiduwall.image.SmartImageView;
import com.foolself.baiduwall.view.MyGridView;
import com.foolself.baiduwall.view.PullLoadRefreshView;

import java.util.ArrayList;

public class SelectFragment extends Fragment {
    ArrayList<Integer> data = new ArrayList<Integer>();
    PullLoadRefreshView pullLoadRefreshView;
    MyGridView myGridView;
    MyAdapter myAdapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_fragment, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {
        pullLoadRefreshView = (PullLoadRefreshView) view.findViewById(R.id.myPullLoadRefreshView);
        //myGridView = (MyGridView) view.findViewById(R.id.myGridView);
        myGridView = pullLoadRefreshView.getMyGridView();
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        pullLoadRefreshView.setIPullClick(new PullLick());
        initGridData();
        myAdapter = new MyAdapter(getActivity());
        myGridView.setAdapter(myAdapter);

    }

    private void initGridData() {
        for (int i = 0; i < 10; i++) {
            data.add(R.drawable.img3);
        }
    }

    private class PullLick implements PullLoadRefreshView.IPullCallBack {
        @Override
        public void Load() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        initGridData();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        public void refresh() {

        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:    //data loaded re adapter
                    myAdapter.notifyDataSetChanged();
                    pullLoadRefreshView.dataFinish();
            }
        }
    };

    private class MyAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = (View) inflater.inflate(R.layout.fragment_select_grid_item, null);
                viewHolder = new ViewHolder();
                viewHolder.img = (SmartImageView) convertView.findViewById(R.id.myImg);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.img.setBackgroundResource(data.get(position));
            convertView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, 400));
            return convertView;
        }
    }

    static class ViewHolder {
        SmartImageView img;
    }
}
