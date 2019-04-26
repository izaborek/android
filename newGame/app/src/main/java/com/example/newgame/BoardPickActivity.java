package com.example.newgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BoardPickActivity extends AppCompatActivity {

    private ImageButton boardOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_pick_activity);

        boardOne = findViewById(R.id.board1Btn);

        boardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoardPickActivity.this, DrawActivity.class));
            }
        });
    }
}
