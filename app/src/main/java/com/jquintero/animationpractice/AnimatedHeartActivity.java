package com.jquintero.animationpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class AnimatedHeartActivity extends AppCompatActivity {
    private boolean isAvoid_heart_icon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_heart);

        final ImageView imageView = findViewById(R.id.avoid_heart_icon);

        final Button btnSkip = findViewById(R.id.btnSkip);

        imageView.setOnClickListener(view -> {
            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f);
            fadeOut.setDuration(500);

            ObjectAnimator fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f);
            fadeIn.setDuration(500);

            fadeOut.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    imageView.setImageResource(isAvoid_heart_icon ? R.drawable.filled_heart_icon : R.drawable.avoid_heart_icon);
                    fadeIn.start();
                }
            });

            isAvoid_heart_icon = !isAvoid_heart_icon;
            fadeOut.start();
        });

        btnSkip.setOnClickListener(view -> {
            Intent intent = new Intent(AnimatedHeartActivity.this, AnimationsMenuActivity.class);
            startActivity(intent);
        });
    }
}