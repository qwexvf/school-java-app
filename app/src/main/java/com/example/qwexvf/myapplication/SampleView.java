package com.example.qwexvf.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

import com.example.qwexvf.myapplication.Points;


public class SampleView extends View {
    int counter = 0;
    float x, y, dx, dy;

    Paint p;

    Canvas canvas;

    ArrayList<Points> points = new ArrayList<Points>();
    ArrayList<Button> buttons = new ArrayList<Button>();

    public SampleView(Context ctx) {
        super(ctx);

    }

    protected void onDraw(Canvas cs) {
        super.onDraw(cs);
        this.canvas = cs;

        for (Button button: buttons) {
        }
    }

}
