package com.example.nguyenanhduc_ktck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends MenuActivity {
    TextView tvTen,tvMota,tvGia;
    ImageView imgHinh;
    ImageButton btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvTen=findViewById(R.id.tvTen);
        tvMota=findViewById(R.id.tvMota);
        tvGia=findViewById(R.id.tvGiatien);
        imgHinh=findViewById(R.id.ivHinh);
        btnBack=findViewById(R.id.btBack);

        Intent intent = getIntent();
        String Ten = intent.getStringExtra("name");
        String Mota = intent.getStringExtra("detail");
        int Hinh = intent.getIntExtra("Img",0);
        int Money = intent.getIntExtra("Money",0);
        tvTen.setText(Ten);
        tvMota.setText(Mota);
        imgHinh.setImageResource(Hinh);
        tvGia.setText(String.valueOf(Money));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}