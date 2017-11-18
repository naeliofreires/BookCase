package com.bookcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookcase.cache.ArtigosCache;
import com.bookcase.cache.UsuarioCache;
import com.bookcase.model.Artigo;
import com.bookcase.model.Usuario;

@Controller
public class ArtigoController{

	@Autowired
	private ArtigosCache artigosCache;
    
    @Autowired
    private UsuarioCache usuarioCache;
    
    ArtigoController(){}

    @RequestMapping(value = "ler-artigo", method = RequestMethod.GET)
    public ModelAndView lerArtigo(@RequestParam(value="id", required=false) String id){
        
        ModelAndView modelAndView = new ModelAndView("artigo");

        Artigo artigo = artigosCache.getArtigo(id);
        Usuario usuario = usuarioCache.getUsuario(Integer.parseInt(artigo.getId_user()));
        
        modelAndView.addObject("artigo", artigo);
        modelAndView.addObject("escritor", usuario);
        
        return modelAndView;
    }
}