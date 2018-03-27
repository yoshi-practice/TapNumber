package com.lifeistech.android.techdragon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);
        Toast.makeText(this, "WELCOME TO TAPMENTERS!!", Toast.LENGTH_SHORT).show();
    }

    public void start(View v) {
        Intent intent = new Intent(this,stageselectActivity.class);
        startActivity(intent);
    }

    public void info(View v) {
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
    }

}

