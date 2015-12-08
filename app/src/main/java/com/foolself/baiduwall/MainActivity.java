package com.foolself.baiduwall;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.foolself.baiduwall.R;
import com.foolself.baiduwall.view.MyBottomLayout;

import com.foolself.baiduwall.fragment.HomeFragment;
import com.foolself.baiduwall.fragment.LocationFragment;
import com.foolself.baiduwall.fragment.SearchFragment;
import com.foolself.baiduwall.fragment.SelectFragment;
import com.foolself.baiduwall.fragment.SettingFragment;

public class MainActivity extends FragmentActivity {
    MyBottomLayout bottomLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //initPageContent(new HomeFragment());
        viewPager = (ViewPager) findViewById(R.id.myViewPage);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        findView();
        setOnClick();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int id) {
                bottomLayout.initPic(id);
            }

            @Override
            public void onPageScrollStateChanged(int id) {
            }
        });
    }
/*    private void initPageContent(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.myContent, fragment);
        ft.commit();
    }*/

    private void setOnClick() {
        bottomLayout.setOnCallbackLister(new MyBottomLayout.ICallbackLister() {
            @Override
            public void click(int id) {
                switch (id) {
                    case R.id.homeLayout:
                        //initPageContent(new HomeFragment());
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.selectLayout:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.searchLayout:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.locationLayout:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.settingLayout:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });
    }
    private void findView() {
        bottomLayout = (MyBottomLayout) findViewById(R.id.myBottomLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int id) {
            switch (id) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new SelectFragment();
                case 2:
                    return new SearchFragment();
                case 3:
                    return new LocationFragment();
                case 4:
                    return new SettingFragment();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
