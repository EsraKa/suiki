package com.suiki.suiki;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Massil on 30/11/2016.
 */

public class MyPageAdapter extends FragmentPagerAdapter{

    private final List fragments;

    public MyPageAdapter(FragmentManager fm ,List fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment)this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
