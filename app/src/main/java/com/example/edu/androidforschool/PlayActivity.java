package com.example.edu.androidforschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.edu.androidforschool.adapter.PlayAdapter;
import com.example.edu.androidforschool.bean.PlayNanChangBean;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
   private ListView mLv;
    private List<PlayNanChangBean>list=new ArrayList<>();
    private PlayAdapter mAdapter;
    private int imgs[]=new int[]{
            R.drawable.tengwangge,
            R.drawable.badashanrenjinianguan,
            R.drawable.hanwangfeng,
            R.drawable.xiangshangongyuan,
            R.drawable.xiangshangongyuan,
            R.drawable.meiling

    };
    private String title[]=new String[]{
            "滕王阁",
            "八大山人纪念馆",
            "罕汪峰",
            "象山森林公园",
            "西山万圣宫",
            "梅林"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initWidgets();
        initDatas();
        mAdapter=new PlayAdapter(list,PlayActivity.this);
        mLv.setAdapter(mAdapter);
        mLv.setOnItemClickListener(this);
        getSupportActionBar().hide();

    }

    private void initDatas() {
        for (int i = 0; i <imgs.length; i++) {
              PlayNanChangBean bean=new PlayNanChangBean();
              bean.setImgId(imgs[i]);
              bean.setTitle(title[i]);
              bean.setContent("我不是程序员"+i);
              list.add(bean);
        }
    }

    private void initWidgets() {
        mLv= (ListView) findViewById(R.id.listview);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(PlayActivity.this,"我是第"+position+"位置",Toast.LENGTH_SHORT).show();
    }
}
