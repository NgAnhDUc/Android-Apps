package com.example.nguyenanhduc_bkt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvtacgia;
    ArrayList<Tacgia>arrayTacgia;
    TacgiaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvtacgia = findViewById(R.id.lvTacgia);
        arrayTacgia = new ArrayList<>();

        arrayTacgia.add(new Tacgia("Huy Cận", "Cù Huy Cận (1919 – 2005)", R.drawable.huycan,5));
        arrayTacgia.add(new Tacgia("Nam Cao", "Nam Cao (1915 - 1951)", R.drawable.namcao,4));
        arrayTacgia.add(new Tacgia("Tố Hữu", "Nguyễn Kim Thành(1920 - 2002)", R.drawable.tohuu,3));
        arrayTacgia.add(new Tacgia("Mạc Ngôn", "Mạc Ngôn (sinh ngày 17 tháng 2 năm 1955)", R.drawable.macngon,2));
        arrayTacgia.add(new Tacgia("Hermingway", "Ernest Miller Hemingway (1899 – 1961)", R.drawable.hermingway,3));

        adapter = new TacgiaAdapter(this,R.layout.dongitem1,arrayTacgia);
        lvtacgia.setAdapter(adapter);

        lvtacgia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(MainActivity.this,HuyCanActivity.class);
                    startActivity(intent);
                }
                if(i == 1){
                    Intent intent2 = new Intent(MainActivity.this,NamCaoActivity.class);
                    startActivity(intent2);
                }
                if(i == 2){
                    Intent intent2 = new Intent(MainActivity.this,MacNgonActivity.class);
                    startActivity(intent2);
                }
                if(i == 3){

                }
                if(i == 4){

                }
            }
        });
    }
}