package com.bookcase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bookcase.model.Artigo;
import com.bookcase.repository.ArtigoRepository;
import com.bookcase.repository.UsuarioRepositoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookcase.cache.ArtigosCache;
import com.bookcase.model.Usuario;
import com.bookcase.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    ArtigosCache artigosCache;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ArtigoRepository artigoRepository;

    UsuarioRepositoryRedis usuarioRepositoryRedis;

    public UsuarioController() {
        usuarioRepositoryRedis  = new UsuarioRepositoryRedis();
    }

    @RequestMapping("cadastroUsuario")
    String telaCadastro() {
        return "usuario/cadastro";
    }

    /** REALIZAR CADASTRO USUARIO **/
    @RequestMapping(value = "efetuar-cadastro-usuario", method = RequestMethod.POST)
    String cadastroUsuario(Usuario user, RedirectAttributes redirectAttributes) {
        try {
            this.usuarioRepository.save(user);
            redirectAttributes.addFlashAttribute("mensagem", "Cadastro Realizado com Sucesso!");
            return "redirect:/";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("mensagem", "Erro ao Cadastrar");
        return "redirect:cadastroUsuario";
    }

    @RequestMapping(value = "efetuar-update-usuario", method = RequestMethod.POST)
    ModelAndView atualizarCadastro(Usuario user, HttpSession session, @RequestParam(value="nova_senha", required=false) String nova_senha) {
        ModelAndView modelAndView = new ModelAndView("redirect:usuario");
        try {
            if(this.usuarioRepository.findOne(user.getId()).getSenha().equals(user.getSenha())) {
                if(!nova_senha.isEmpty())
                    user.setSenha(nova_senha);
            }
            this.usuarioRepository.save(user);
            this.usuarioRepositoryRedis.saveUsuario(session.getId(), user); // update user in [Redis]
            return modelAndView;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return modelAndView;
    }

    /** REALIZAR O LOGIN DA APLICAÇÃO **/
    @RequestMapping(value = "efetuar-login", method = RequestMethod.POST)
    ModelAndView logar(Usuario usuario, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        List<Usuario> user = usuarioRepository.findUsuarioByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

        if (user.size() != 0) {
            session.setAttribute("logado", "true");
            this.usuarioRepositoryRedis.saveUsuario(session.getId(), user.get(0));
            return modelAndView;
        }
        return  modelAndView;
    }

    /** DESLOGAR **/
    @RequestMapping("deslogar")
    String deslogar(HttpSession session){
        session.setAttribute("logado", null);
        session.invalidate();
        return "redirect:/";
    }

    /** VISUALIZAR PERFIL USUARIO **/
    @RequestMapping("usuario")
    ModelAndView lerArtigo(HttpSession session){

        ModelAndView modelAndView = new ModelAndView("usuario/home-perfil");

        Usuario usuario = this.usuarioRepositoryRedis.getUsuario(session.getId());
        List<Artigo> l = this.artigoRepository.findArtigosByUserID(usuario.getId().toString());

        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("meus_artigos",l);
        modelAndView.addObject("quantidade_artigos", l.size());

        return modelAndView;
    }

    /** VISUALIZAR PERFIL DO ESCRITOR **/
    @RequestMapping(value = "escritor", method = RequestMethod.GET)
    ModelAndView verEscritor(@RequestParam(value="id", required=true) Integer id){
    	
        ModelAndView modelAndView = new ModelAndView("usuario/home-escritor");
        
        Usuario escritor = this.usuarioRepository.findOne(id);
        
        List<Artigo> artigos_escritor = this.artigosCache.getArtigosUsuario(id.toString());
        
        modelAndView.addObject("escritor", escritor);
        
        modelAndView.addObject("artigos_escritor", artigos_escritor);
          
        return modelAndView;
    }
    
}
