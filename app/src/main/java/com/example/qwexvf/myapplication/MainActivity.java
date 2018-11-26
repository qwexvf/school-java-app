package com.example.qwexvf.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TableRow[] tr = new TableRow[3];
    TextView[] tv = new TextView[3];
    Button[] bt = new Button[3];

    TextView[] btTv = new TextView[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TableLayout tl = new TableLayout(this);
        setContentView(tl);


        for (int i = 0; i < tr.length; i++) {
            tr[i] = new TableRow(this);

            tv[i] = new TextView(this);
            tv[i].setText("商品番号" + i);

            bt[i] = new Button(this);
            bt[i].setText("購入");
            bt[i].setOnClickListener(this);

            btTv[i] = new TextView(this);
            btTv[i].setText(Integer.toString(0));

            tr[i].addView(tv[i]);
            tr[i].addView(bt[i]);
            tr[i].addView(btTv[i]);
            tl.addView(tr[i]);
        }
    }

    public void onClick(View v) {
        for (int i = 0; i < bt.length; i++) {
            if (v.equals(bt[i])) {
                int oldValue = Integer.parseInt(btTv[i].getText().toString());
                btTv[i].setText("" + (oldValue += 1));
            }
        }
    }
}

