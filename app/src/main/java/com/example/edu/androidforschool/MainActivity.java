package com.example.edu.androidforschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private ImageView mImgLife,mImgGo,mImgPlay,mImgPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        getSupportActionBar().hide();
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mImgGo= (ImageView) findViewById(R.id.chuxingzhinan);
        mImgLife= (ImageView) findViewById(R.id.xuexiaoshenghuo);
        mImgPhone= (ImageView) findViewById(R.id.haomabaishitong);
        mImgPlay= (ImageView) findViewById(R.id.youwannanchang);
        mImgGo.setOnClickListener(this);
        mImgPlay.setOnClickListener(this);
        mImgLife.setOnClickListener(this);
        mImgPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent;
        switch (id){
            case R.id.xuexiaoshenghuo:
                intent=new Intent(this,SchoolLifeActivity.class);
                startActivity(intent);
                break;
            case R.id.chuxingzhinan:
                 intent=new Intent(this,GoActivity.class);
                startActivity(intent);
                break;
            case R.id.youwannanchang:
                 intent=new Intent(this,PlayActivity.class);
                startActivity(intent);
                break;
            case R.id.haomabaishitong:
                 intent=new Intent(this,PhoneActivity.class);
                startActivity(intent);
                break;



        }

    }
}
