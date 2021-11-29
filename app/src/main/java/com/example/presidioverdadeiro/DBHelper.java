package com.example.presidioverdadeiro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Presidiodata.db";


    public DBHelper(@Nullable Context context) {

        super(context, "Presidiodata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Usuarios(id_policial TEXT PRIMARY KEY, senha PASSWORD NOT NULL, email TEXT NOT NULL )");
        DB.execSQL("create Table Presos(Cpf int NOT NULL PRIMARY KEY, nome TEXT NOT NULL, dtnasc DATE NOT NULL, Ficha TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Usuarios");
        DB.execSQL("drop Table if exists Presos");


    }


    public Boolean insetuserdata(String id_policial, String senha, String email){

        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("id_policial", id_policial);
        contentValues.put("senha", senha);
        contentValues.put("email", email);

        long result = DB.insert("Usuarios", null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean insertpresodata(String nome, String dtnasc, String Cpf, String Ficha) {

        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        contentValues.put("dtnasc", dtnasc);
        contentValues.put("Cpf", Cpf);
        contentValues.put("Ficha", Ficha);

        long result = DB.insert("Presos", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkid(String id) {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Usuarios where id_policial = ?", new String[] {id} );

        if(cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }

    }

    public Boolean checksenha(String id, String senha){

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * From Usuarios where id_policial = ? and senha = ?", new String[] {String.valueOf(id), String.valueOf(senha)});

        if(cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }

    }



}