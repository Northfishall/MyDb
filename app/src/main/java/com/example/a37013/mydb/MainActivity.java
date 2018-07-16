package com.example.a37013.mydb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import db.PersonSqliteHelper;

public class MainActivity extends AppCompatActivity {
    private static String[] names = {"功能1","功能2","功能3","功能4"};
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDB();
        lv = findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this,R.layout.list_item,R.id.tv,names));

    }
    private void createDB()
    {
        PersonSqliteHelper helper = new PersonSqliteHelper(this);
        helper.getWritableDatabase();
        msgToast(this,"数据库创建成功");
    }

    private void msgToast(MainActivity context, String text) {
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
}
