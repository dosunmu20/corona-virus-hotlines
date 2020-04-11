package com.example.coronavirushelplines;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class Hotlines extends AppCompatActivity {

    @BindView(R.id.hotlineRegion)
    AppCompatTextView region;

    @BindView(R.id.hotlineState)
    AppCompatTextView hotlineState;

    @BindView(R.id.statehotline1)
    AppCompatTextView  stateHotlineOne;

    @BindView(R.id.statehotline2)
    AppCompatTextView  stateHotlineTwo;

    @BindView(R.id.emergencyNumber)
    LinearLayout generalTollNumber;

    @BindString(R.string.toll_free_line)
    String tollFreeLine;

    @BindView(R.id.backArrow)
    AppCompatImageView backArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotlines);

//        region = findViewById(R.id.hotlineRegion);

        ButterKnife.bind(this);
        fetchIntentData();

        stateHotlineTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCall(stateHotlineTwo.getText().toString());
            }
        });

        stateHotlineOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCall(stateHotlineOne.getText().toString());
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        generalTollNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCall(tollFreeLine);
            }
        });

    }


    public void fetchIntentData (){
        String strRegion = getIntent().getStringExtra("region") ;
        String strState = getIntent().getStringExtra("state")  + " State";
        String strHotlineOne = getIntent().getStringExtra("hotlineOne");
        String strHotlineTwo = getIntent().getStringExtra("hotlineTwo");

        Toast.makeText(this, strState, Toast.LENGTH_LONG).show();




        setIntentData(region, strRegion);
        setIntentData(hotlineState, strState);
        setIntentData( stateHotlineOne, strHotlineOne);
        setIntentData( stateHotlineTwo, strHotlineTwo);

    }

    public void setIntentData (AppCompatTextView textView, String string){
        if (string != null ) {
            if (!string.equals(""))
                textView.setText(string);
            else textView.setText(R.string.toll_free_line);
        }
    }
    public void initCall(String hotline){
//        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
//        dialIntent.setData(Uri.parse("tel:" + hotline));
//
//
//        if (ActivityCompat.checkSelfPermission(this,
//                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//        startActivity(dialIntent);


            if (Build.VERSION.SDK_INT >= 23 ){

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 101);

                    return;
                }
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + hotline));
                startActivity(callIntent);
            } else {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + hotline));
                startActivity(callIntent);
            }

    }


//    @OnClick(R.id.backArrow) void backPressed(){onBackPressed();}
//
//    @OnClick(R.id.statehotline1)
//    public void callFirstHotline(){initCall(stateHotlineOne.getText().toString().trim());}
//
//    @OnClick (R.id.statehotline2)
//    public void callSecondNumber(){initCall(stateHotlineTwo.getText().toString().trim());}
//
////    @OnClick (R.id.emergencyNumber)
////    public void callGeneralTollNumber(){initCall(tollFreeLine.trim());}
}
