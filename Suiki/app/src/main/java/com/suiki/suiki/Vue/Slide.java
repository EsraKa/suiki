package com.suiki.suiki.Vue;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.suiki.suiki.MyPageAdapter;
import com.suiki.suiki.R;

import java.util.Vector;

/**
 * Created by Esra on 11/01/2017.
 */

public class Slide extends FragmentActivity {

  private PagerAdapter pagerAdapter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pages);

    Vector fragments = new Vector();

    fragments.add(Fragment.instantiate(this,Connexion.class.getName()));
    fragments.add(Fragment.instantiate(this,Profile.class.getName()));

    this.pagerAdapter = new MyPageAdapter(super.getSupportFragmentManager() , fragments);

    ViewPager pager = (ViewPager) super.findViewById(R.id.viewPager);

    pager.setAdapter(this.pagerAdapter);
  }
}
