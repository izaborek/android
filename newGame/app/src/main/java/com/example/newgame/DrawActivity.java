package com.example.newgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class DrawActivity extends AppCompatActivity {

    Canvas myCanvas;
    ArrayList<Float> listka = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listka.add((float) 100);
        listka.add((float) 200);
        listka.add((float) 100);
        listka.add((float) 400);
        listka.add((float) 100);
        listka.add((float) 500);
        listka.add((float) 100);
        listka.add((float) 600);
        listka.add((float) 100);
        listka.add((float) 700);
        listka.add((float) 100);
        listka.add((float) 800);
        Letter letter = new Letter("literaa", listka);
        myCanvas = new Canvas(this, null,letter);

        setContentView(myCanvas);


    }
}
