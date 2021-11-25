package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


            }


        });


        consultarbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(Tela_principal.this, "Redirecionando", Toast.LENGTH_SHORT).show();


            }


        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(Tela_principal.this, "Saindo...", Toast.LENGTH_SHORT).show();
                OpenLoginScreen();


            }


        });




    }

    public void OpenLoginScreen() {
        Intent intent = new Intent(this,Preso.class);
        startActivity(intent);
    }


    }
