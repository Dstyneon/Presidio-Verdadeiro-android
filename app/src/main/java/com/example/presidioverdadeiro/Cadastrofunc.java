package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Cadastrofunc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrofunc);

        TextView Usuárioc = (TextView) findViewById(R.id.Usuárioc);
        TextView passwordc = (TextView) findViewById(R.id.passwordc);
        TextView passwordconfirm = (TextView) findViewById(R.id.passwordconfirm);
        TextView Email = (TextView) findViewById(R.id.Email);
        TextView idpolicial = (TextView) findViewById(R.id.idpolicial);

        MaterialButton btncadastro= (MaterialButton) findViewById(R.id.btncadastro);

        //admin e admin

        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Usuárioc.getText().toString().equals("") || passwordc.getText().toString().equals("") || passwordconfirm.getText().toString().equals("") || Email.getText().toString().equals("") ||  idpolicial.getText().toString().equals("") )
                {
                    Toast.makeText(Cadastrofunc.this, "Porfavor Preencha todos as caixas de texto!!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(passwordc.getText().toString().equals(passwordconfirm.getText().toString()) ){
                        Toast.makeText(Cadastrofunc.this, "Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show();
                        openHomescreen();
                    }
                    else if (passwordc.getText().toString() != passwordconfirm.getText().toString()){
                        Toast.makeText(Cadastrofunc.this, "As senhas precisam ser identicas!!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void openHomescreen() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}