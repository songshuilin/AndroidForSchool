package com.example.edu.androidforschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.edu.androidforschool.go.FindLoadActivity;
import com.example.edu.androidforschool.go.FindPositionActivity;
import com.example.edu.androidforschool.go.PositionActivity;

public class GoActivity extends AppCompatActivity implements View.OnClickListener{
  private Button btn_position,btn_findposition,back,btn_findload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        initWidgets();
        getSupportActionBar().hide();
    }

    private void initWidgets() {
        back= (Button) findViewById(R.id.back);
        btn_findload= (Button) findViewById(R.id.btn_findload);
        btn_findposition= (Button) findViewById(R.id.btn_findposition);
        btn_position= (Button) findViewById(R.id.btn_position);
        btn_findposition.setOnClickListener(this);
        btn_position.setOnClickListener(this);
        btn_findload.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
           Intent intent=null;
        switch (v.getId()){
            case R.id.btn_position:
                intent=new Intent(this, PositionActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_findload:
                 intent=new Intent(this, FindLoadActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_findposition:
                intent=new Intent(this, FindPositionActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;

        }
    }
}
