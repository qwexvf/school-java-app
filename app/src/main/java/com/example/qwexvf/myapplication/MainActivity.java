package com.example.qwexvf.myapplication;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements Runnable {
    SampleView sv;
    Handler handler;

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.ll = new LinearLayout(this);
        setContentView(this.ll);

        handler = new Handler();
        handler.postDelayed(this, 10);
    }

    @Override
    public void run() {
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);

        Display dp = wm.getDefaultDisplay();

        Point p = new Point();
        dp.getSize(p);

        if (sv != null) {
            for (int i=0; i< sv.points.size(); i++) {
                Points point = sv.points.get(i);

                if (point.x < 0 || point.x > p.x) {
                    sv.changeColor();
                    point.dx = -point.dx;
                }
                if (point.y < 0 || point.y > p.y) {
                    sv.changeColor();
                    point.dy = -point.dy;
                }

                point.x += point.dx;
                point.y += point.dy;

                sv.points.set(i, point);
            }

            sv.invalidate();
        }

        handler.postDelayed(this, 10);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == event.ACTION_DOWN) {
            if ( sv == null) {
                sv = new SampleView(this);

                sv.x = event.getX();
                sv.y = event.getY();

                this.ll.addView(sv);
             } else {
                Points p = new Points(event.getX(), event.getY());
                sv.points.add(p);
            }
        }

        return true;
    }
}