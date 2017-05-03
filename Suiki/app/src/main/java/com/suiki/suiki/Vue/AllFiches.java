package com.suiki.suiki.Vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.astuetz.PagerSlidingTabStrip;
import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.FicheMedical;
import com.suiki.suiki.Model.BddModel.Pathologie;
import com.suiki.suiki.Model.BddModel.Patient;
import com.suiki.suiki.Model.BddModel.Phase;
import com.suiki.suiki.Model.BddModel.Symptome;
import com.suiki.suiki.Model.Helper.Adapters.FicheCustomAdapter;
import com.suiki.suiki.Model.Helper.Adapters.SlidingPageAdapter;
import com.suiki.suiki.Model.Helper.InfoFiche;
import com.suiki.suiki.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Massil on 21/02/2017.
 */

public class AllFiches extends FragmentActivity{

    private ListView listFiches;
    private ListView ancienneListFiches;
    private Patient patient;
    private Toolbar toolbar;
    private ArrayList<InfoFiche> listInfoFiche;
    private ArrayAdapter<String> arrayAdapter;

    private FicheCustomAdapter ficheCustomAdapter;

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_fiches);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new SlidingPageAdapter(getSupportFragmentManager() ,
                (Patient) getIntent().getSerializableExtra("Patient")));

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);

    }
}
