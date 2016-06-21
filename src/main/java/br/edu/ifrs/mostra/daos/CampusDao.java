/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Campus;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class CampusDao implements Dao<Campus>{
   

    @Override
    public List<Campus> listAll() {
        
        try {
            return context.campus().toList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar todos os campus", e);
        }
        
        return null;
    }

    @Override
    public List<Campus> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Campus> findAllByInstituicaoId(int instId) {
        
        try {
            return context.campus().where(c -> c.getFkInstituicao().getIdInstituicao()  == instId).toList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar campus pela instituicao", e);
        }
        
        return null;
    }

    @Override
    public Campus findOneById(int id) {
        
        try {
            Optional<Campus> campus = context.campus().where(c -> c.getIdCampus() == id).findOne();
            return campus.orElse(null);
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar campus pelo id", e);
        }
        
        return null;
    }

    @Override
    public void remove(Campus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campus update(Campus entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
