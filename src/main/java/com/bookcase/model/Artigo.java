package com.bookcase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "artigos")
public class Artigo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    @NotNull
    private String userID;
    @NotNull
    private String nome_autor;
    @NotNull
    private String titulo;
    @NotNull
    private String resumo;
    @NotNull
    private String texto;
    @NotNull
    private String data_publicacao;

    public Artigo() { }

    public Artigo(String id) {
        this.id = id;
    }

    public Artigo(String id, String userID, String nome_autor, String titulo, String resumo, String texto, String data_publicacao) {
        this.id = id;
        this.userID = userID;
        this.nome_autor = nome_autor;
        this.titulo = titulo;
        this.resumo = resumo;
        this.texto = texto;
        this.data_publicacao = data_publicacao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
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
