package com.example.geoofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Inicio extends AppCompatActivity implements Runnable {

    ImageView logo, splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        logo = findViewById(R.id.imageLogo);
        splashImg = findViewById(R.id.imagePrincipal);
        lottieAnimationView = findViewById(R.id.robot);

        splashImg.animate().translationY(-2200).setDuration(800).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(800).setStartDelay(4000).withEndAction(this);
        lottieAnimationView.animate().translationY(2000).setDuration(800).setStartDelay(4000);
    }

    @Override
    public void run() {
        Intent intento = new Intent(this, InicioSesion.class);
        startActivity(intento);
    }

}