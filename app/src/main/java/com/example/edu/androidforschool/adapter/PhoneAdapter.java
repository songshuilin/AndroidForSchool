package com.example.edu.androidforschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.edu.androidforschool.R;
import com.example.edu.androidforschool.bean.PhoneInfo;
import com.example.edu.androidforschool.bean.PhoneKind;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */

public class PhoneAdapter extends BaseExpandableListAdapter {
    private List<PhoneKind> kindList;
    private List<PhoneInfo> infoList;
    private Context context;

    public PhoneAdapter(List<PhoneKind> kindList, List<PhoneInfo> infoList, Context context) {
        this.context = context;
        this.infoList = infoList;
        this.kindList = kindList;
    }

    @Override
    public int getGroupCount() {
        return kindList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return kindList.get(groupPosition).getInfo().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return kindList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return kindList.get(groupPosition).getInfo().get(childPosition);
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
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = null;
        GroupViewHoder hoder = null;
        if (convertView != null) {
            view = convertView;
            hoder = (GroupViewHoder) view.getTag();
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.group_phone, null);
            hoder = new GroupViewHoder();
            hoder.group_tv = (TextView) view.findViewById(R.id.group_tv);
            view.setTag(hoder);
        }
        hoder.group_tv.setText(kindList.get(groupPosition).getKind());

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = null;
        ChildViewHoder hoder = null;
        if (convertView != null) {
            view = convertView;
            hoder = (ChildViewHoder) view.getTag();
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.child_phone, null);
            hoder = new ChildViewHoder();
            hoder.child_name = (TextView) view.findViewById(R.id.chile_name);
            hoder.child_phone = (TextView) view.findViewById(R.id.child_phone);
            view.setTag(hoder);
        }
        hoder.child_name.setText(kindList.get(groupPosition).getInfo().get(childPosition).getName());
        hoder.child_phone.setText(kindList.get(groupPosition).getInfo().get(childPosition).getPhone());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}

class GroupViewHoder {
    TextView group_tv;
}

class ChildViewHoder {
    TextView child_name;
    TextView child_phone;
}
