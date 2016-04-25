/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.CampusDao;
import br.edu.ifrs.mostra.daos.InstituicaoDao;
import br.edu.ifrs.mostra.models.Campus;
import br.edu.ifrs.mostra.models.Instituicao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
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
@Path("/campus")
public class CampusBean {

    @Inject 
    private CampusDao dao;
    
    @Inject 
    private InstituicaoDao instDao;
    
    @GET
    @Path("/get_campus_list/{id_instituicao}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Campus> listAll(@PathParam("id_instituicao") int idInst ) {
        return dao.findAllByInstituicaoId(idInst);
    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Campus create(@PathParam("nome") String nome, 
                         @PathParam("cidade") String cidade, 
                         @PathParam("insituicao") int instituicao) {
        
        Campus campus = new Campus();
        campus.setNome(nome);
        campus.setCidade(cidade);
        
        Instituicao inst = instDao.findOneById(instituicao);
        campus.setFkInstituicao(inst);
        
        campus = dao.save(campus);
        
        return campus;
    }
}
