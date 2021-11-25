package com.example.presidioverdadeiro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "Presidiodata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Usuarios(id_policial TEXT NOT NULL PRIMARY KEY, usuario TEXT NOT NULL, senha PASSWORD NOT NULL, email TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists Usuarios");


    }


    public Boolean insetuserdata(String id_policial, String usuario, String senha, String email){

        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("id_policial", id_policial);
        contentValues.put("usuario", usuario);
        contentValues.put("senha", senha);
        contentValues.put("email", email);

        long result = DB.insert("Usuarios", null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }


    }




}
