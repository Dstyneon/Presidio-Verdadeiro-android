package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.zip.DataFormatException;

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

        EditText NomeD = (EditText) findViewById(R.id.NomeD);
        NomeD.setText("pao de forma");

        EditText datasnas = (EditText) findViewById(R.id.DataNasD);
        datasnas.setText("pao de forma");

        EditText CpfD = (EditText) findViewById(R.id.CpfD);
        CpfD.setText("pao de forma");

        EditText FichaC = (EditText) findViewById(R.id.FichaC);
        FichaC.setText("pao de forma");

    }
    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }
    }
