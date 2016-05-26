/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.models.Usuario;
import javax.ejb.Stateless;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author jean
 */
@Stateless
public class LoginBean {

    public void login(Usuario usuario) {
        
        Authentication auth = new UsernamePasswordAuthenticationToken(usuario.getCpf(), usuario.getSenha());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
