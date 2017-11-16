package com.bookcase.restController;

import com.bookcase.model.Artigo;
import com.bookcase.model.Comentario;
import com.bookcase.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ComentarioResource {

    @Autowired
    ComentarioRepository comentarioRepository;

    public ComentarioResource() { }

    /** adicionar comentario**/
    @RequestMapping(value="/comentario", method = RequestMethod.POST, produces="application/json")
    public void adicionarComentario(@RequestBody Comentario comentario){
        System.out.println(comentario.toString());
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
