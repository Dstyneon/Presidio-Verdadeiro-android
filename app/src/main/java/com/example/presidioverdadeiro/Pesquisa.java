package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.zip.DataFormatException;

public class Pesquisa extends AppCompatActivity {

    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        MaterialButton VoltarP = (MaterialButton) findViewById(R.id.VoltarP);
        MaterialButton Pesquisarbtn = (MaterialButton) findViewById(R.id.btnpesquisar);

        TextView Cpf = (TextView) findViewById(R.id.Pesquisar);

        VoltarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Pesquisa.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                openHomescreen();
            }

        });

        DB = new DBHelper(this);

        Pesquisarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Cpf_preso = Cpf.getText().toString();

                Cursor dados = DB.retornadados(Cpf_preso);

                dados.moveToFirst();

                EditText NomeD = (EditText) findViewById(R.id.NomeD);
                NomeD.setText(dados.getString(1));

                EditText datasnas = (EditText) findViewById(R.id.DataNasD);
                datasnas.setText(dados.getString(2));

                EditText CpfD = (EditText) findViewById(R.id.CpfD);
                CpfD.setText(dados.getString(0));

                EditText FichaC = (EditText) findViewById(R.id.FichaC);
                FichaC.setText(dados.getString(3));


            }
        });


    }

    public void openHomescreen() {
        Intent intent = new Intent(this, Tela_principal.class);
        startActivity(intent);
    }
}
