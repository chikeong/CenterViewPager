package com.support.chikeong.centerviewpager.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.support.chikeong.centerviewpager.R;
import com.support.chikeong.centerviewpager.lib.CenterViewPager;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        CenterViewPager pager = (CenterViewPager) findViewById(R.id.gallery);
        pager.setPageMargin(15);
        pager.setAdapter(new MyPagerAdapter(this));
    }

    private final static class MyPagerAdapter extends PagerAdapter{
        Context context;
        int[] color ={Color.BLACK,Color.BLUE,Color.RED,Color.GRAY,Color.GREEN,Color.YELLOW};
        private MyPagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = new View(context);
            v.setBackgroundColor(color[position]);
            container.addView(v , ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return v;
        }

        @Override
        public float getPageWidth(int position) {
            return 0.7f;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}

