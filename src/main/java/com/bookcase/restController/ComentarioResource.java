package com.bookcase.restController;

import java.util.ArrayList;
import java.util.List;

import com.bookcase.repository.UsuarioRepositoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookcase.model.Comentario;
import com.bookcase.repository.ComentarioRepository;

import javax.servlet.http.HttpSession;

@RestController
public class ComentarioResource {

    @Autowired
    ComentarioRepository comentarioRepository;

    UsuarioRepositoryRedis usuarioRepositoryRedis;
    public ComentarioResource() {
        this.usuarioRepositoryRedis = new UsuarioRepositoryRedis();
    }

    /** adicionar comentario**/
    @RequestMapping(value="/comentario", method = RequestMethod.POST, produces="application/json")
    public void adicionarComentario(HttpSession session, @RequestBody Comentario comentario){
        System.out.println(this.usuarioRepositoryRedis.getUsuario(session.getId()).getNome());
        comentario.setEscritor(this.usuarioRepositoryRedis.getUsuario(session.getId()).getNome());
        comentarioRepository.save(comentario);
    }

    /** listar todos comentarios**/
    @RequestMapping(value = "/comentario", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Comentario>> listarComentarios(){
        return new ResponseEntity<List<Comentario>>((ArrayList) this.comentarioRepository.findAll(), HttpStatus.OK);
    }

    /** listar todos os comentarios de um determinado artigo **/
    @RequestMapping(value = "/comentario/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Comentario>> listarComentariosArtigo(@PathVariable String id){
        return new ResponseEntity<List<Comentario>>((ArrayList) this.comentarioRepository.findComentarioByArtigo(id), HttpStatus.OK);
    }
}
