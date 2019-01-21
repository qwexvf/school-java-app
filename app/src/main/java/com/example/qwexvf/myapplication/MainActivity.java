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
    CheckBox cb1, cb2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.ll = new LinearLayout(this);
        this.ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(this.ll);

        tv = new TextView(this);
        tv.setText("交通手段は？");

        cb1 = new CheckBox(this);
        cb2 = new CheckBox(this);

        cb1.setText("車");
        cb2.setText("電車");

        ll.addView(tv);
        ll.addView(cb1);
        ll.addView(cb2);

        cb1.setOnCheckedChangeListener(new CheckedChangeListener());
        cb2.setOnCheckedChangeListener(new CheckedChangeListener());
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