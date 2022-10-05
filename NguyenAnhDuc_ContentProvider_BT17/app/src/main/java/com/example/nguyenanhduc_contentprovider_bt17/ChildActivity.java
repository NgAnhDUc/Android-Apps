package com.example.nguyenanhduc_contentprovider_bt17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        textView= findViewById(R.id.textViewDetail);
        String name;
        name = getIntent().getStringExtra("name");
        textView.setText(name);
    }
}