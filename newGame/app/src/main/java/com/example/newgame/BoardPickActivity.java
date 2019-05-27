package com.example.newgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BoardPickActivity extends AppCompatActivity {

    private ImageButton boardFirst;
    private ImageButton boardSecond;
    private ImageButton boardThird;
    private ImageButton boardFourth;
    private ImageButton homeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_pick_activity);

        boardFirst = findViewById(R.id.board1Btn);
        boardSecond = findViewById(R.id.board2Btn);
        boardThird = findViewById(R.id.board3Btn);
        boardFourth = findViewById(R.id.board4Btn);
        homeB = findViewById(R.id.homeBtn);

        boardFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardPickActivity.this, DrawActivity.class));
                MainActivity.numberOfBoard = 1;
                MainActivity.numberOfLETTER =1;
            }
        });
        boardSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardPickActivity.this, DrawActivity.class));
                MainActivity.numberOfBoard = 2;
                MainActivity.numberOfLETTER =1;
            }
        });
        boardThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardPickActivity.this, DrawActivity.class));
        MainActivity.numberOfBoard = 3;
                MainActivity.numberOfLETTER =1;
            }
        });
        boardFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardPickActivity.this, DrawActivity.class));
                MainActivity.numberOfBoard = 4;
                MainActivity.numberOfLETTER =1;
            }
        });

        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardPickActivity.this, MainActivity.class));
            }
        });
    }
}
