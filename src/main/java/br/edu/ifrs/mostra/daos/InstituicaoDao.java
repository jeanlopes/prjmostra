/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Instituicao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class InstituicaoDao implements Dao<Instituicao> {


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
    public void remove(Instituicao entity) {
        context.em.remove(entity);
    }

    @Override
    public Instituicao update(Instituicao entity) {
        entity = context.em.merge(entity);
        return entity;
    }

}
