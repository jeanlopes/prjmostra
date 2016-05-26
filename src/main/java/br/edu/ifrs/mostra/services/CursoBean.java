/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

//import br.edu.ifrs.mostra.daos.CampusDao;
import br.edu.ifrs.mostra.daos.CursoDao;
import br.edu.ifrs.mostra.models.Curso;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
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
    @Path("/get_curso_list/{id_campus}")
    @Produces(MediaType.APPLICATION_JSON)
    public String listAll(@PathParam("id_campus") int idCampus ) {
        
        List<br.edu.ifrs.mostra.models.Curso> cursos = dao.findAllByCampusId(idCampus);
        List<Curso> cursosDto = new ArrayList<>(cursos.size());
        
        cursos.stream().forEach( (curso) -> {
            Curso cursoDto = new Curso();
            cursoDto.setIdCurso(curso.getIdCurso());
            cursoDto.setNome(curso.getNome());
            cursoDto.setNivel(curso.getNivel());
            cursoDto.setFkCampus(curso.getFkCampus());
            
            cursosDto.add(cursoDto);
        });
        
        Gson gson = new Gson();
        
        String listaJson = gson.toJson(cursosDto);
        
        return listaJson;
    }
            
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@FormParam("nome") String nome, 
                        @FormParam("nivel") int nivel, 
                        @FormParam("campus") int campus) {
        
        
        Curso curso = new Curso();
        curso.setFkCampus(campus);
        curso.setNome(nome);
        curso.setNivel(nivel);
        
        curso = this.dao.save(curso);
        
        Gson gson = new Gson();
        String cursoJson = gson.toJson(curso);
        
        return cursoJson;
    }
}
