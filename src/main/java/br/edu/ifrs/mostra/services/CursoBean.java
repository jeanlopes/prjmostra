/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

//import br.edu.ifrs.mostra.daos.CampusDao;
import br.edu.ifrs.mostra.daos.CursoDao;
import br.edu.ifrs.mostra.models.Curso;
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
@Path("/curso")
public class CursoBean {

    @Inject
    private CursoDao dao;
    
    //@Inject
    //private CampusDao campusDao;
        
    
    @GET
    @Path("/get_campus_list/{id_instituicao}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Curso> listAll(@PathParam("id_instituicao") int idCampus ) {
        return dao.findAllByCampusId(idCampus);
    }
            
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Curso create(@PathParam("nome") String nome, 
                        @PathParam("nivel") int nivel, 
                        @PathParam("campus") int campus) {
        
        
        Curso curso = new Curso();
        curso.setFkCampus(campus);
        curso.setNome(nome);
        curso.setNivel(nivel);
        
        return curso;
    }
}
