package com.example.qwexvf.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Bitmap bmp1, bmp1a, bmp2, bmp2a;
    Button bt;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);


        bmp1a = BitmapFactory.decodeResource(getResources(),
                R.drawable.droid1);

        bmp2a = BitmapFactory.decodeResource(getResources(),
                R.drawable.droid2);

        bmp1 = Bitmap.createScaledBitmap(bmp1a, 300, 300,
                false);
        bmp2 = Bitmap.createScaledBitmap(bmp2a, 300, 300,
                false);

        iv = new ImageView(this);
        iv.setImageBitmap(bmp1);

        bt = new Button(this);
        bt.setText("ボタンを押して");
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bt.setText("ボタンが押された! ");
                iv.setImageBitmap(bmp2);
            }
        });

        ll.addView(bt);
        ll.addView(iv);
    }
}