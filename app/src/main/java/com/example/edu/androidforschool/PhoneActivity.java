package com.example.edu.androidforschool;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.edu.androidforschool.adapter.PhoneAdapter;
import com.example.edu.androidforschool.bean.PhoneInfo;
import com.example.edu.androidforschool.bean.PhoneKind;
import com.example.edu.androidforschool.dao.PeopleDao;
import com.example.edu.androidforschool.helper.SQLHelper;
import com.example.edu.androidforschool.phone.ShowAllPhoneActivity;
import com.example.edu.androidforschool.phone.UpdatePhoneActivity;

import java.util.ArrayList;
import java.util.List;

public class PhoneActivity extends AppCompatActivity {
    private SQLHelper helper;
    private SQLiteDatabase db;
    private ExpandableListView mExpandableListView;
    private List<PhoneInfo> infoList = new ArrayList<>();
    private List<PhoneKind> kindList = new ArrayList<>();
    private PhoneAdapter adapter;
    private EditText mPleaseInputNameOrPhone;
    private Button  mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        helper = new SQLHelper(this, "song.db", null, 1);
        db = helper.getReadableDatabase();
        initWidgets();
        initDatas();//初始化数据
        adapter = new PhoneAdapter(kindList, infoList, this);
        mExpandableListView.setAdapter(adapter);

        /**
         * 搜索信息
         */
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=mPleaseInputNameOrPhone.getText().toString().trim();
                 if (TextUtils.isEmpty(content)){
                      Intent intent=new Intent(PhoneActivity.this, ShowAllPhoneActivity.class);
                       intent.putExtra("key","null");
                      startActivity(intent);
                }else {
                     Intent intent=new Intent(PhoneActivity.this, ShowAllPhoneActivity.class);
                     intent.putExtra("key","notnull");
                     intent.putExtra("content",mPleaseInputNameOrPhone.getText().toString().trim());
                     startActivity(intent);
                 }
            }
        });
    }

    private void initDatas() {

        kindList=PeopleDao.selectKind(db);
        for (int i = 0; i < kindList.size(); i++) {
            infoList=PeopleDao.selectInfo(db,kindList.get(i));
            kindList.get(i).setInfo(infoList);
        }

    }

    private void initWidgets() {
        mExpandableListView = (ExpandableListView) findViewById(R.id.expandablelistview);
        mPleaseInputNameOrPhone= (EditText) findViewById(R.id.please_input_nameOrphone);
        mSearch = (Button) findViewById(R.id.search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //四个参数的含义。1，group的id,2,item的id,3,是否排序，4，将要显示的内容
        menu.add(0, 1, 0, "添加新号码");
        menu.add(0, 2, 0, "退出");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent=new Intent(PhoneActivity.this,UpdatePhoneActivity.class);
                startActivity(intent);
                finish();
                break;
            case 2:
               finish();
                break;

        }
        return true;
    }

}
