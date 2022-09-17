package com.example.nguyenanhduc_bt4_signinsignupprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername;
    EditText edtPassword;
    Button btLogin;
    Button btSignin;
    ArrayList<User> arrayUser;
    String pass;
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
        addUser();
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

        String name = edtUsername.getText().toString();
        String pass = edtPassword.getText().toString();
        Intent myIntent2=new Intent(LoginActivity.this, ProfileActivity.class);
        UserDao userDao = new UserDao();
        int number = userDao.SearchArray(name,pass,arrayUser);
            if(number==1){
                Toast.makeText(this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                startActivity(myIntent2);
            }else {
                Toast.makeText(this,"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
            }
    }
    public void addUser(){
        Toast.makeText(this,"Add",Toast.LENGTH_SHORT).show();
        arrayUser= new ArrayList<>();
        arrayUser.add(new User("Duc","1234","duc@gmail.com"));
        arrayUser.add(new User("Dung","1234","dung@gmail.com"));
        arrayUser.add(new User("Dat","1234","dat@gmail.com"));
    }
}