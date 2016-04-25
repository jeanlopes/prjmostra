/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.UsuarioDao;
import br.edu.ifrs.mostra.utils.ValidaCPF;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jean
 */
@Stateless
@Path("/home")
public class HomeBean {

    @Inject
    private UsuarioDao usuarioDao;
    
    @GET
    @Path("/verificar_cpf/{cpf}")
    @Produces(MediaType.TEXT_PLAIN)
    public String verificarCPF(@PathParam("cpf") String cpf) {
        
        boolean cpfValido = ValidaCPF.isCPF(cpf);
        
        if (!cpfValido) {
            return "invalid";
        } else {
            
            if (usuarioDao.hasUserByCPF(cpf))
                return "true";
            else
                return "false";
            
        }
        
    }
}
