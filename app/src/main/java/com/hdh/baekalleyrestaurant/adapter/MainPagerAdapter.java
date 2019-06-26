package com.hdh.baekalleyrestaurant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hdh.baekalleyrestaurant.ui.home.HomeFragment;
import com.hdh.baekalleyrestaurant.ui.myinfo.MyInfoFragment;


/**
 * Created by GIGAMOLE on 8/18/16.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final static int COUNT = 3;

    private final static int HOME = 0;
    private final static int MY_INFO = 1;

    public MainPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case HOME:
                return new HomeFragment();
            case MY_INFO:
            default:
                return new MyInfoFragment();
        }
    }

    @Override
    public int getCount() {
        return COUNT;
    }
}
