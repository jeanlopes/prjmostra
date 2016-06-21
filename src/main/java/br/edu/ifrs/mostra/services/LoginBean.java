/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.UsuarioDao;
import br.edu.ifrs.mostra.models.Usuario;
import java.security.Principal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author jean
 */
@Stateless
public class LoginBean {
    
    @Inject
    private HttpServletRequest httpRequest;
    
    @Inject
    private UsuarioDao usuarioDao;
    
    public void login(Usuario usuario) {
        
        Authentication auth = new UsernamePasswordAuthenticationToken(usuario.getCpf(), usuario.getSenha());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    
    public Usuario getUser() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Usuario u = this.usuarioDao.findUserByCpf(name);
        
        return u;
    }
    
    public void logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        httpRequest.getSession().invalidate();
    }
}
