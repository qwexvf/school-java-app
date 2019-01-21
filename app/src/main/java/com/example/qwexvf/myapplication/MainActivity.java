package com.example.qwexvf.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    TextView[] tv = new TextView[3];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.ll = new LinearLayout(this);
        this.ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(this.ll);

        for (int i = 0; i < tv.length; i++) {
            tv[i] = new TextView(this);
            tv[i].setText("おはよう");
        }

        tv[0].setTextColor(Color.BLACK);
        tv[1].setTextColor(Color.BLUE);
        tv[2].setTextColor(Color.RED);

        tv[0].setBackgroundColor(Color.WHITE);
        tv[1].setBackgroundColor(Color.LTGRAY);
        tv[2].setBackgroundColor(Color.WHITE);

        tv[0].setTextSize(14);
        tv[1].setTextSize(16);
        tv[2].setTextSize(18);

        for (TextView aTv : tv) {
            this.ll.addView(aTv);
        }
    }
}