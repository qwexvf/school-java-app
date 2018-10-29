package com.example.qwexvf.myapplication;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements Runnable {
    SampleView sv;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LinearLayout ll = new LinearLayout(this);
        setContentView(ll);

        handler = new Handler();
        handler.postDelayed(this, 10);

        sv = new SampleView(this);

        ll.addView(sv);
    }

    @Override
    public void run() {
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);

        Display dp = wm.getDefaultDisplay();

        Point p = new Point();
        dp.getSize(p);

        if (sv.x < 0 || sv.x > p.x)
            sv.dx = -sv.dx;
        if (sv.y < 0 || sv.y > p.y)
            sv.dy = -sv.dy;

        sv.x += sv.dx;
        sv.y += sv.dy;

        sv.invalidate();

        handler.postDelayed(this, 10);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(this);
    }
}
