package com.example.khs.radiobutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgroup;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgroup = (RadioGroup) findViewById(R.id.radiogroup1);
        txt = (TextView) findViewById(R.id.TextView);

        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) rgroup.findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radioButton:
                        txt.setTextColor(Color.RED);
                        break;
                    case R.id.radioButton2:
                        txt.setTextColor(Color.GREEN);
                        break;
                    case R.id.radioButton3:
                        txt.setTextColor(Color.BLUE);
                        break;
                }
            }
        });
    }
}
