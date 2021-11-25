package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Preso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preso);


        TextView NomeD = (TextView) findViewById(R.id.NomeD);
        TextView DataNasD = (TextView) findViewById(R.id.DataNasD);
        TextView CpfD = (TextView) findViewById(R.id.CpfD);
        TextView FichaC = (TextView) findViewById(R.id.FichaC);

        MaterialButton CadastroDt= (MaterialButton) findViewById(R.id.CadastroDt);

        CadastroDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NomeD.getText().toString().equals("") || DataNasD.getText().toString().equals("") || CpfD.getText().toString().equals("") || FichaC.getText().toString().equals(""))
                {
                    Toast.makeText(Preso.this, "Porfavor Preencha todos as caixas de texto!!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Preso.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    openHomescreen();
                }

                    }

        });
    }
    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }
}