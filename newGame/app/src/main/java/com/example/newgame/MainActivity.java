package com.example.newgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton playB, tutB, exitB;
    public static int numberOfLETTER = 1;
    public static int numberOfBoard;
    /**,
     * Klasa umożliwia wybór aktywności. Kliknięcie przycisku przenosi użytkownika do ekranu wyboru planszy. Możliwe jest również wyjście z gry lub
     * wybór ekranu tutorialu
     * */
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

        exitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });

        tutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TutorialActivity.class));
            }
        });
    }
}
