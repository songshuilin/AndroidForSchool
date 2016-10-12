package com.example.edu.androidforschool.phone;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.edu.androidforschool.R;
import com.example.edu.androidforschool.adapter.ShowAllPhoneAdapter;
import com.example.edu.androidforschool.bean.PhoneInfo;
import com.example.edu.androidforschool.bean.PhoneKind;
import com.example.edu.androidforschool.dao.PeopleDao;
import com.example.edu.androidforschool.helper.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class ShowAllPhoneActivity extends AppCompatActivity {
    private ListView mLv;
    private List<PhoneInfo>infoList;
    private ShowAllPhoneAdapter phoneAdapter;
    private SQLHelper helper;
    private SQLiteDatabase db;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_phone);
        initWidgets();
        helper = new SQLHelper(this, "song.db", null, 1);
        db = helper.getReadableDatabase();
        intent=getIntent();
        String key=intent.getStringExtra("key");

        if (key.equals("null")){
            infoList= PeopleDao.selectInfoAll(db);
        }else if (key.equals("notnull")){
            String content=intent.getStringExtra("content");
            infoList=PeopleDao.selectInfoAllFromNameOrPhone(db,content);
        }
        phoneAdapter=new ShowAllPhoneAdapter(infoList,this);
        mLv.setAdapter(phoneAdapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
                intent.setType("vnd.android.cursor.item/person");
                intent.setType("vnd.android.cursor.item/contact");
                intent.setType("vnd.android.cursor.item/raw_contact");
                intent.putExtra(android.provider.ContactsContract.Intents.Insert.NAME, infoList.get(position).getName());
                intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE, infoList.get(position).getPhone());
                intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE_TYPE, 3);
                startActivity(intent);
            }
        });
    }

    private void initWidgets() {
        mLv= (ListView) findViewById(R.id.listview);
    }
}
