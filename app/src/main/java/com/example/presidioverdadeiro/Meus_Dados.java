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

public class Meus_Dados extends AppCompatActivity {


    private  DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);

        MaterialButton btnvoltar= (MaterialButton) findViewById(R.id.btnvoltar);



        TextView idpolicial = (TextView) findViewById(R.id.idpolicial);
        TextView email = (TextView) findViewById(R.id.Email);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Meus_Dados.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                    openHomescreen();
                }


        });

        DB = new DBHelper(this);



//            Cursor dados = DB.retornausuario(id_local);
//
//            dados.moveToFirst();
//
//            EditText NomeD = (EditText) findViewById(R.id.idpolicial);
//            idpolicial.setText(dados.getString(0));
//
//            EditText datasnas = (EditText) findViewById(R.id.Email);
//            email.setText(dados.getString(2));



    }
    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }

}