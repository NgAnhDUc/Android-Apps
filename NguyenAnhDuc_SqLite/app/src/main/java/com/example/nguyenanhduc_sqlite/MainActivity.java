package com.example.nguyenanhduc_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText idEdt,nameEdt,priceEdt;
    Button insertBtn,updateBtn,deleteBtn,queryBtn;
    ListView listView;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;
    SQLiteDatabase mydatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idEdt = findViewById(R.id.id_edt);
        nameEdt = findViewById(R.id.name_edt);
        priceEdt = findViewById(R.id.price_edt);
        insertBtn = findViewById(R.id.insert_button);
        updateBtn = findViewById(R.id.update_button);
        deleteBtn = findViewById(R.id.delete_button);
        queryBtn = findViewById(R.id.query_button);

        listView = findViewById(R.id.list_view);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myList);
        listView.setAdapter(myAdapter);
        //SQLITE DATABASE
        mydatabase =openOrCreateDatabase("qlmaytinh.db",MODE_PRIVATE,null);
        //CREATE TABLE
        try {
            String sql = "CREATE TABLE tblmaytinh(mamaytinh TEXT primary key,tenmaytinh TEXT,gia INTEGER)";
            mydatabase.execSQL(sql);

        }
        catch (Exception e){
            Log.e("Error","Table da ton tai");
        }
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mamaytinh = idEdt.getText().toString();
                String tenmaytinh = nameEdt.getText().toString();
                int gia =Integer.parseInt(priceEdt.getText().toString());
                ContentValues values = new ContentValues();
                values.put("mamaytinh",mamaytinh);
                values.put("tenmaytinh",tenmaytinh);
                values.put("gia",gia);
                String msg = "";
                if (mydatabase.insert("tblmaytinh",null,values)== -1){
                    msg = "Fail to Insert Record!";
                }else {
                    msg = "Insert record Successfully";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mamaytinh = idEdt.getText().toString();
                int n = mydatabase.delete("tblmaytinh","mamaytinh = ?",new String[]{mamaytinh});
                String msg = "";
                if (n ==0){
                    msg = "Fail to Delete Record!";
                }else {
                    msg = "Delete record Successfully";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gia =Integer.parseInt(priceEdt.getText().toString());
                String mamaytinh = idEdt.getText().toString();
                ContentValues myvalue = new ContentValues();
                myvalue.put("gia",gia);
                int n = mydatabase.delete("tblmaytinh","mamaytinh = ?",new String[]{mamaytinh});
                String msg = "";
                if (n ==0){
                    msg = "Fail to Update Record!";
                }else {
                    msg = "Update record Successfully";
                }
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.clear();
                Cursor c = mydatabase.query("tblmaytinh",null,null,null,null,null,null);
                c.moveToNext();
                String data = "";
                while (c.isAfterLast()==false){
                    data = c.getString(0)+" - "+c.getString(1)+" - "+c.getString(2);
                    c.moveToNext();
                    myList.add(data);
                }
                c.close();
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}