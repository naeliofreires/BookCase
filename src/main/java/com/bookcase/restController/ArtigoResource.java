package com.bookcase.restController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bookcase.repository.UsuarioRepositoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookcase.model.Artigo;
import com.bookcase.model.Usuario;
import com.bookcase.repository.ArtigoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ArtigoResource { 
	
    @Autowired
    private ArtigoRepository artigoRepository;

    private UsuarioRepositoryRedis usuarioRepositoryRedis;

    public ArtigoResource() {
        this.usuarioRepositoryRedis =  new UsuarioRepositoryRedis();
    }

    /** adicionar artigo**/
    @RequestMapping(value="/artigo", method = RequestMethod.POST, produces="application/json")
    public void adicionarArtigo(@RequestBody Artigo artigo, HttpSession session) throws JsonProcessingException {

        Usuario user = this.usuarioRepositoryRedis.getUsuario(session.getId());

        artigo.setUserID(user.getId().toString());
        artigo.setNome_autor(user.getNome());

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        artigo.setData_publicacao(formatador.format(new Date()));

        artigoRepository.save(artigo);
    }

//    dando erro
    /** listar todos artigos**/
    @RequestMapping(value = "/artigo", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Artigo>> listarArtigos(){
        return new ResponseEntity<List<Artigo>>((ArrayList) this.artigoRepository.findAll(), HttpStatus.OK);
    }

}
