/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Campus;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author jean
 */
public class CampusDao implements Dao<Campus>{
    
    private final DBContext context = DBContext.getInstance();
    private static final Logger log = Logger.getLogger(CampusDao.class.getName());

    @Override
    public List<Campus> listAll() {
        return this.context.campus().toList();
    }

    @Override
    public List<Campus> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Campus> findAllByInstituicaoId(int instId) {
        
        return this.context.campus().where(c -> c.getFkInstituicao().getIdInstituicao()  == instId).toList();
    }

    @Override
    public Campus findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campus save(Campus entity) {
        
        context.em.persist(entity);
        context.em.flush();
        
        return entity;
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
