package com.example.nguyenanhduc_bt4_signinsignupprofile;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class SigninActivity extends LoginActivity {
    Button btnBack;
    Button btnRegister;
    EditText edtUsername;
    EditText edtPassword;
    EditText edtEmail;
    EditText edtRepeatPw;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        Anhxa();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    private void Anhxa(){
        btnBack     = (Button) findViewById(R.id.btLogin2);
        btnRegister = (Button) findViewById(R.id.btRegister);
        edtUsername = (EditText) findViewById(R.id.edtUsername2);
        edtEmail = (EditText) findViewById(R.id.edtEmail2);
        edtPassword = (EditText) findViewById(R.id.edtPassword2);
        edtRepeatPw = (EditText) findViewById(R.id.edtRepeatPw2);
    }
    private void Register(){
        int checkUsername= CheckUsername();
        int checkEmail= CheckEmail();
        int checkPassword = CheckPassword();
        if(checkUsername ==1 && checkEmail ==1 && checkPassword ==1){
            String name= edtUsername.getText().toString();
            String pass= edtPassword.getText().toString();
            String email= edtEmail.getText().toString();
            arrayUser.add(new User(""+name,""+pass,""+email));
            Toast.makeText(this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    private int CheckUsername(){
        String name;
        name= edtUsername.getText().toString();
        UserDao userDao= new UserDao();
        int number= userDao.SearchUsername(name,arrayUser);
        if (name.equals("")==true){
            Toast.makeText(this,"Vui lòng nhập tên đăng kí",Toast.LENGTH_SHORT).show();
            return -100;
        }
        if(number==1){
            Toast.makeText(this,"Tên tài khoản đã được sử dụng",Toast.LENGTH_SHORT).show();
            return -100;
        }
        return 1;
    }
    private int CheckEmail(){
        String email;
        email = edtEmail.getText().toString();
        if(email.equals("")==true){
            Toast.makeText(this,"Vui lòng nhập email",Toast.LENGTH_SHORT).show();
            return -100;
        }
        return 1;
    }
    private int CheckPassword(){
        String pass,rppass;
        pass = edtPassword.getText().toString();
        rppass = edtRepeatPw.getText().toString();
        if(pass.equals("")==true){
            Toast.makeText(this,"Vui lòng nhập mật khẩu",Toast.LENGTH_SHORT).show();
            return -100;
        }
        if(rppass.equals("")==true){
            Toast.makeText(this,"Vui lòng nhập lại mật khẩu",Toast.LENGTH_SHORT).show();
            return -100;
        }
        if(pass.equals(rppass)==false){
            Toast.makeText(this,"Vui lòng nhập lại mật khẩu",Toast.LENGTH_SHORT).show();
            return -100;
        }
        return 1;
    }
}
