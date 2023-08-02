package com.jquintero.animationpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class AnimationsMenuActivity extends AppCompatActivity {

    Button blink, zoom, rotate, trans, fade, stop;
    TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations_menu);

        blink = findViewById(R.id.blink);
        zoom = findViewById(R.id.zoom);
        rotate = findViewById(R.id.rotate);
        trans = findViewById(R.id.trans);
        fade = findViewById(R.id.fade);
        hello = findViewById(R.id.hello);
        stop = findViewById(R.id.stop);

        hello = findViewById(R.id.hello);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        blink.setOnClickListener(view -> hello.startAnimation(blinkAnimation));
        trans.setOnClickListener(view -> hello.startAnimation(translateAnimation));
        fade.setOnClickListener(view -> hello.startAnimation(fadeAnimation));
        zoom.setOnClickListener(view -> hello.startAnimation(zoomAnimation));
        rotate.setOnClickListener(view -> hello.startAnimation(rotateAnimation));
        stop.setOnClickListener(view -> hello.clearAnimation());
    }
}