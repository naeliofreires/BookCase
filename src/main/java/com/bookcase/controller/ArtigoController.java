package com.bookcase.controller;

import com.bookcase.model.Artigo;
import com.bookcase.model.Usuario;
import com.bookcase.repository.ArtigoRepository;
import com.bookcase.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtigoController{

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    
    ArtigoController(){}

    @RequestMapping(value = "ler-artigo", method = RequestMethod.GET)
    public ModelAndView lerArtigo(@RequestParam(value="id", required=false) String id){
        
        ModelAndView modelAndView = new ModelAndView("artigo");
        Artigo artigo = artigoRepository.findOne(id);
        Usuario usuario = usuarioRepository.findOne(Integer.parseInt(artigo.getId_user()));
        modelAndView.addObject("artigo", artigo);
        modelAndView.addObject("escritor", usuario);
        return modelAndView;
    }
}