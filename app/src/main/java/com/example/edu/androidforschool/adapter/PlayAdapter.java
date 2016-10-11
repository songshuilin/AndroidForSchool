package com.example.edu.androidforschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edu.androidforschool.R;
import com.example.edu.androidforschool.bean.PlayNanChangBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9.
 */

public class PlayAdapter extends BaseAdapter {
private List<PlayNanChangBean>list;
    private Context context;
    public PlayAdapter(List<PlayNanChangBean> list,Context context){
        this.list=list;
        this.context=context;
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
      View view=null;
      ViewHoder hoder=null;
        if (convertView!=null){
            view=convertView;
            hoder= (ViewHoder) view.getTag();
        }else {
           view= LayoutInflater.from(context).inflate(R.layout.play_nanchang,null);
            hoder=new ViewHoder();
            view.setTag(hoder);
            hoder.img= (ImageView) view.findViewById(R.id.img);
            hoder.mTitle= (TextView) view.findViewById(R.id.title);
            hoder.mContent= (TextView) view.findViewById(R.id.content);
        }
        hoder.img.setImageResource(list.get(position).getImgId());
        hoder.mTitle.setText(list.get(position).getTitle());
        hoder.mContent.setText(list.get(position).getContent());
        return view;
    }
}
class ViewHoder{
    ImageView img;
    TextView mTitle,mContent;

}
