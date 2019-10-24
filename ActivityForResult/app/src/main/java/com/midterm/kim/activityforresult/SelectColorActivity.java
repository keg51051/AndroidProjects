package com.midterm.kim.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SelectColorActivity extends AppCompatActivity {
    private String color = "#ff0000";
    Intent selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_color);
        setTitle("Select Color Activity");

        RadioGroup colors = (RadioGroup) findViewById(R.id.radioGroupColors);

        Button ok = (Button) findViewById(R.id.button2);

        selectedColor = new Intent();

        colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbRed:
                        color = "#ff0000";
                        break;
                    case R.id.rdbBlue:
                        color = "#0000ff";
                        break;
                    case R.id.rdbYellow:
                        color = "#ffff00";
                        break;
                    case R.id.rdbBlack:
                        color = "#000000";
                        break;
                    case R.id.rdbGreen:
                        color = "#00ff00";
                        break;
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor.putExtra("selectedColor", color);
                setResult(RESULT_OK, selectedColor);
                finish();
            }
        });
    }
}
