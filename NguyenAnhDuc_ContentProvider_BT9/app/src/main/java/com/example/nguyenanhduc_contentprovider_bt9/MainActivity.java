package com.example.nguyenanhduc_contentprovider_bt9;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ContentResolver resolver;
    @SuppressLint({"Range", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ListView);
        if(checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},100);
        }
        resolver = getContentResolver();
        List<String> list= new ArrayList<>();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,
                new String[]{ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.Contacts._ID},
                null,null,null);
        while (cursor.moveToNext()){
            long id= cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor c =resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID+ "= ?",
                    new String[]{String.valueOf(id)},null);
            String phone="";
            while (c.moveToNext()){
                phone +=c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))+" ";
            }
            list.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    +"(" +phone+ ")");
        }
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showDetail(list.get(i));
            }
        });
    }

    private void showDetail(String detail) {
        Intent intent= new Intent(this,ChildActivity.class);
        intent.putExtra("name",detail);
        startActivity(intent);

    }
}