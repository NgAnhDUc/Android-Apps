package com.example.btlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lvMonhoc;
    ArrayList<String> arrayCourse;
    Button btnThem;
    EditText edtMonHoc;
    Button btnSua;
    Button btnXoa;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonhoc =(ListView) findViewById(R.id.ListView);
        btnThem=(Button) findViewById(R.id.Thembutton);
        edtMonHoc=(EditText) findViewById((R.id.editTextMonHoc));
        btnSua=(Button) findViewById(R.id.Suabutton);
        btnXoa=(Button) findViewById(R.id.Xoabutton);

        arrayCourse=new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("Java");
        arrayCourse.add("C++");
        arrayCourse.add("PHP");
        arrayCourse.add("Web");
        ArrayAdapter adapter =new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,arrayCourse);
        lvMonhoc.setAdapter(adapter);
        lvMonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,arrayCourse.get(i),Toast.LENGTH_SHORT).show();
            }
        });
        lvMonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Long Click:" + i,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MonHoc = edtMonHoc.getText().toString();
                arrayCourse.add(MonHoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(arrayCourse.get(i));
                vitri=i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri,edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri=i;
                doOpenChildActivity();
                return false;
            }
        });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(this, ChildActivity.class);
        edtMonHoc.setText(arrayCourse.get(vitri));
        myIntent.putExtra("dulieu",""+edtMonHoc.getText());
        startActivity(myIntent);
    }
}s