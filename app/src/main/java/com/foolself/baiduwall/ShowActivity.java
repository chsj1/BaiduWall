package com.foolself.baiduwall;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    ArrayList<Integer> bitMapData = new ArrayList<Integer>();
    Gallery myGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        myGallery = (Gallery) findViewById(R.id.myGallery);
        initData();
        myGallery.setAdapter(new MyAdapter(ShowActivity.this));
    }

    private void initData() {
        bitMapData.add(R.drawable.img1);
        bitMapData.add(R.drawable.img2);
        bitMapData.add(R.drawable.img3);
        bitMapData.add(R.drawable.img4);
    }

    private class MyAdapter extends BaseAdapter {
        Context context;
        public MyAdapter(Context context) {
            this.context = context;
        }
        @Override
        public int getCount() {
            return bitMapData.size();
        }

        @Override
        public Object getItem(int position) {
            return bitMapData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img = new ImageView(context);
            img.setBackgroundResource(bitMapData.get(position));
            img.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.FILL_PARENT, Gallery.LayoutParams.WRAP_CONTENT));
            return img;
        }
    }

}
