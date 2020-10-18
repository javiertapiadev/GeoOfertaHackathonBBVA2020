package com.example.geoofertas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistroGustos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_gustos);
    }

    public void changeActivityToMenu(View view){
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}