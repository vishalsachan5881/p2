package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.uid);
        password = findViewById(R.id.pwd);

    }
    public void signUp (View v){
        if(password.getText().toString().length() >= 8 && validatepassword(password.getText().toString()))
        {
            Toast.makeText(this, "SignUp Succesfull", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this,MainActivity2.class);
            Bundle b = new Bundle();
            b.putString("uid",username.getText().toString());
            b.putString("passwordd",password.getText().toString());
            i.putExtras(b);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Password is not satisfying", Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatepassword(String password){
        Pattern ptrn;
        Matcher mat;
        String passwordpattern = "^(?=.*[A-z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()])(?=\\S+$).{8,}$";
        ptrn = Pattern.compile(passwordpattern);
        mat = ptrn.matcher(password);
        return mat.matches();

    }
}