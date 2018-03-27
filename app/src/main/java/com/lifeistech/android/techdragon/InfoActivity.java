package com.lifeistech.android.techdragon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void back(View v){
        finish();
    }

    public void stageselect(View v){
        Intent intent = new Intent(this,stageselectActivity.class);
        startActivity(intent);
    }
}
