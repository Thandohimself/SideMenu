package com.example.thando.sidemenu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Register extends AppCompatActivity {
EditText id_number;
EditText firstname;
EditText emailaddress;
EditText cellnumber;
EditText password;
Button createaccount;
private static final String REGISTER_URL = "https://barcodescanner.000webhostapp.com/UserRegistration/register.php"; //add url here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        id_number = findViewById(R.id.idnumbertxt);
        firstname = findViewById(R.id.firstnametxt);
        emailaddress = findViewById(R.id.emailaddresstxt);
        cellnumber =findViewById(R.id.cellphoneNumbertxt);
        password = findViewById(R.id.passwordtxt);

    }
    public void logincheck(View view){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Register.this,Login.class);
        startActivity(I);
    }  public void createAccount(View view){

        String id = id_number.getText().toString().trim().toLowerCase();
        String name = firstname.getText().toString().trim().toLowerCase();
        String email = emailaddress.getText().toString().trim().toLowerCase();
        String passw = password.getText().toString().trim().toLowerCase();
        String cell = cellnumber.getText().toString().trim().toLowerCase();
        register(id,name,email,cell,passw);

        /*Toast.makeText(this, "Account Created\nLogin To Continue", Toast.LENGTH_LONG).show();
        Intent I = new Intent(Register.this,Login.class);
        startActivity(I);*/
    }

    public void register(String id, String name, String email, String cell, String passw) {
        String urlSuffix="?username="+id+"&password="+passw+"&email="+email+"&name="+name+"&cellnumber="+cell;
        class RegisterUser extends AsyncTask<String,Void,String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading=ProgressDialog.show(Register.this,"Please Wait",null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(Register.this, "Please Check your Internet Connection", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected String doInBackground(String... strings) {
                String s = strings[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String results;
                    results = bufferedReader.readLine();
                    return results;


                }catch (Exception e){
                    return null;
                }

            }


        }
        RegisterUser ur = new RegisterUser();
        ur.execute(urlSuffix);
    }

    public void resetbtn(View view){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Register.this,ResetPassword.class);
        startActivity(I);
    }
}