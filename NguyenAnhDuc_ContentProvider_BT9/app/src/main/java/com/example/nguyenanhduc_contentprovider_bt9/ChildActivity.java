package com.example.nguyenanhduc_contentprovider_bt9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends MainActivity{
    TextView textView;
    Button btback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        textView= findViewById(R.id.textViewDetail);
        btback = findViewById(R.id.buttonback);
        String name;
        name = getIntent().getStringExtra("name");
        textView.setText(name);
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
