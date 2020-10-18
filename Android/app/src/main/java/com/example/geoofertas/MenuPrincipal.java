package com.example.geoofertas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        bottomNavigationView = findViewById(R.id.bottonNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Maps()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()){
                        case R.id.mapa:
                            fragment = new Maps();
                            break;
                        case R.id.mispromociones:
                            fragment = new MisOfertas();
                            break;
                        case R.id.promociones:
                            fragment = new Fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    return false;
                }
            };
}