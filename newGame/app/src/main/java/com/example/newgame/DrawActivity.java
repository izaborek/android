package com.example.newgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawActivity extends AppCompatActivity  {

    Canvas myCanvas;
    LinearLayout  myLayout, canvasLayout;
    ImageButton redB, blueB, greenB, yellowB, purpleB;
    ImageButton nextB, prevB, retryB;

    ArrayList<Float> listka = new ArrayList<>();
    List<String> listA;
    String[] lettersData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
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
        listka.add((float) 775);
        listka.add((float) 500);
        listka.add((float) 1075);
        listka.add((float) 500);
        */
        //pobieranie wartosci punktow z pliku xml do tablicy
        lettersData = getResources().getStringArray(R.array.listaA);
        listA = Arrays.asList(lettersData);
        for(int i =0; i<listA.size(); i++) {
            listka.add(Float.parseFloat(listA.get(i)));
        }


        final Letter letter = new Letter("literaa", listka);
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
        nextB = findViewById(R.id.nextBtn);
        prevB = findViewById(R.id.previousBtn);
        retryB = findViewById(R.id.retryBtn);

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

        nextB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                letter.setName("literab");
                myCanvas.RefreshViewAndShowNewView(1,letter);
            }
        });

        prevB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                letter.setName("literaa");
                myCanvas.RefreshViewAndShowNewView(1,letter);
            }
        });

        retryB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //czyszczenie sceny aby rysowac ponownie
            }
        });
    }

}
