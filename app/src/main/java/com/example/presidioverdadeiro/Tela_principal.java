package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Tela_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);



        MaterialButton adicionarbtn = (MaterialButton) findViewById(R.id.adicionarbtn);
        MaterialButton cadastrarbtn = (MaterialButton) findViewById(R.id.cadastrarbtn);
        MaterialButton consultarbtn = (MaterialButton) findViewById(R.id.consultarbtn);
        MaterialButton logoutbtn = (MaterialButton) findViewById(R.id.logoutbtn);



        SharedPreferences sp = getApplicationContext().getSharedPreferences("Meusdados", Context.MODE_PRIVATE);
        String id = sp.getString("id", "");




        adicionarbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(Tela_principal.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                OpenLoginScreen();
                        //está só de teste mudar depois 1 pra cada e 1 função pra cada

            }


        });


        cadastrarbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(Tela_principal.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                OpenLoginScreen2();

            }


        });


        consultarbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(Tela_principal.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                OpenLoginScreen3();


            }


        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(Tela_principal.this, "Saindo...", Toast.LENGTH_SHORT).show();
                OpenLoginScreen4();


            }


        });




    }

    public void OpenLoginScreen() {
        Intent intent = new Intent(this,Preso.class);
        startActivity(intent);
    }
    public void OpenLoginScreen2() {
        Intent intent = new Intent(this,Meus_Dados.class);
        startActivity(intent);
    }
    public void OpenLoginScreen3() {
        Intent intent = new Intent(this,Pesquisa.class);
        startActivity(intent);
    }
    public void OpenLoginScreen4() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    }
