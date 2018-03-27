package com.lifeistech.android.techdragon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class clearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);
    }

    public void titleback(View v) {
        Intent intent = new Intent(this,OpActivity.class);
        startActivity(intent);
    }

    public void stageselect(View v) {
        Intent intent = new Intent(this,stageselectActivity.class);
        startActivity(intent);
    }
}
