package com.example.newgame;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TutorialActivity extends AppCompatActivity {

    PathView path_view;
    LinearLayout animationLayout;
    ImageView hand;
    ImageButton homeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        path_view = new PathView(this);
        animationLayout = findViewById(R.id.canvasLayout);
        hand = findViewById(R.id.hand);
        homeB = findViewById(R.id.homeBtn);
        hand.setX(80);
        hand.setY(5);
        path_view.init();
        animationLayout.addView(path_view);
        animateHand(hand);

        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, MainActivity.class));
            }
        });
    }



    private void animateHand(ImageView v) {
        AnimatorSet animSetXY = new AnimatorSet();
        ObjectAnimator animX = ObjectAnimator.ofFloat(v, "translationX", v.getX(), 520f);
        ObjectAnimator animY = ObjectAnimator.ofFloat(v, "translationY", v.getY(), 650f);

        animSetXY.playSequentially(animY, animX);
        animSetXY.setInterpolator(new LinearInterpolator());
        animSetXY.setDuration(4000);
        animSetXY.start();
    }

}
