package com.suiki.suiki.Model.Helper.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Vue.Helper.Fragments.FicheEnCoursFragment;
import com.suiki.suiki.Vue.Helper.Fragments.FicheTermineFragment;

/**
 * Created by Massil on 13/04/2017.
 */

public class SlidingPageAdapter extends FragmentPagerAdapter {

    private Patient patient;

    public SlidingPageAdapter(FragmentManager fm , Patient p)
    {
        super(fm);
        this.patient = p;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putSerializable("Patient" , this.patient);
        if(position == 0)
        {
            Fragment f = new FicheEnCoursFragment();
            f.setArguments(b);
            return f;
        }
        else
        {
            Fragment f = new FicheTermineFragment();
            f.setArguments(b);
            return f;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (position == 0)? "En cours" : "Termine";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
