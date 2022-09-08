package com.example.btlistview;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        TextView tvKetQua=(TextView)
                findViewById(R.id.KQtextView);
        Button btnBack= (Button)
                findViewById(R.id.btnBacktoMainActivity);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent =getIntent();
        String NoiDung= intent.getStringExtra("dulieu");
        tvKetQua.setText(NoiDung);
    }
}
