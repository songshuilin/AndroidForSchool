package com.example.edu.androidforschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.edu.androidforschool.R;
import com.example.edu.androidforschool.bean.PhoneInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */

public class ShowAllPhoneAdapter extends BaseAdapter {
    private List<PhoneInfo> list;
    private Context context;

    public ShowAllPhoneAdapter(List<PhoneInfo> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ShowAllPhoneViewHoder hoder = null;
        if (convertView != null) {
            view = convertView;
            hoder = (ShowAllPhoneViewHoder) view.getTag();
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.show_all_phone_layout, null);
            hoder = new ShowAllPhoneViewHoder();
            view.setTag(hoder);
            hoder.name = (TextView) view.findViewById(R.id.name);
            hoder.phone = (TextView) view.findViewById(R.id.phone);
        }
        hoder.phone.setText(list.get(position).getPhone());
        hoder.name.setText(list.get(position).getName());
        return view;
    }
}

class ShowAllPhoneViewHoder {
    TextView name;
    TextView phone;
}