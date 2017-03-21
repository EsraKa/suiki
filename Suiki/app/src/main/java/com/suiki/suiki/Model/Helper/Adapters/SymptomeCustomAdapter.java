package com.suiki.suiki.Model.Helper.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.suiki.suiki.Model.BddModel.Symptome;
import com.suiki.suiki.Model.Helper.InfoFiche;
import com.suiki.suiki.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Massil on 17/03/2017.
 */

public class SymptomeCustomAdapter extends ArrayAdapter<Symptome> {

    private Context context;
    private ArrayList<Symptome> dataSet;

    private static class ViewHolder{
        TextView nom;
        TextView description;
    }

    public SymptomeCustomAdapter(ArrayList<Symptome> data , Context context)
    {
        super(context , android.R.layout.expandable_list_content , data);
        this.dataSet = data;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Symptome info = getItem(position);
        final View result;
        ViewHolder viewHolder ;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.symptome_detail , parent, false);
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            result = convertView;
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.description.setText(info.description);
        viewHolder.nom.setText(info.nom);
        return result;
    }
}
