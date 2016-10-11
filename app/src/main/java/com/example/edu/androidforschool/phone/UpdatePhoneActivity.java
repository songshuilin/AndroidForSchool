package com.example.edu.androidforschool.phone;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edu.androidforschool.PhoneActivity;
import com.example.edu.androidforschool.R;
import com.example.edu.androidforschool.bean.PhoneInfo;
import com.example.edu.androidforschool.bean.PhoneKind;
import com.example.edu.androidforschool.dao.PeopleDao;
import com.example.edu.androidforschool.helper.SQLHelper;

import java.util.List;

public class UpdatePhoneActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etname, etkind, etphone;
    private SQLHelper helper;
    private SQLiteDatabase db;
    private Button mBtnOk, mBtnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_phone);
        helper = new SQLHelper(this, "song.db", null, 1);
        db = helper.getReadableDatabase();
        initWidgets();
        getSupportActionBar().hide();


    }

    private void initWidgets() {
        etname = (EditText) findViewById(R.id.name);
        etkind = (EditText) findViewById(R.id.kind);
        etphone = (EditText) findViewById(R.id.phone);
        mBtnOk = (Button) findViewById(R.id.btn_ok);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(this);
        mBtnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                String phone = etphone.getText().toString().trim();
                String name = etname.getText().toString().trim();
                String kind = etkind.getText().toString().trim();
                if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(name)||TextUtils.isEmpty(kind)){
                    Toast.makeText(UpdatePhoneActivity.this,"有空啦，插入失败",Toast.LENGTH_SHORT).show();
                    return;
                }


                PhoneInfo info = new PhoneInfo();
                info.setName(name);
                info.setPhone(phone);
                PhoneKind kindall = new PhoneKind();
                kindall.setKind(kind);
                List<PhoneInfo> listinfo=PeopleDao.selectInfoForPhone(db,info);
                if (!listinfo.isEmpty()){
                    Toast.makeText(UpdatePhoneActivity.this,"电话已存在，插入失败",Toast.LENGTH_SHORT).show();
                    return;
                }

                PeopleDao.insert(kindall, info, db);
                Intent intent=new Intent(UpdatePhoneActivity.this,PhoneActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_reset:
                etkind.setText("");
                etname.setText("");
                etphone.setText("");
                break;
        }
    }
}
