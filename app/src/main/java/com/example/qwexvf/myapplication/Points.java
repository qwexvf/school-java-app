package com.example.qwexvf.myapplication;

import java.util.Random;

public class Points {
    float x = 0;
    float y = 0;

    int dx;
    int dy;

    int r,b,g;

    public Points(float x, float y) {
        this.x = x;
        this.y = y;

        Random rand = new Random();

        dx = rand.nextInt(21) - 10;
        dy = rand.nextInt(21) - 10;

         r = rand.nextInt(256);
         g = rand.nextInt(256);
         b = rand.nextInt(256);
    }
}
