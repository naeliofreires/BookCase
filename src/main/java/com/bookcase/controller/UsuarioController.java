package com.bookcase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookcase.model.Usuario;
import com.bookcase.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioController() {
    }

    // redireciona para a pagina de cadastro do usuário
    @RequestMapping("cadastroUsuario")
    String telaCadastro() {
        return "usuario/cadastro";
    }

    // realizar cadastro de um novo usuário
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

    // logando
    @RequestMapping(value = "efetuar-login", method = RequestMethod.POST)
    String logar(Usuario usuario, HttpSession session) {

        List<Usuario> user = usuarioRepository.findUsuarioByEmailAndSenha(usuario.getEmail(), usuario.getSenha());

        if (user.size() != 0) {

            session.setAttribute("usuario", user.get(0));

            return "redirect:/";
        }
        return "redirect:/";
    }

    // deslogando
    @RequestMapping("deslogar")
    String deslogar(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
