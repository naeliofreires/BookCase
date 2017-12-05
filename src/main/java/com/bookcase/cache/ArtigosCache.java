package com.bookcase.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.bookcase.model.Artigo;
import com.bookcase.repository.ArtigoRepository;
import java.util.List;

@Component
public class ArtigosCache {

	@Autowired
	ArtigoRepository artigoRepository;
	 
	@Cacheable(value = "artigosCache", key = "#id")
	public Artigo getArtigo(String id){
		System.out.println("[Cache]Realizando consulta pelo artigo com Id: " + id);
		return artigoRepository.findOne(id);
	}

	@Cacheable(value = "usuarioArtigoCache", key = "#id")
	public List<Artigo> getArtigosUsuario(String id){
        System.out.println("[Cache]Realizando consulta por todos os artigos do usuario com Id: " + id);
		return artigoRepository.findArtigosByUserID(id);
	}

	// Buscando artigo no banco de dados ...
	public Artigo getArtigoNoCache(String name){
		System.out.println("[Consulta]Realizando consulta pelo artigo com Id: " + name);
		return artigoRepository.findOne(name);
	}

}
