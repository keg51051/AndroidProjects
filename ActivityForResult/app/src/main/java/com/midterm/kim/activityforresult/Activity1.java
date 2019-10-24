package com.midterm.kim.activityforresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity1 extends AppCompatActivity {
    private static final int COLOR_SELECTOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void onSelect(View view) {
        Intent myintent = new Intent(Activity1.this, SelectColorActivity.class);

        startActivityForResult(myintent, COLOR_SELECTOR);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case COLOR_SELECTOR:
                if (resultCode == RESULT_OK) {
                    String color = data.getExtras().getString("selectedColor");
                    findViewById(R.id.colorBox).setBackgroundColor(Color.parseColor(color));
                }
        }
    }
}
