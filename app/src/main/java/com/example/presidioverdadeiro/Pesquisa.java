package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Pesquisa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        MaterialButton VoltarP= (MaterialButton) findViewById(R.id.VoltarP);
        VoltarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pesquisa.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                openHomescreen();
            }


        });
    }
    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }
    }
