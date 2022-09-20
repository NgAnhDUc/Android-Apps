package com.example.nguyenanhduc_listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraicay;
    ArrayList<TraiCay> arrayTraicay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,arrayTraicay);
        lvTraicay.setAdapter(adapter);
    }

    private void Anhxa() {
        lvTraicay= (ListView) findViewById(R.id.listviewTraicay);
        arrayTraicay = new ArrayList<>();

        arrayTraicay.add(new TraiCay("Bơ xanh", "Bơ Việt Nam", R.drawable.bo));
        arrayTraicay.add(new TraiCay("Bưởi chua", "Bưởi Việt Nam", R.drawable.buoi));
        arrayTraicay.add(new TraiCay("Kiwi ngọt", "Kiwi Việt Nam", R.drawable.kiwi));
        arrayTraicay.add(new TraiCay("Táo đỏ", "Táo Việt Nam", R.drawable.tao));
        arrayTraicay.add(new TraiCay("Xoài cát", "Xoài Việt Nam", R.drawable.xoai));

    }
}