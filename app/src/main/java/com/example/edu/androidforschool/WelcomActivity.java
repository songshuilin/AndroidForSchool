package com.example.edu.androidforschool;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomActivity extends AppCompatActivity {
    private Button mBtn;
     private int second=5;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
               if (msg.what == 0x123) {
                   if (second>=0){
                       mBtn.setText(second+"");
                       second--;
                       handler.sendEmptyMessageDelayed(0x123,1000);
                   }else {
                       Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
                       startActivity(intent);
                       finish();
                   }

                }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        getSupportActionBar().hide();//隐藏标题栏
        initWidgets();
        handler.sendEmptyMessage(0x123);
    }

    private void initWidgets() {
        mBtn = (Button) findViewById(R.id.btn);
    }
}
