package com.example.administrator.recoderdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Toolbar) findViewById(R.id.toolbar)).setTitle("Sound Recorder");
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        tabLayout = ((TabLayout) findViewById(R.id.tablayout));
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }
    class MyAdapter extends FragmentPagerAdapter{
        private String[] strings  = {"RECORD","SAVED RECORDINGS"};
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            BlankFragment.newInstance(position);
            switch (position) {
                case 0:
                    return  BlankFragment.newInstance(position);
                case 1:
                    return  BlankFragment.newInstance(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }
}
