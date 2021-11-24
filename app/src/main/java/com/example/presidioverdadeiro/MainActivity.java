package com.example.presidioverdadeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.lognbtn);
        MaterialButton Cadastrar = (MaterialButton) findViewById(R.id.cadastrar);

        //admin e admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("Admin") && password.getText().toString().equals("Admin"))
                //correto
                {
                    Toast.makeText(MainActivity.this, "Login aprovado",Toast.LENGTH_SHORT).show();
                    openHomescreen();
                }
                else {
                    //incorreto
                    Toast.makeText(MainActivity.this, "Usuário ou senha incorreto!",Toast.LENGTH_SHORT).show();

                }

            }



        });
        Cadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                openHomescreen2();
            }
        });


    }




    public void openHomescreen() {
        Intent intent = new Intent(this,Tela_principal.class);
        startActivity(intent);
    }
    public void openHomescreen2() {
        Intent intent = new Intent(this,Cadastrofunc.class);
        startActivity(intent);
    }


}