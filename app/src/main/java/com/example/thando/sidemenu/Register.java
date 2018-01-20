package com.example.thando.sidemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void logincheck(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Register.this,Login.class);
        startActivity(I);
    }  public void createAccount(View view){

        Toast.makeText(this, "Account Created\nLogin To Continue", Toast.LENGTH_LONG).show();
        Intent I = new Intent(Register.this,Login.class);
        startActivity(I);
    }public void resetbtn(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Register.this,ResetPassword.class);
        startActivity(I);
    }
}