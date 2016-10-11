package com.example.edu.androidfortouchsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLl;
    private ImageView mImg;
    private float myX, myY;
    private final static String TAG = "TAG";
    private float start_line,end_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImg = (ImageView) findViewById(R.id.img);
        mLl = (LinearLayout) findViewById(R.id.activity_main);
        mLl.setOnTouchListener(new View.OnTouchListener() {
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
                        if (event.getPointerCount()==2){
                            float x1=event.getX(0);
                            float y1=event.getY(0);
                            float x2=event.getX(1);
                            float y2=event.getY(1);
                            end_line= (float) Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
                        }
                        if (start_line<=0){
                            start_line=end_line;
                        }

                        LinearLayout.LayoutParams layout= (LinearLayout.LayoutParams) mImg.getLayoutParams();
                        //缩小
                        if (end_line-start_line<-5){
                            layout.width= (int) (mImg.getWidth()*0.9);
                            layout.height= (int) (mImg.getHeight()*0.9);
                            mImg.setLayoutParams(layout);
                             start_line=end_line;
                        }else if (end_line-start_line>5){
                            layout.width= (int) (mImg.getWidth()*1.1);
                            layout.height= (int) (mImg.getHeight()*1.1);
                            mImg.setLayoutParams(layout);
                            start_line=end_line;
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }
}
