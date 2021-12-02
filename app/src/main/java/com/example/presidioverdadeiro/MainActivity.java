package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private DBHelper DB;
    SharedPreferences sp;
    String idStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView id = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.lognbtn);
        MaterialButton Cadastrar = (MaterialButton) findViewById(R.id.cadastrar);

        DB = new DBHelper(this);
        sp = getSharedPreferences("Meusdados", Context.MODE_PRIVATE);

        //admin e admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().equals("") || password.getText().toString().equals("") ){ //se o campo id ou o campo senha estiverem em branco

                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos",Toast.LENGTH_SHORT).show();

                }
                else{

                    String id_policial = id.getText().toString();
                    String senha = password.getText().toString();

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("id",id_policial);
                    editor.commit();

                    Boolean checksenha = DB.checksenha(id_policial, senha);

                    if (checksenha == true) { //se o usuario e/ou a senha existirem
                        Toast.makeText(MainActivity.this, "Bem vindo(a)", Toast.LENGTH_SHORT).show();
                        AbrirHomeScreen();
                    }
                    else { //se o usuario e/ou a senha não existirem
                        Toast.makeText(MainActivity.this, "Credenciais inválidas, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }


            }


        });

        Cadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                AbrirTelaCadastro();
            }
        });


    }




    public void AbrirHomeScreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }
    public void AbrirTelaCadastro() {
        Intent intent = new Intent(this,Cadastrofunc.class);
        startActivity(intent);
    }


}