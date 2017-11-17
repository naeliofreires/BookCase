package com.bookcase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "comentarios")
public class Comentario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    @NotNull
    private String artigo;
    @NotNull
    private String escritor;
    @NotNull
    private String nomeEscritor;
    @NotNull
    private String texto;

    public Comentario() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNomeEscritor() {
        return nomeEscritor;
    }

    public void setNomeEscritor(String nomeEscritor) {
        this.nomeEscritor = nomeEscritor;
    }

    @Override
    public String toString() {
        return "Artigo: " + this.artigo + " Escritor: " + this.escritor + " Texto: " + this.texto;
    }

}
