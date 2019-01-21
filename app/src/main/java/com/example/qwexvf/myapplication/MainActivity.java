package com.example.qwexvf.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    TextView tv;
    CheckBox[] checkBoxes = new CheckBox[4];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.ll = new LinearLayout(this);
        this.ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(this.ll);

        tv = new TextView(this);
        tv.setText("交通手段は？");
        ll.addView(tv);

        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new CheckBox(this);
            checkBoxes[i].setOnCheckedChangeListener(new CheckedChangeListener());
            ll.addView(checkBoxes[i]);
        }

        checkBoxes[0].setText("車");
        checkBoxes[1].setText("電車");
        checkBoxes[2].setText("自転車");
        checkBoxes[3].setText("徒歩");
    }

    class CheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                tv.setText(buttonView.getText() + "を選択しました。");
            } else {
                tv.setText(buttonView.getText() + "の選択をやめました。");
            }

        }
    }
}