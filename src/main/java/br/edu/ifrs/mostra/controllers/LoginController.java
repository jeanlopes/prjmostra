/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.controllers;

import java.util.logging.Logger;
import java.util.logging.Level;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author jean
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class.getName());
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginController() {
        
    }
    
    public String recuperarSenha() {
        return "/recuperarSenha?faces-redirect=true";
    }
    
    
    public String logout() {
        
        String destination = "/index?faces-redirect=true";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context
                .getExternalContext().getRequest();
        
        try {
            HttpSession session = request.getSession();
            
            session.invalidate();
            request.logout();
        } catch (ServletException e) {
            
            log.log(Level.SEVERE, "Falha ao deslogar usuário");
            destination = "/loginerror?faces-redirect=true";
        }
        
        return destination;
    }
    
}
