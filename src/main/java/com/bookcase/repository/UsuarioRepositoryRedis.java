package com.bookcase.repository;

import com.bookcase.model.Usuario;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioRepositoryRedis {

    private Jedis jedis;

    public UsuarioRepositoryRedis() {
        this.jedis = new Jedis("localhost");
    }

    public void saveUsuario(String idSession, Usuario user){
        /***REGISTRANDO AS SESSOES LOGADAS*/
        this.jedis.sadd("all:session", idSession);
        this.jedis.expire("all:session",20*60);

        this.jedis.hset("usuario:"+ idSession, "id", user.getId().toString());
        this.jedis.hset("usuario:"+ idSession, "nome", user.getNome());
        this.jedis.hset("usuario:"+ idSession, "email", user.getEmail());
        this.jedis.hset("usuario:"+ idSession, "trabalho", user.getTrabalho());

        /**MANTENDO OS DADOS POR 20 MINUTOS**/
        this.jedis.expire("usuario:"+ idSession, 20*60);
    }

    public Usuario getUsuario(String idSession){

        try {
            List<String> l = this.jedis.hmget("usuario:"+ idSession, "id", "nome", "email", "trabalho");

            String id = l.get(0);
            String nome = l.get(1);
            String email = l.get(2);
            String trabalho = l.get(3);

            return new Usuario(Integer.parseInt(id),nome,email,trabalho);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
//        Usuario user = new Usuario();

//        user.setId(1);
//        user.setNome("naelio freires");
//        user.setEmail("naelio@gmail.com");
//        user.setTrabalho("developinho");
//
//        UsuarioRepositoryRedis usuarioRepositoryRedis =  new UsuarioRepositoryRedis();
//        usuarioRepositoryRedis.saveUsuario("12345",user);
    }
}
