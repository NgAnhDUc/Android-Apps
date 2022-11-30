package com.example.nguyenanhduc_bkt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail extends MainActivity {

    TextView tvten,tvmota;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnback =(Button) findViewById(R.id.btnBackTacpham);
        tvten = findViewById(R.id.tvTenTacPham);
        tvmota = findViewById(R.id.tvMotaTacPham);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();

        String ten = intent.getStringExtra("ten");
        String mota = intent.getStringExtra("mota");

        tvten.setText(ten);
        tvmota.setText(mota);
    }
}