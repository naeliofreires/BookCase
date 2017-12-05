package com.bookcase.controller;

import com.bookcase.model.Comentario;
import com.bookcase.repository.ArtigoRepository;
import com.bookcase.repository.ComentarioRepository;
import com.bookcase.repository.UsuarioRepositoryRedis;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ArtigoController{

	@Autowired
	private ArtigosCache artigosCache;
    @Autowired
    private UsuarioCache usuarioCache;
    @Autowired
    private ArtigoRepository artigoRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

    private UsuarioRepositoryRedis usuarioRepositoryRedis;

    ArtigoController(){
        this.usuarioRepositoryRedis = new UsuarioRepositoryRedis();
    }

    @RequestMapping(value = "ler-artigo", method = RequestMethod.GET)
    public ModelAndView lerArtigo(@RequestParam(value="id", required=false) String id, HttpSession session){

        ModelAndView modelAndView = new ModelAndView("artigo");
        Artigo artigo = artigosCache.getArtigo(id);

        Usuario usuario = this.usuarioRepositoryRedis.getUsuario(session.getId());

        Usuario escritor = usuarioCache.getUsuario(Integer.parseInt(artigo.getUserID()));

        modelAndView.addObject("artigo", artigo);
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("escritor", escritor);
        return modelAndView;
    }

    @RequestMapping(value="efetuar-update-artigo", method = RequestMethod.POST)
    public ModelAndView editarArtigo(Artigo artigo, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:usuario");
        try {
            this.artigoRepository.save(artigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  modelAndView;
    }
    @RequestMapping(value = "excluir-artigo", method = RequestMethod.GET)
    String editarArtigo(@RequestParam(value="id", required=false) String id){
        this.artigoRepository.delete(id); // deleto o artigo
        List<Comentario> l = this.comentarioRepository.findComentarioByArtigo(id); // pego os comentarios deste artigo
        for(Comentario c : l)
            this.comentarioRepository.delete(c.getId()); // delete todos os comentarios
        return "redirect:usuario";
    }

}