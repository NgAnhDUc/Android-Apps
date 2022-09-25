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
    private void Anhxa(){
        lvDoAn= (ListView) findViewById(R.id.listviewDoAn);
        arrayDoAn = new ArrayList<>();

        arrayDoAn.add(new DoAn("Phở bò", "Phở bò Hà Nội", R.drawable.pho, 6));
        arrayDoAn.add(new DoAn("Nem rán", "Nem rán Hà Nội", R.drawable.nemran, 6));
        arrayDoAn.add(new DoAn("Mực hấp", "Mực ống hấp rau củ", R.drawable.muchap, 6));
        arrayDoAn.add(new DoAn("Gỏi cuốn", "Gỏi cuốn tôm thịt", R.drawable.goicuon, 6));
        arrayDoAn.add(new DoAn("Bánh xèo", "Bánh xèo miền trung", R.drawable.banhxeo, 6));

    }
}