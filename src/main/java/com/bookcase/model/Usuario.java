package com.bookcase.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USUARIO", nullable=false)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String trabalho;

    public Usuario() { }

    public Usuario(Integer id, String nome, String email, String trabalho) {
		this.id = id;
	    this.nome = nome;
		this.email = email;
		this.trabalho = trabalho;
	}
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

    public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}