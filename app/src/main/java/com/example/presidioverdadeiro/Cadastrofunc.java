package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Cadastrofunc extends AppCompatActivity {

    DBHelper DB;

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

        DB = new DBHelper(this);



        //admin e admin

        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(passwordc.getText().equals("") || passwordconfirm.getText().equals("") || Email.getText().toString().equals("") ||  idpolicial.getText().toString().equals("") )
                {
                    Toast.makeText(Cadastrofunc.this, "Por favor Preencha todos as caixas de texto!!!",Toast.LENGTH_SHORT).show();
                }

                else{
                    if(passwordc.getText().toString().equals(passwordconfirm.getText().toString()) ){ //Se as senhas forem iguais

                        String id_policial = idpolicial.getText().toString();
                        String senha = passwordc.getText().toString();
                        String email = Email.getText().toString();

                        Boolean checkid = DB.checkid(id_policial);

                        if(checkid==false) //Se o usuário ainda não existir
                        {
                          Boolean insetuserdata = DB.insetuserdata(id_policial,senha,email); //insere dados na tabela de usuarios

                            if (insetuserdata == true){ // se foi inserido sem erros

                                Toast.makeText(Cadastrofunc.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Cadastrofunc.this, "Falha ao inserir dados, tente novamente", Toast.LENGTH_SHORT).show();
                            }
                        }

                        else{ //Se o usuário existir

                            Toast.makeText(Cadastrofunc.this, "O usuário já existe, vá para a tela de login", Toast.LENGTH_SHORT).show();

                        }


                    }
                    else if (passwordc.getText().toString() != passwordconfirm.getText().toString()){ //Se as senhas não forem iguais
                        Toast.makeText(Cadastrofunc.this, "As senhas precisam ser identicas!!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

}