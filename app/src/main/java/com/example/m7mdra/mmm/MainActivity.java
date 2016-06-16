package com.example.m7mdra.mmm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private final String TAG = MainActivity.this.getClass().getSimpleName();
    SectionPagerAdapter pagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar=getSupportActionBar();
        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        }
        pagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());
        viewPager= (ViewPager) findViewById(R.id.pager);
        if (viewPager != null) {
            viewPager.setAdapter(pagerAdapter);
        }
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        for (int i=0;i<pagerAdapter.getCount();i++){
            actionBar.addTab(actionBar.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(this));
            actionBar.setSplitBackgroundDrawable();
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
    public class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new FirstFragment();
            }else {
                return new SecondFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
        public CharSequence getPageTitle(int pos){
            switch (pos){
                case 0:
                    return "first".toUpperCase();
                case 1:
                    return "second".toUpperCase();
            }
            return null;
        }
    }
}


