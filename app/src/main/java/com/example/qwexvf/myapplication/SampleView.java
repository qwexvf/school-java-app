package com.example.qwexvf.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;

import com.example.qwexvf.myapplication.Points;


public class SampleView extends View {
    int counter = 0;
    float x, y, dx, dy;

    Paint p;

    Canvas canvas;

    ArrayList<Points> points = new ArrayList<Points>();

    int[][] circles2 = {};

    int r, g, b;

    int colors[][] = {
            {0, 0, 0},
            {255, 255, 255},
            {255, 0, 0},
            {0, 255, 0},
            {0, 0, 255},
            {255, 255, 0},
            {0, 255, 255},
            {255, 0, 255}
    };



    public SampleView(Context ctx) {
        super(ctx);
        System.out.println(" created");

        x = 100;
        y = 100;
        dx = 10;
        dy = 10;
        p = new Paint();
    }

    protected void onDraw(Canvas cs) {
        super.onDraw(cs);
        this.canvas = cs;

        System.out.println("ondraw");


        //r = this.colors[this.counter][0];
        //g = this.colors[this.counter][1];
        //b = this.colors[this.counter][2];

        for (int i = 0; i < points.size(); i++) {
            Points point = points.get(i);

            p.setColor(Color.argb(255, point.r, point.g, point.b));
            p.setStyle(Paint.Style.FILL);

            cs.drawCircle(point.x, point.y, 50, p);
        }

        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);

        Rect r = new Rect(0,0,50,50);
        cs.drawRect(r, p);
    }

    public void changeColor() {
        this.counter += 1;

        if (this.counter >= this.colors.length)
            this.counter = 0;
    }
}
