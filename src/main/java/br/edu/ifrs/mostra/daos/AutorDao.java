/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Autor;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;
import org.jinq.jpa.JPQL;

/**
 *
 * @author jean
 */
public class AutorDao implements Dao<Autor> {


    public Autor findByCpf(String cpf) {

        try {
            
            Optional<Autor> autor = context.autor().where(a -> a.getUsuario().getCpf().equals(cpf)).findAny();
            
            return autor.orElse(null);
        
        } catch (NoResultException e) {
            return null;
        }
        catch (IllegalStateException | TransactionRequiredException | QueryTimeoutException e) {

            log.log(Level.SEVERE, "nao foi possivel buscar o autor", e);

        } catch (PersistenceException e) {

            ViolationLogger.log(e, log);

            log.log(Level.SEVERE, "nao foi possivel buscar o autor", e);
        }

        return null;

    }
    
    public List<Autor> findByName(String name) {
        
        try {
            List<Autor> autores = context.autor().where(a -> JPQL.like(a.getUsuario().getNome(), name)).toList();
            return autores;
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar o autor pelo nome", e);
        }
        return null;
    }

    @Override
    public List<Autor> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autor findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Autor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autor update(Autor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
