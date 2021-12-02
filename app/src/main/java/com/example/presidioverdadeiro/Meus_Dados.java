package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.material.button.MaterialButton;

public class Meus_Dados extends AppCompatActivity {
    DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);

        MaterialButton btnvoltar = (MaterialButton) findViewById(R.id.btnvoltar);

        TextView idpolicial = (TextView) findViewById(R.id.idpolicial);
        TextView email = (TextView) findViewById(R.id.Email);


        SharedPreferences sp = getApplicationContext().getSharedPreferences("Meusdados", Context.MODE_PRIVATE);
        String id = sp.getString("id", "");

        idpolicial.setText(id);

        Cursor dados = DB.retornausuario(id);

        dados.moveToFirst();


        EditText datasnas = (EditText) findViewById(R.id.Email);
        email.setText(dados.getString(2));

        DB.close();

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Meus_Dados.this, "Redirecionando", Toast.LENGTH_SHORT).show();
                openHomescreen();


            }


        });
    }
    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }

}