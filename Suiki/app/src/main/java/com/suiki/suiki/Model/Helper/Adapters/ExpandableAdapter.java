package com.suiki.suiki.Model.Helper.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.suiki.suiki.Model.BddModel.Exercice;
import com.suiki.suiki.Model.BddModel.Symptome;
import com.suiki.suiki.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Massil on 05/04/2017.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter{

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String , List<Object>> listDataChild;

    public ExpandableAdapter(Context context, List<String> listDataHeader , HashMap<String , List<Object>> listDataChild){
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this
                .listDataChild
                .get(
                        this.listDataHeader.get(groupPosition)
                )
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header_expandable_list_view , null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.list_header);
        txtListChild.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Object childText = (Object) getChild(groupPosition , childPosition);
        if(convertView == null)
        {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_expandable_list_view , null);
        }
        TextView textListChild = (TextView) convertView.findViewById(R.id.list_item);
        if(childText instanceof Exercice)
        {
            Exercice exercice = (Exercice) childText;
            textListChild.setText(exercice.nom);
        }
        else if(childText instanceof Symptome)
        {
            Symptome symptome = (Symptome) childText;
            textListChild.setText(symptome.nom);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
