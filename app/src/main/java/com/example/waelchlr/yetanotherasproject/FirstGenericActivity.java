package com.example.waelchlr.yetanotherasproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class FirstGenericActivity extends AppCompatActivity {

    //required to use openCV Library
    static {System.loadLibrary("opencv_java3");}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_generic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //image four button listener
    public void imageFourListener(View v){
        Context newContext=this.getApplicationContext();
        MatchMaker m=new MatchMaker();
        String buildingName=m.attemptMatch(newContext, R.raw.testimagefour);
        displayMatchResult(buildingName);
    }

    public void displayMatchResult(String buildingName){
        Context newContext=this.getApplicationContext();
        CharSequence text ="Best match is "+buildingName;
        Toast toast=Toast.makeText(newContext, text, Toast.LENGTH_SHORT);
        toast.show();
    }

}