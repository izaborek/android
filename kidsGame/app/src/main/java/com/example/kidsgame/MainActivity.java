package com.example.kidsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playB, tutB, exitB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playB = findViewById(R.id.playBtn);
        tutB = findViewById(R.id.tutorialBtn);
        exitB = findViewById(R.id.exitBtn);

        playB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BoardPickActivity.class));
            }
        });
    }



}
