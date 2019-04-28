package com.example.newgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DrawActivity extends AppCompatActivity {

    Canvas myCanvas;
    ArrayList<Float> listka = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listka.add((float) 650);
        listka.add((float) 820);
        listka.add((float) 775);
        listka.add((float) 500);
        listka.add((float) 925);
        listka.add((float) 190);
        listka.add((float) 1075);
        listka.add((float) 500);
        listka.add((float) 1200);
        listka.add((float) 820);
        Letter letter = new Letter("literaa", listka);
        myCanvas = new Canvas(this, null,letter);
        setContentView(myCanvas);


    }
}
