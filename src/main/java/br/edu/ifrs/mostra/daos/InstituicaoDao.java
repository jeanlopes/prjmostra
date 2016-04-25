/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Instituicao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean
 */
public class InstituicaoDao implements Dao<Instituicao>{

    private final DBContext context = DBContext.getInstance();
    private static final Logger log = Logger.getLogger(InstituicaoDao.class.getName());

    @Override
    public List<Instituicao> listAll() {
        try {
            return context.instituicao().sortedBy(i -> i.getSigla()).toList();
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
        return context.em.find(Instituicao.class, id);
    }

    @Override
    public Instituicao save(Instituicao entity) {
        context.em.persist(entity);
        context.em.flush();
        return entity;
    }

    @Override
    public void remove(Instituicao entity) {
        context.em.remove(entity);
    }

    @Override
    public Instituicao update(Instituicao entity) {
        entity = context.em.merge(entity);
        context.em.flush();
        return entity;
    }

       
    
}
