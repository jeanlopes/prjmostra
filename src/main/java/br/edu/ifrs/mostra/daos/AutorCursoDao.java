/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.AutorCurso;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.jinq.jpa.JPQL;
import org.jinq.orm.stream.JinqStream;

/**
 *
 * @author jean
 */
public class AutorCursoDao implements Dao<AutorCurso> {
    
    public List<AutorCurso> findByAutorName(String name) {
        
        try {
            
            List<AutorCurso> autoresCursos = context.autorCurso().where(ac -> JPQL.like(ac.getAutor().getUsuario().getNome(),"%" +  name + "%")).toList();
            return autoresCursos;
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar o autorCurso pelo nome do autor", e);
        }
        
        return null;
    }
    
    @Override
    public List<AutorCurso> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AutorCurso> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public AutorCurso findOneBy(int idAutor, int idCurso) {
        
        try {
            
            Optional<AutorCurso> autorCurso = context.autorCurso()
                    .where(ac -> ac.getAutorCursoPK().getFkAutor() == idAutor 
                            && ac.getAutorCursoPK().getFkCurso() == idCurso  )
                    .findOne();
            
            return autorCurso.orElse(null);
            
        }catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar o AutorCurso", e);
            
        }
        
        return null;
     }

    @Override
    public AutorCurso findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getMaxSeq(int idAutor) {
        
        String seq = context.autorCurso().where(ac -> ac.getAutor().getUsuario().getIdUsuario() == idAutor).max(ac -> ac.getSeq());
        
        return Integer.parseInt(seq);
    }

    @Override
    public AutorCurso save(AutorCurso entity) {
        try {
            int seq;
            if (entity.getAutor().getUsuario().getIdUsuario() != null) {
                seq = entity.getAutor().getUsuario().getIdUsuario();
                
            } else 
                seq = 1;
            entity.setSeq(Integer.toString(seq));
            
            entity.setStatus(Integer.toString(1));
            context.em.persist(entity);
        } catch (PersistenceException e) {
            log.log(Level.SEVERE, "nao foi possivel cadastrar AutorCurso ao banco", e);
            ViolationLogger.log(e, log);
        }
        
        return entity;
    }

    @Override
    public void remove(AutorCurso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AutorCurso update(AutorCurso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
