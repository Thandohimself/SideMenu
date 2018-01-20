package com.example.thando.sidemenu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Typeface myfont;
    private TextView usernametxt;
    private TextView createAccount;
    private Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernametxt = findViewById(R.id.loginusernametxt);
        loginbtn = findViewById(R.id.login_loginbtn);

        myfont = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeue.ttc");
        usernametxt.setTypeface(myfont);



    }
    public void loginchecks(View view){

        Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Login.this,MainActivity.class);
        startActivity(I);


               // Intent I = new Intent(Login.this,MainActivity.class);
                //startActivity(I);

    }    public void createAccount(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Login.this,Register.class);
        startActivity(I);


               // Intent I = new Intent(Login.this,MainActivity.class);
                //startActivity(I);

    } public void resetpassword(View view){

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Login.this,ResetPassword.class);
        startActivity(I);


               // Intent I = new Intent(Login.this,MainActivity.class);
                //startActivity(I);

    }
}