package com.example.edu.androidforschool.schoollife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.edu.androidforschool.MainActivity;
import com.example.edu.androidforschool.R;

import java.util.List;

public class XiaoQuPingTuActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner mSp;
    private Button mBtn;
    private ImageView mImg;
    private String list[] = new String[]{"交通示意图", "虹桥校区", "麦庐校区", "枫林校区"};
     private float myX,myY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_qu_ping_tu);
        initWidgets();//初始化各控件
        initSpinner();//实现下拉框监听事件
        initImg();//随着手指拖动图片
        getSupportActionBar().hide();
    }

    private void initImg() {
        mImg.setOnTouchListener(new View.OnTouchListener() {
            float curX, curY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        myX = event.getX();
                        myY = event.getY();

                        break;
                    case MotionEvent.ACTION_MOVE:
                        curX = event.getX();
                        curY = event.getY();
                        mImg.scrollBy((int) (myX - curX), (int) (myY - curY));
                        myX = curX;
                        myY = curY;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSp.setAdapter(adapter);
        mSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        mImg.setImageResource(R.drawable.jiaoqiaoxiaoqu);
                        break;
                    case 2:
                        mImg.setImageResource(R.drawable.mailuxiaoqu);
                        break;
                    case 3:
                        mImg.setImageResource(R.drawable.fenglinxiaoqu);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initWidgets() {
        mBtn = (Button) findViewById(R.id.back);
        mBtn.setOnClickListener(this);
        mImg = (ImageView) findViewById(R.id.xiaoqupingmiantu);
        mSp = (Spinner) findViewById(R.id.xiaoqupingmiantuSpinner);

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
