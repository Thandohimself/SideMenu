package com.example.thando.sidemenu;

import android.app.AlertDialog;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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










        final EditText etid_number = findViewById(R.id.idnumbertxt);
        final EditText etfirstname = findViewById(R.id.firstnametxt);
        final EditText etemailaddress = findViewById(R.id.emailaddresstxt);
        final EditText etcellnumber =findViewById(R.id.cellphoneNumbertxt);
        final EditText etpassword = findViewById(R.id.passwordtxt);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());
                final String password = etPassword.getText().toString();
                Toast.makeText(RegisterActivity.this, "You pressed", Toast.LENGTH_SHORT).show();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

    }
    public void logincheck(View view){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Register.this,Login.class);
        startActivity(I);
    }



    public void resetbtn(View view){
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        Intent I = new Intent(Register.this,ResetPassword.class);
        startActivity(I);
    }
}