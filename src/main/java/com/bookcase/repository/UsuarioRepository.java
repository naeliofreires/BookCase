package com.bookcase.repository;

import com.bookcase.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByEmail(String email);
    List<Usuario> findUsuarioByEmailAndSenha(String email, String senha);
}
