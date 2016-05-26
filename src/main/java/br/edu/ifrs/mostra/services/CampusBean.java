/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.daos.CampusDao;
import br.edu.ifrs.mostra.daos.InstituicaoDao;
import br.edu.ifrs.mostra.dto.Campus;
import br.edu.ifrs.mostra.models.Instituicao;
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
 * REST Web Service
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
    public String listAll(@PathParam("id_instituicao") int idInst ) {
        
        List<br.edu.ifrs.mostra.models.Campus> campusList = dao.findAllByInstituicaoId(idInst);
        
        List<Campus> campusDtoList = new ArrayList<>(campusList.size());
        campusList.stream().forEach((campus) -> { 
        
            Campus campusDto = new Campus();
            campusDto.setIdCampus(campus.getIdCampus());
            campusDto.setCidade(campus.getCidade());
            campusDto.setNome(campus.getNome());
            campusDto.setFkInstituicao(campus.getFkInstituicao().getIdInstituicao());
            
            campusDtoList.add(campusDto);
        });
        Gson gson = new Gson();
        String jsonList = gson.toJson(campusDtoList);
        return jsonList;
    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@FormParam("nome") String nome, 
                         @FormParam("cidade") String cidade, 
                         @FormParam("instituicao") int instituicao) {
        
        br.edu.ifrs.mostra.models.Campus campus = new br.edu.ifrs.mostra.models.Campus();
        campus.setNome(nome);
        campus.setCidade(cidade);
        
        Instituicao inst = instDao.findOneById(instituicao);
        campus.setFkInstituicao(inst);
        
        campus = dao.save(campus);
        Campus campusDto = new Campus();
        campusDto.setIdCampus(campus.getIdCampus());
        campusDto.setNome(campus.getNome());
        campusDto.setCidade(campus.getCidade());
        campusDto.setFkInstituicao(campus.getFkInstituicao().getIdInstituicao());
        
        Gson gson = new Gson();
        String campusJson = gson.toJson(campusDto);
        
        return campusJson;
    }
}
