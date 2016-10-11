package com.example.edu.androidforschool.schoollife;

import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.edu.androidforschool.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XiaoYuanFengjingActivity extends AppCompatActivity implements View.OnClickListener {
    private HorizontalScrollView mHs;
    private Button mBtn;
    private LinearLayout mLl;
    private ImageView srcimg;
    private List<Integer> list = new ArrayList<>();
    private List<ImageView> listImg = new ArrayList<>();
    private int temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_yuan_fengjing);
        getSupportActionBar().hide();
        initWidgets();
        initListImg();
        initList();
        addFormHs();
        initLinstener();
        srcimg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(XiaoYuanFengjingActivity.this);
                builder.setTitle("换背景");
                builder.setMessage("是否真的换背景");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            //换系统背景图
                            WallpaperManager manager = WallpaperManager.getInstance(XiaoYuanFengjingActivity.this);
                            manager.setResource(list.get(temp));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();
                return true;
            }
        });

        srcimg.setImageResource(list.get(temp));
        listImg.get(temp).setAlpha(1.0f);
    }

    /**
     * 监听各图片的事件
     */
    private void initLinstener() {
        for (int i = 0; i < listImg.size(); i++) {
            listImg.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int j = 0; j < listImg.size(); j++) {
                        listImg.get(j).setAlpha(0.5f);
                    }
                    srcimg.setImageResource(list.get(v.getId()));
                    listImg.get(v.getId()).setAlpha(1.0f);
                    temp = v.getId();
                }
            });
        }
    }

    /**
     * 初始化图片
     */
    private void initList() {
        for (int i = 0; i < list.size(); i++) {
            final ImageView img = new ImageView(this);
            img.setImageResource(list.get(i));
            img.setId(i);//为每张图片设置个id
            img.setAlpha(0.5f);
            listImg.add(img);
        }
    }

    /**
     * 为HorizontalScrollView添加图片
     */
    private void addFormHs() {
        for (int i = 0; i < list.size(); i++) {
            mLl.addView(listImg.get(i), 100, 60);
        }

    }

    private void initListImg() {
        list.add(R.drawable.baosige);
        list.add(R.drawable.beihu);
        list.add(R.drawable.chayuan);
        list.add(R.drawable.fengyuan);
        list.add(R.drawable.guiyuan);
        list.add(R.drawable.huzhongting);
        list.add(R.drawable.jiaogonglou);
        list.add(R.drawable.jiaohu);
        list.add(R.drawable.liyuan);
        list.add(R.drawable.lumiyuan);
        list.add(R.drawable.mailu);
        list.add(R.drawable.qifeiting);
        list.add(R.drawable.sanbulang);
        list.add(R.drawable.taoyuan);
        list.add(R.drawable.tiyuguan);
        list.add(R.drawable.waijiaoshenghuoqu);
        list.add(R.drawable.xiaomen);
        list.add(R.drawable.yinyuanguanchang);
        list.add(R.drawable.youyongchi);
        list.add(R.drawable.zonghedalou);
    }

    private void initWidgets() {
        mHs = (HorizontalScrollView) findViewById(R.id.horScorllview);
        mBtn = (Button) findViewById(R.id.back);
        mBtn.setOnClickListener(this);
        mLl = (LinearLayout) findViewById(R.id.horLinnerlayout);
        srcimg = (ImageView) findViewById(R.id.img);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.back:
                finish();
                break;

        }
    }
}
