package com.example.qwexvf.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

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

        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.FILL);
        cs.drawCircle(x, y, 50, p);
    }
}
