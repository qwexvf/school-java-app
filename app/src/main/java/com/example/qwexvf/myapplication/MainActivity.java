package com.example.qwexvf.myapplication;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        setContentView(this.ll);

        TextView tv = new TextView(this);
        tv.setText("おはよう");
        Button bt = new Button(this);
        bt.setText("ボタンを押して");

        ll.addView(tv);
        ll.addView(bt);
    }
}

