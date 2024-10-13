package fai.cpa.port.impl;

import fai.cpa.entities.UsuarioModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.http.HttpSession;

@Component
public class AutenticationProvider {

    public void autentication(UsuarioModel usuario){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

        HttpSession session = servletRequestAttributes.getRequest().getSession(false);
        session.setAttribute("usuarioAtual", usuario);
    }

}
