package com.example.kidsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoardPickActivity extends AppCompatActivity {

    private Button boardOne, boardTwo, boardThree, boardFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_pick);

        boardOne = findViewById(R.id.board1Btn);
        boardTwo = findViewById(R.id.board2Btn);
        boardThree = findViewById(R.id.board3Btn);
        boardFour = findViewById(R.id.board4Btn);

        boardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new intent open here
            }
        });
    }
}
