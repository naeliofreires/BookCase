package com.bookcase.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.bookcase.model.Artigo;
import com.bookcase.repository.ArtigoRepository;

@Component
public class ArtigosCache {

	@Autowired
	ArtigoRepository artigoRepository;
	 
	@Cacheable(value = "artigosCache", key = "#name")
	public Artigo getArtigo(String name){
		System.out.println("[Cache]Realizando consulta pelo artigo com Id: " + name);
		return artigoRepository.findOne(name);
	}
	
	// Buscando artigo no banco de dados ...
	public Artigo getArtigoNoCache(String name){
		System.out.println("[No Cache]Realizando consulta pelo artigo com Id: " + name);
		return artigoRepository.findOne(name);
	}
	
	
}
