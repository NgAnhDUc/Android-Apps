package com.example.nguyenanhduc_sharereferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnXacnhan;
    EditText edtUsername,edtPassword;
    CheckBox cbReferences;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getSharedPreferences("dataLogin",MODE_PRIVATE);

        edtUsername.setText(sharedPreferences.getString("taikhoan",""));
        edtPassword.setText(sharedPreferences.getString("matkhau",""));
        cbReferences.setChecked(sharedPreferences.getBoolean("checked",false));
        Anhxa();
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String username= edtUsername.getText().toString().trim();
                    String password= edtPassword.getText().toString().trim();

                    if(username.equals("anhduc")&&password.equals("123")){
                        Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        if(cbReferences.isChecked()){
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("taikhoan",username);
                            editor.putString("matkhau",password);
                            editor.putBoolean("checked",true);
                            editor.commit();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Lỗi đăng nhập",Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }
    private void Anhxa() {
        btnXacnhan = (Button) findViewById(R.id.buttonDangnhap);
        edtUsername = (EditText) findViewById(R.id.editTextName);
        edtPassword = (EditText) findViewById(R.id.editTextPassword);
        cbReferences = (CheckBox) findViewById(R.id.checkBoxReferences);
    }

}