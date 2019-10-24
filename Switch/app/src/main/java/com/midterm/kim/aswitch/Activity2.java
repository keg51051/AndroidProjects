package com.midterm.kim.aswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        this.setTitle("Activity2");
    }

    public void onClick(View view) {
        finish();
    }
}
