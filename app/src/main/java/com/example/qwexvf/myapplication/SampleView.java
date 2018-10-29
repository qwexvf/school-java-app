package com.example.qwexvf.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import java.util.Random;

public class SampleView extends View {

    float x,y;
    Paint p;

    public SampleView (Context ctx) {
        super(ctx);

        x = 100;
        y = 100;
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

        Random rand = new Random();

        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        p.setColor(Color.argb(255, r, g, b));
        p.setStyle(Paint.Style.FILL);
        cs.drawCircle(x, y, 50, p);
    }
}
