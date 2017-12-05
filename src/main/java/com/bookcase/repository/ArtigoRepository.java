package com.bookcase.repository;

import com.bookcase.model.Artigo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtigoRepository extends MongoRepository<Artigo, String> {

    // Pega todos os artigos de determinado Usuário
    List<Artigo> findArtigosByUserID(String id);
}