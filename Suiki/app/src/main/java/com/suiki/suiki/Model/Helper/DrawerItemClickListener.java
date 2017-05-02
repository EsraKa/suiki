package com.suiki.suiki.Model.Helper;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Massil on 17/03/2017.
 */

public class DrawerItemClickListener implements ListView.OnItemClickListener{

    private Activity activity;
    private int content_frame;

    public DrawerItemClickListener(Activity activity , @LayoutRes int content_frame)
    {
        this.activity = activity;
        this.content_frame = content_frame;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    private void selectItem(int position)
    {
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        args.putInt("planet_number" , position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(content_frame , fragment)
                .commit();

    }
}
