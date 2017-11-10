package com.bookcase.restController;

import com.bookcase.model.Artigo;
import com.bookcase.model.Usuario;
import com.bookcase.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ArtigoResource {

    @Autowired
    private ArtigoRepository artigoRepository;

    public ArtigoResource() { }

    @RequestMapping(value="/artigo", method = RequestMethod.POST, produces="application/json")
    public void adicionarArtigo(@RequestBody Artigo artigo, HttpSession session){

        Usuario user = (Usuario) session.getAttribute("usuario");

        artigo.setId_user(user.getId().toString());

        artigoRepository.save(artigo);
    }
}
