package com.suiki.suiki.Model.Helper.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.suiki.suiki.Model.Helper.InfoFiche;
import com.suiki.suiki.R;

import java.util.ArrayList;

/**
 * Created by Massil on 15/03/2017.
 */

public class FicheCustomAdapter extends ArrayAdapter<InfoFiche> {
    private ArrayList<InfoFiche> dataSet;
    Context context;
    private int lastPosition = -1;

    private static class ViewHolder{
        TextView text1;
        TextView text2;
        ImageView image;
    }

    public FicheCustomAdapter(ArrayList<InfoFiche> data , Context context)
    {
        super(context , android.R.layout.expandable_list_content , data);
        this.dataSet = data;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InfoFiche info = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fiche_layout , parent , false);
            viewHolder.text1 = (TextView) convertView.findViewById(R.id.text1);
            viewHolder.text2 = (TextView) convertView.findViewById(R.id.text2);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            result = convertView;
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(context , (position>lastPosition)? R.anim.up_from_bottom : R.anim.down_from_top );
        result.startAnimation(animation);

        viewHolder.text1.setText(info.getPhase());
        viewHolder.text2.setText(info.getDate());
        viewHolder.image.setTag(position);
        return convertView;
    }
}
