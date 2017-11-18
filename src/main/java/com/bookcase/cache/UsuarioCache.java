package com.bookcase.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.bookcase.model.Usuario;
import com.bookcase.repository.UsuarioRepository;

@Component
public class UsuarioCache {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Cacheable(value = "usuarioCache", key = "#id")
	public Usuario getUsuario(Integer id){
		System.out.println("[Cache]Realizando consulta pelo usuario com Id: " + id);
		return usuarioRepository.findOne(id);
	}
}
