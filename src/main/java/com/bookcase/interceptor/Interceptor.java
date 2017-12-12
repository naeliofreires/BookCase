package com.bookcase.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();

        if(uri.endsWith("/") ||
                uri.endsWith("index") ||
                uri.endsWith("cadastroUsuario") ||
                uri.endsWith("efetuar-cadastro-usuario") ||
                uri.endsWith("efetuar-login") ||
                uri.endsWith("escritor") ||
                uri.endsWith("artigo") ||
                uri.contains("resources")){
            return true;
        }

        if(request.getSession().getAttribute("logado") != null){
            System.out.println(request.getSession().getAttribute("logado"));
            return true;
        }


        response.sendRedirect("/");
        return false;

    }
}

