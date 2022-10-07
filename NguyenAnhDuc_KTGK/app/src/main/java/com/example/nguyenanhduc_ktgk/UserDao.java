package com.example.nguyenanhduc_ktgk;

import java.util.ArrayList;

public class UserDao extends LoginActivity {

    public int SearchArray(String name, String pass, ArrayList<User> arrayUser){
        int n = arrayUser.size();
        int number = -100;
        String nametemp,passtemp;
        for(int i=n-1; i>=0 ; i--){
            nametemp =arrayUser.get(i).getUsername();
            passtemp =arrayUser.get(i).getPassword();
            if(nametemp.equals(name)==true && passtemp.equals(pass)==true)
                number=1;
        }
        return number;
    }

    public int SearchUsername(String name,ArrayList<User> arrayUser){
        int n = arrayUser.size();
        int number = -100;
        String nametemp;
        for(int i=n-1; i>=0 ; i--){
            nametemp =arrayUser.get(i).getUsername();
            if(nametemp.equals(name)==true)
                number=1;
        }
        return number;
    }

}
