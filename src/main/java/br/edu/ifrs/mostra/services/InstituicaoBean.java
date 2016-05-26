/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.InstituicaoDao;
import br.edu.ifrs.mostra.models.Instituicao;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public String create(@FormParam("nome") String nome,
                              @FormParam("sigla") String sigla,
                              @FormParam("cidade") String cidade,
                              @FormParam("estado") String estado,
                              @FormParam("site") String site,
                              @FormParam("tipo") int tipo) {
        
        Instituicao inst = new Instituicao(0, nome, sigla, cidade, estado, site, tipo);
        inst = this.instituicaoDao.save(inst);
        
        Gson gson = new Gson();
        String newInst = gson.toJson(inst);
        return newInst;
    }
    
}
