package com.gabriel.usuario_sql.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Conexao_db {

    public SQLiteDatabase instancia;


    public void conectar(Context contexto) {

        try {

            this.instancia = contexto.openOrCreateDatabase("db_sql", Context.MODE_PRIVATE, null);


        } catch (Exception erro) {
            erro.printStackTrace();
        }

    }

}
