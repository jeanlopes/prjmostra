/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.OrientadorCampus;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.jinq.jpa.JPQL;

/**
 *
 * @author jean
 */
public class OrientadorCampusDao implements Dao<OrientadorCampus> {

    public List<OrientadorCampus> findbyOrientadorName(String name) {

        try {
            List<OrientadorCampus> lista = context.orientadorCampus().where(oC -> JPQL.like(oC.getOrientador().getUsuario().getNome(), "%" + name + "%")).toList();
            return lista;
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel encontrar OrientadorCampus pelo nome do orientador", e);
        }
        
        return null;
    }
    
    public OrientadorCampus findOneBy(int idOrientador, int idCampus) {
        
        try {
            
            Optional<OrientadorCampus> orientadorCampus = context.orientadorCampus().where(oc -> 
                                                oc.getOrientadorCampusPK().getFkOrientador() == idOrientador
                                             && oc.getOrientadorCampusPK().getFkCampus() == idCampus ).findOne();
            return orientadorCampus.orElse(null);
            
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel recuperar o orientadorCampus pelos ids");
        }
        
        return null;
    }

    @Override
    public List<OrientadorCampus> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrientadorCampus> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrientadorCampus findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(OrientadorCampus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrientadorCampus update(OrientadorCampus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
