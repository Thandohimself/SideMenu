package com.example.thando.sidemenu;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private DrawerLayout mDrawerlayout;
private ActionBarDrawerToggle mToggle;
CardView cardview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mDrawerlayout = findViewById(R.id.drawer);
       mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close);
       mDrawerlayout.addDrawerListener(mToggle);
       mToggle.syncState();
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // cardview = findViewById(R.id.addbtn1);
      ///  ImageButton imgbtn = findViewById(R.id.imgbtn);

      //  cardview.setOnClickListener(this);
     //   imgbtn.setOnClickListener(this);

        Log.i("testing","Working1");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
public  void btnclick(View view){

    Intent i = new Intent(MainActivity.this, scanbarcode.class);

}
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addnew){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
            Intent i = new Intent(MainActivity.this, scanbarcode.class);
            // Intent i = new Intent(this,addbarcode.class);

        }




        Log.i("testing","Working2");

    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if(scanningResult != null){
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
           // formatTxt.setText("FORMAT: "+ scanFormat);
            //conentTxt.setText("CONTENT: "+ scanContent);
            //displayTxt.setText(""+scanningResult);
            Toast.makeText(this,"FORMAT: "+ scanningResult+"\n CONTENT: "+scanContent,Toast.LENGTH_SHORT).show();

            Toast.makeText(this,"FORMAT: "+ scanFormat+"\n CONTENT: "+scanContent,Toast.LENGTH_SHORT).show();

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}