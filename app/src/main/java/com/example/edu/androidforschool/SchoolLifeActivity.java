package com.example.edu.androidforschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.edu.androidforschool.schoollife.XiaoQuPingTuActivity;
import com.example.edu.androidforschool.schoollife.XiaoYuanFengjingActivity;
import com.example.edu.androidforschool.schoollife.XinshengZhiNanActivity;

public class SchoolLifeActivity extends AppCompatActivity implements View.OnClickListener{
   private TextView mTx1,mTx2,mTx3,mTx4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_life);
        initWidgets();
        getSupportActionBar().hide();
    }

    private void initWidgets() {
        mTx1= (TextView) findViewById(R.id.xiaoqupingmiantu);
        mTx2= (TextView) findViewById(R.id.xiaoyuanfengjing);
        mTx3= (TextView) findViewById(R.id.xinshengzhinan);
        mTx4= (TextView) findViewById(R.id.back);
        mTx1.setOnClickListener(this);
        mTx2.setOnClickListener(this);
        mTx3.setOnClickListener(this);
        mTx4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent;
        switch (id){
            case R.id.xiaoqupingmiantu:
                intent=new Intent(this, XiaoQuPingTuActivity.class);
                startActivity(intent);
                break;
            case R.id.xiaoyuanfengjing:
                intent=new Intent(this, XiaoYuanFengjingActivity.class);
                startActivity(intent);
                break;
            case R.id.xinshengzhinan:
                intent=new Intent(this, XinshengZhiNanActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;

        }

    }
}
