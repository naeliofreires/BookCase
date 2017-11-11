package com.bookcase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "artigo")
public class Artigo implements Serializable{

    @Id
    private String id;
    private String id_user;
    private String titulo;
    private String texto;
    private String data_publicacao;

    public Artigo() { }

    public Artigo(String id) {
        this.id = id;
    }

    public Artigo(String id, String id_user, String titulo, String texto, String data_publicacao) {
        this.id = id;
        this.id_user = id_user;
        this.titulo = titulo;
        this.texto = texto;
        this.data_publicacao = data_publicacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }
}
