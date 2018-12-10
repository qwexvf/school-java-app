package com.example.qwexvf.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TableRow[] tr = new TableRow[5];

    TextView textView;
    LinearLayout ll;
    Button[][] buttons = new Button[5][4];

    String[][] actions = {
            {"AC", "", "", "÷"},
            {"7", "8", "9", "×"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"", "0", "", "="},
    };

    @SuppressLint("RtlHardcoded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        textView = new TextView(this);
        textView.setText("0");

        textView.setGravity(Gravity.RIGHT);


        TableLayout tl = new TableLayout(this);

        ll.addView(textView);
        ll.addView(tl);

        setContentView(ll);

        for (int i = 0; i < 5; i++) {
            tr[i] = new TableRow(this);
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new Button(this);
                buttons[i][j].setText(actions[i][j]);
                tr[i].addView(buttons[i][j]);
            }

            tl.addView(tr[i]);
        }
    }

}

