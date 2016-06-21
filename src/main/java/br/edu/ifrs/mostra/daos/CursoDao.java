/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Curso;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class CursoDao implements Dao<Curso> {

    @Override
    public List<Curso> listAll() {
        try {
            return context.curso().toList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar os cursos", e);
        }
        
        return null;
    }

    public List<Curso> findAllByCampusId(int idCampus) {
        
        try {
            return context.curso().where(c -> c.getFkCampus() == idCampus).toList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar os cursos pelo campus", e);
        }
        
        return null;
    }

    @Override
    public List<Curso> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso findOneById(int id) {

        try {
            Curso curso = context.curso().where(c -> c.getIdCurso() == id).getOnlyValue();

            return curso;

        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel encontrar o curso pelo id", e);
        } 

        return null;
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
