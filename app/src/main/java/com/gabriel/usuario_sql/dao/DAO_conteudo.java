package com.gabriel.usuario_sql.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gabriel.usuario_sql.model.Conteudo;

import java.util.ArrayList;
import java.util.List;

public class DAO_conteudo {

    private SQLiteDatabase con;

    public DAO_conteudo(Context contexto) {

        Conexao_db banco = new Conexao_db();
        banco.conectar(contexto);
        this.con = banco.instancia;

    }

    //Inserir dados na tabela
    public void inserir(Conteudo objeto) {
        String sql = "INSERT INTO conteudo (titulo,artigo) VALUES ('" + objeto.getTitulo() + "','" + objeto.getArtigo() + "');";
        this.con.execSQL(sql);
    }

    //Listar dados da tabela
    public List<Conteudo> listar() {

        //Consulta na base de dados
        String sql = "SELECT * FROM conteudo";
        Cursor cursor = this.con.rawQuery(sql, null);

        //Pegando cada registro e salvando em um array
        List<Conteudo> dados = new ArrayList<>();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String titulo = cursor.getString(1);
            String artigo = cursor.getString(2);

            Conteudo conteudo = new Conteudo(id, titulo, artigo);
            dados.add(conteudo);
        }

        return dados;

    }


    //Listar dados da tabela
    public List<Conteudo> listar_all_titulos(int categoria) {

        //Consulta na base de dados
        String sql = "SELECT id_cont, titulo FROM conteudo WHERE categoria = " + categoria;
        Cursor cursor = this.con.rawQuery(sql, null);

        //Pegando cada registro e salvando em um array
        List<Conteudo> dados = new ArrayList<>();
        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String titulo = cursor.getString(1);

            Conteudo conteudo = new Conteudo(id, titulo, null);
            dados.add(conteudo);
        }
        return dados;
    }


    //Pegar registro pelo ID
    public Conteudo listar_by_id(int id_conteudo) {
        String sqlSelect = "SELECT * FROM conteudo WHERE id_cont = " + id_conteudo;
        Cursor cursor = this.con.rawQuery(sqlSelect, null);

        cursor.moveToNext();
        int id = cursor.getInt(0);
        String titulo = cursor.getString(1);
        String artigo = cursor.getString(2);

        Conteudo conteudo = new Conteudo(id, titulo, artigo);

        return conteudo;
    }


    //Alterar dados na tabel
    public void update(String colunas_valores, int id) {
        String sql = "UPDATE conteudo SET " + colunas_valores + "WHERE id =" + id;
        this.con.execSQL(sql);
    }

    //excluir dados da tabela
    public void delete(int id) {
        String sql = "DELETE FROM conteudo WHERE id = " + id;
        this.con.execSQL(sql);
    }

    public void desconectar() {
        this.con.close();
    }


}
