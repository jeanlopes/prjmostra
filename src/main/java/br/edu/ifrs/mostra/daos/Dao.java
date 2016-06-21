/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author jean
 * @param <T>
 */
public interface Dao <T extends Serializable> {
    
    final DBContext context = DBContext.getInstance();
    static final Logger log = Logger.getLogger(Dao.class.getName());
    
    List<T> listAll();
    List<T> findById(int id);
    T findOneById(int id);
    //T save(T entity);
    default public T save (T entity) {
      EntityTransaction tx = context.em.getTransaction();
        tx.begin();
        try {
            context.em.persist(entity);
            tx.commit();
            context.em.flush();
            return entity;
        } catch (IllegalStateException | TransactionRequiredException | QueryTimeoutException e) {

            log.log(Level.SEVERE, "nao foi possivel cadastrar a entidade " + entity.getClass().getName() , e);

        } catch (PersistenceException e) {

            ViolationLogger.log(e, log);
            log.log(Level.SEVERE, "nao foi possivel cadastrar a entidade " + entity.getClass().getName() , e);
        }
        
        return null;  
    }
    
    void remove (T entity);
    T update (T entity);
    
}
