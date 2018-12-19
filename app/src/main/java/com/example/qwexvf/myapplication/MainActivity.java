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
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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

    String sum = "0";

    @SuppressLint("RtlHardcoded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Layout
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        textView = new TextView(this);
        textView.setText(sum);
        textView.setTextSize(60);
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
                buttons[i][j].setWidth(270);
                buttons[i][j].setHeight(200);
                buttons[i][j].setTextSize(30);
                buttons[i][j].setOnClickListener(this);
                tr[i].addView(buttons[i][j]);
                if (buttons[i][j].getText() == "") {
                    buttons[i][j].setVisibility(View.INVISIBLE);
                }
            }

            tl.addView(tr[i]);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(buttons[0][0])) {
            textView.setText("0");
            sum = "0";
        } else if (v.equals(buttons[5][4])) {
            String[] numbers = textView.getText().split("+", 0);
            sum = "";
        } else {
            for (Button[] button : buttons) {
                for (Button aButton : button) {
                    if (v.equals(aButton)) {
                        System.out.println(aButton.getText());
                        String number = textView.getText() + (String) aButton.getText();
                        textView.setText(number);
                    }
                }
            }
        }
    }
}
