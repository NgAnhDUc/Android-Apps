package com.example.nguyenanhduc_bt4_signinsignupprofile;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
public class SigninActivity extends LoginActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Button btnBack= (Button)
                findViewById(R.id.btLogin2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

}
