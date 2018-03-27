package com.lifeistech.android.techdragon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class stageselectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stageselect);
    }

    public void stage1(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 1);
        startActivity(intent);
    }

    public void stage2(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 2);
        startActivity(intent);
    }

    public void stage3(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 3);
        startActivity(intent);
    }

    public void stage4(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 4);
        startActivity(intent);
    }

    public void stage5(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 5);
        startActivity(intent);
    }

    public void stage6(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 6);
        startActivity(intent);
    }

    public void stage7(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 7);
        startActivity(intent);
    }
    public void stage8(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 8);
        startActivity(intent);
    }
    public void stage9(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 9);
        startActivity(intent);
    }
    public void stage10(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 10);
        startActivity(intent);
    }
    public void stage11(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 11);
        startActivity(intent);
    }
    public void stage12(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 12);
        startActivity(intent);
    }
    public void stage13(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 13);
        startActivity(intent);
    }
    public void stage14(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 14);
        startActivity(intent);
    }
    public void stage15(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 15);
        startActivity(intent);
    }
    public void stage16(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 16);
        startActivity(intent);
    }
    public void stage17(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("stage", 17);
        startActivity(intent);
    }

}

