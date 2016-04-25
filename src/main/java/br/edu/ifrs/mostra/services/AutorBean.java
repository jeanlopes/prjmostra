/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 *
 * @author jean
 */
@Stateless
public class AutorBean {

    @Context
    private HttpServletRequest httpRequest;
    
    
    
    public boolean isCurrentUserAutor() {
        
        if (httpRequest.isUserInRole("autor"))
            return true;
        
        return false;
    }
}
