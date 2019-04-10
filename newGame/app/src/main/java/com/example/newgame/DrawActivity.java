package com.example.newgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DrawActivity extends AppCompatActivity {

    Canvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myCanvas = new Canvas(this, null);
        setContentView(myCanvas);

    }
}
