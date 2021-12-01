package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;



public class Preso extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preso);


        TextView NomeD = (TextView) findViewById(R.id.NomeD);
        TextView DataNasD = (TextView) findViewById(R.id.DataNasD);
        TextView CpfD = (TextView) findViewById(R.id.CpfD);
        TextView FichaC = (TextView) findViewById(R.id.FichaC);

        MaterialButton CadastroDt= (MaterialButton) findViewById(R.id.CadastroDt);

        DB = new DBHelper(this);

        CadastroDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome =   NomeD.getText().toString();
                String dtnasc = DataNasD.getText().toString();
                String Cpf =    CpfD.getText().toString();
                String Ficha =  FichaC.getText().toString();

                if(NomeD.getText().toString().equals("") || DataNasD.getText().toString().equals("") || CpfD.getText().toString().equals("") || FichaC.getText().toString().equals(""))
                {
                    Toast.makeText(Preso.this, "Por favor preencha todos as caixas de texto!!!",Toast.LENGTH_SHORT).show();
                }
                else {

                    Boolean checkcpf = DB.checkcpf(Cpf);

                    if(checkcpf){

                        Toast.makeText(Preso.this, "O CPF " + Cpf + " já está cadastrado! ", Toast.LENGTH_SHORT).show();

                    }

                    else{

                        Boolean insertpresodata = DB.insertpresodata(nome,dtnasc,Cpf,Ficha);

                        if(insertpresodata){
                            Toast.makeText(Preso.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                            openHomescreen();
                        }
                        else {
                            Toast.makeText(Preso.this, "Falha ao inserir dados!", Toast.LENGTH_SHORT).show();
                        }

                    }


                }

                    }

        });
    }
    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }
}