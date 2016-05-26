/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Instituicao;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author jean
 */
public class InstituicaoDao implements Dao<Instituicao> {

    private final DBContext context = DBContext.getInstance();
    private static final Logger log = Logger.getLogger(InstituicaoDao.class.getName());

    @Override
    public List<Instituicao> listAll() {
        try {
            List<Instituicao> instituicoes = context.instituicao().sortedBy(i -> i.getSigla()).toList();
            return instituicoes;
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar todas as instituicoes", e);
        }

        return new ArrayList<>();
    }

    @Override
    public List<Instituicao> findById(int id) {
        return context.instituicao().toList();
    }

    @Override
    public Instituicao findOneById(int id) {
       Optional<Instituicao> inst = context.instituicao().where(i -> i.getIdInstituicao() == id).findOne();
       
       return inst.orElse(null);
    }

    @Override
    public Instituicao save(Instituicao entity) {
        EntityTransaction tx = context.em.getTransaction();
        tx.begin();
        try {
            context.em.persist(entity);
            tx.commit();
            return entity;
        } catch (IllegalStateException | TransactionRequiredException | QueryTimeoutException e) {

            log.log(Level.SEVERE, "nao foi possivel cadastrar a instituicao", e);

        } catch (PersistenceException e) {

            ViolationLogger.log(e, log);
            log.log(Level.SEVERE, "nao foi possivel cadastrar a instituicao", e);
        }
        
        return null;
    }

    @Override
    public void remove(Instituicao entity) {
        context.em.remove(entity);
    }

    @Override
    public Instituicao update(Instituicao entity) {
        entity = context.em.merge(entity);
        return entity;
    }

}
