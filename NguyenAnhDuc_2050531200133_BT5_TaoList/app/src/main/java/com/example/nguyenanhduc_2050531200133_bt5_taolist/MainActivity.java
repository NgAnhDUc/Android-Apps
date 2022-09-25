package com.example.nguyenanhduc_2050531200133_bt5_taolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDoAn;
    ArrayList<DoAn> arrayDoAn;
    DoAnAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new DoAnAdapter(this,R.layout.dong_item,arrayDoAn);
        lvDoAn.setAdapter(adapter);
    }

    private void Anhxa() {
        lvDoAn= (ListView) findViewById(R.id.listviewDoAn);
        arrayDoAn = new ArrayList<>();

        arrayDoAn.add(new DoAn("Bơ xanh", "Bơ Việt Nam", R.drawable.pho, "6"));
        arrayDoAn.add(new DoAn("Bưởi chua", "Bưởi Việt Nam", R.drawable.nemran, "6"));
        arrayDoAn.add(new DoAn("Kiwi ngọt", "Kiwi Việt Nam", R.drawable.muchap, "6"));
        arrayDoAn.add(new DoAn("Táo đỏ", "Táo Việt Nam", R.drawable.goicuon, "6"));
        arrayDoAn.add(new DoAn("Xoài cát", "Xoài Việt Nam", R.drawable.banhxeo, "6"));

    }
}