/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Curso;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author jean
 */
public class CursoDao implements Dao<Curso> {

    private final DBContext context = DBContext.getInstance();
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

        //try {
            Curso curso = this.context.curso().where(c -> c.getIdCurso() == id).getOnlyValue();

            return curso;

        //} 

        //return null;
    }

    @Override
    public Curso save(Curso entity) {
        EntityTransaction tx = context.em.getTransaction();
        tx.begin();

        try {
            this.context.em.persist(entity);
            tx.commit();
        } catch (IllegalStateException | TransactionRequiredException | QueryTimeoutException e) {
            tx.rollback();
            log.log(Level.SEVERE, "nao foi possivel cadastrar o curso", e);

        } catch (PersistenceException e) {
            tx.rollback();
            ViolationLogger.log(e, log);

            log.log(Level.SEVERE, "nao foi possivel cadastrar o curso", e);
        }

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
