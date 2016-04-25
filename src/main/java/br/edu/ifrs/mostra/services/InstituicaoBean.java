/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.InstituicaoDao;
import br.edu.ifrs.mostra.models.Instituicao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jean
 */
@Stateless
@Path("/instituicao")
public class InstituicaoBean {

    @Inject
    private InstituicaoDao instituicaoDao;
    
    
    
    public List<Instituicao> listAll() {
        
        return this.instituicaoDao.listAll();
    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Instituicao create(@PathParam("nome") String nome,
                              @PathParam("sigla") String sigla,
                              @PathParam("cidade") String cidade,
                              @PathParam("estado") String estado,
                              @PathParam("site") String site,
                              @PathParam("tipo") int tipo) {
        
        Instituicao inst = new Instituicao(0, nome, sigla, cidade, estado, site, tipo);
        inst = this.instituicaoDao.save(inst);
        return inst;
    }
    
}
