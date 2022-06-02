package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username  = findViewById(R.id.uid);
        password  = findViewById(R.id.pwd);

    }

    public void logIn(View v){
        Bundle b = getIntent().getExtras();
        String uname  = b.getString("uid");
        String pass  = b.getString("passwordd");
        if(username.getText().toString().equals(uname) && password.getText().toString().equals(pass))
        {
            Intent i = new Intent(this, Success.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Error!!!", Toast.LENGTH_LONG).show();
        }

    }
}