/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Usuario;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import javax.persistence.PersistenceException;

/**
 *
 * @author jean
 */
public class UsuarioDao implements Dao<Usuario> {
    
    public Usuario findUserByCpf (String cpf) {
        
        try {
            Optional<Usuario> user = context.usuario().where(u -> u.getCpf().equals(cpf)).findOne();
            
            return user.orElse(null);
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel recuperar o usuario pelo cpf", e);
        }
        
        return null;
    }
    
    public boolean hasUserByCPF(String cpf) {
        
        try {
            Optional<Usuario> user = context.usuario().where(u -> u.getCpf().equals(cpf)).findOne();
            
            return user.isPresent();
            
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel recuperar o cpf", e);
        }
        
        return false;
    }
    
    @Override
    public List<Usuario> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario save(Usuario entity) {
        
        try {
        
            context.em.persist(entity);
        } catch (PersistenceException e) {
            
            ViolationLogger.log(e, log);
            log.log(Level.SEVERE, "nao foi possivel cadastrar o usuario no banco", e);
        }
        
        return entity;
    }

    @Override
    public void remove(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario update(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
