package com.bookcase.repository;

import com.bookcase.model.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ComentarioRepository extends MongoRepository<Comentario, String> {
    List<Comentario> findComentarioByArtigo(String artigo);
}
