package com.example.qwexvf.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import java.util.Random;

public class SampleView extends View {

    float x,y, dx, dy;
    Paint p;
    Canvas canvas;

    int r,g,b;

    public SampleView (Context ctx) {
        super(ctx);

        x = 100;
        y = 100;
        dx = 10;
        dy = 10;
        p = new Paint();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        x = ev.getX();
        y = ev.getY();

        this.invalidate();

        return true;
    }

    protected void onDraw(Canvas cs) {
        super.onDraw(cs);
        this.canvas = cs;

        p.setColor(Color.argb(255, r, g, b));
        p.setStyle(Paint.Style.FILL);
        cs.drawCircle(x, y, 50, p);
    }

    public void changeColor() {
        System.out.println("test");
        Random rand = new Random();
        r = rand.nextInt(256);
        g = rand.nextInt(256);
        b = rand.nextInt(256);
    }
}
