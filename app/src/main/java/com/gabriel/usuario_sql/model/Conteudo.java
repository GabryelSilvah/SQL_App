package com.gabriel.usuario_sql.model;

public class Conteudo {

    int id;
    String titulo;
    String artigo;
    String imagem;

    public Conteudo() {

    }

    public Conteudo(int id, String titulo, String artigo) {
        this.id = id;
        this.titulo = titulo;
        this.artigo = artigo;

    }

    //Gets e Sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
