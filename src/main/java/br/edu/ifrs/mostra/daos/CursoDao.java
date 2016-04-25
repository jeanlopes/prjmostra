/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Curso;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author jean
 */
public class CursoDao implements Dao<Curso> {

    private DBContext context = DBContext.getInstance();
    private static final Logger log = Logger.getLogger(CursoDao.class.getName());
    
    @Override
    public List<Curso> listAll() {
        
        return this.context.curso().toList();
    }
    
    public List<Curso> findAllByCampusId(int idCampus) {
        return this.context.curso().where(c -> c.getFkCampus() == idCampus).toList();
    } 

    @Override
    public List<Curso> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso save(Curso entity) {
        
        this.context.em.persist(entity);
        this.context.em.flush();
        
        return entity;
    }

    @Override
    public void remove(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso update(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
