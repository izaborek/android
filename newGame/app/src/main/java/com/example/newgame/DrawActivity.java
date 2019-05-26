package com.example.newgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
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
    ArrayList<String> listOfLetters = new ArrayList<>();
    int currentLetterId;
    String currentLetterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentLetterId = MainActivity.numberOfLETTER;
        Letter letter2 = new Letter();
        for(int i = 0; i < Letter.ListOfLetters.size();i++)
        {
            String currentsign = Letter.ListOfLetters.get(i);
            if (currentsign.startsWith(String.valueOf(currentLetterId)) == true)
            {
                currentLetterImage = currentsign.substring(1,currentsign.length());
                break;
            }
        }

        int drawableId=0;
        try {
            Class res = R.array.class;
            Field field = res.getField(currentLetterImage);
            drawableId = field.getInt(null);
        }
        catch (Exception e) {
            Log.e("MyTag", "Failure to get drawable id.", e);
        }
        //pobieranie wartosci punktow z pliku xml do tablicy
        lettersData = getResources().getStringArray(drawableId);
        listA = Arrays.asList(lettersData);
        for(int i =0; i<listA.size(); i++) {
            listka.add(Float.parseFloat(listA.get(i)));
        }

        final Letter letter = new Letter(currentLetterImage, listka);
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
                if(currentLetterId < Letter.ListOfLetters.size())
                {
                    MainActivity.numberOfLETTER++;
                    startActivity(new Intent(DrawActivity.this, DrawActivity.class));
                }
            }
        });

        prevB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(currentLetterId > 1)
                {
                    MainActivity.numberOfLETTER--;
                    startActivity(new Intent(DrawActivity.this, DrawActivity.class));
                }

            }
        });

        retryB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawActivity.this, DrawActivity.class));            }
        });
    }
}
