package com.example.nguyenanhduc_bt4_signinsignupprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPassword;
    Button btLogin;
    Button btSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Anhxa();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenProfile();
            }
        });
        btSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenSignin();
            }
        });
    }
    private void Anhxa(){
        edtUsername= (EditText)findViewById(R.id.edtUsername);
        edtPassword= (EditText)findViewById(R.id.edtPassword);
        btLogin= (Button) findViewById(R.id.btLogin);
        btSignin= (Button) findViewById(R.id.btSignin);
    }
    public void doOpenSignin(){
        Intent myIntent1=new Intent(LoginActivity.this, SigninActivity.class);
        startActivity(myIntent1);
    }
    public void doOpenProfile(){
        Intent myIntent2=new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(myIntent2);
    }

}