package com.example.newgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class DrawActivity extends AppCompatActivity {

    Canvas myCanvas;
    LinearLayout  myLayout, canvasLayout;
    ImageButton redB, blueB, greenB, yellowB, purpleB;

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

        setContentView(R.layout.activity_draw);

        myLayout = findViewById(R.id.panelLayout);
        canvasLayout = findViewById(R.id.canvasLayout);
        canvasLayout.addView(myCanvas);

        redB = findViewById(R.id.redBtn);
        blueB = findViewById(R.id.blueBtn);
        greenB = findViewById(R.id.greenBtn);
        yellowB = findViewById(R.id.yellowBtn);
        purpleB = findViewById(R.id.purpleBtn);

        redB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.r = 255; myCanvas.g = 0; myCanvas.b = 0;
            }
        });

        blueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.r = 30; myCanvas.g = 144; myCanvas.b = 255;
            }
        });

        greenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.r = 50; myCanvas.g = 205; myCanvas.b = 50;
            }
        });

        yellowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.r = 255; myCanvas.g = 255; myCanvas.b = 0;
            }
        });

        purpleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCanvas.r = 255; myCanvas.g = 0; myCanvas.b = 255;
            }
        });


    }
}
