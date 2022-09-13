package com.example.nguyenanhduc_bt4_signinsignupprofile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends LoginActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button btnBack= (Button)
                findViewById(R.id.btBacktoLogin);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
