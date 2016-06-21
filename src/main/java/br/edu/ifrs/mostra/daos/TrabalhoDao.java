/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Trabalho;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class TrabalhoDao implements Dao<Trabalho> {
    
    @Override
    public List<Trabalho> listAll() {
        try {
            List<Trabalho> trabalhos = context.trabalho().toList();
            return trabalhos;
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar todos os trabalhos", e);
        }

        return new ArrayList<>();
        
    }
    
    public List<Trabalho> findByIdAutor(int idAutor) {
        
        try {
            List<Trabalho> trabalhos = context.trabalho()
                    .selectAllList(t -> t.getTrabalhoAutorCursoList())
                    .where(tac -> tac.getAutor().getFkUsuario() == idAutor )
                    .select(tac -> tac.getTrabalho()).toList();
            return trabalhos;
        } catch(Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar trabalhos pelo autor", e);
        }
        
        return null;
    }
    
    public List<Trabalho> findByIdOrientador(int idOrientador) {
        try {
            List<Trabalho> trabalhos = context.trabalho()
                        .selectAllList(t -> t.getTrabalhoOrientadorCampusList())
                        .where(toc -> toc.getOrientador().getFkUsuario() == idOrientador)
                        .select(toc -> toc.getTrabalho()).toList();
            
            return trabalhos;
        } catch(Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar trabalhos pelo orientador", e);
        }
        
        return null;
    }

    @Override
    public List<Trabalho> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trabalho findOneById(int id) {
    
        try {
            Optional<Trabalho> trabalho = context.trabalho().where(t -> t.getIdTrabalho() == id).findOne();
            
            return trabalho.orElse(null);
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel recuperar o trabalho pelo id", e);
        }
        
        return null;
    }

    @Override
    public void remove(Trabalho entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trabalho update(Trabalho entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
