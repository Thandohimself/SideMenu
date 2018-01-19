package com.example.thando.sidemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class scanbarcode extends AppCompatActivity implements View.OnClickListener {


    private ImageButton scanBtn;
    private CardView addnew;
    private TextView formatTxt,conentTxt,displayTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanbarcode);


        //scanBtn = (Button)findViewById(R.id.scan_button);
        scanBtn = findViewById(R.id.scan_button2);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        conentTxt = (TextView)findViewById(R.id.scan_content);
        displayTxt = (TextView)findViewById(R.id.scan_display);

        scanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.scan_button2){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if(scanningResult != null){
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: "+ scanFormat);
            conentTxt.setText("CONTENT: "+ scanContent);
            displayTxt.setText(""+scanningResult);
            Toast.makeText(this,"FORMAT: "+ scanningResult+"\n CONTENT: "+scanContent,Toast.LENGTH_SHORT).show();

            Toast.makeText(this,"FORMAT: "+ scanFormat+"\n CONTENT: "+scanContent,Toast.LENGTH_SHORT).show();

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    }





