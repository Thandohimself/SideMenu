package com.example.thando.sidemenu;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class ResetPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
    }
    public void logincheck(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(ResetPassword.this,Login.class);
        startActivity(I);
    }  public void createAccount(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(ResetPassword.this,Register.class);
        startActivity(I);
    }public void resetbtn(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(ResetPassword.this,Register.class);
        startActivity(I);
    }
}