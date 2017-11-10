package com.bookcase.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity()
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_USUARIO", nullable=false)
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    @Transient
    private Collection<Usuario> quem_sigo;
    @Transient
    private Collection<Usuario> quem_me_segue;

    public Usuario() { }


    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha, Collection<Usuario> quem_sigo, Collection<Usuario> quem_me_segue) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.quem_sigo = quem_sigo;
        this.quem_me_segue = quem_me_segue;
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

    public Collection<Usuario> getQuem_sigo() {
        return quem_sigo;
    }

    public void setQuem_sigo(Collection<Usuario> quem_sigo) {
        this.quem_sigo = quem_sigo;
    }

    public Collection<Usuario> getQuem_me_segue() {
        return quem_me_segue;
    }

    public void setQuem_me_segue(Collection<Usuario> quem_me_segue) {
        this.quem_me_segue = quem_me_segue;
    }
}