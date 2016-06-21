/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Categoria;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class CategoriaDao implements Dao<Categoria>{

    @Override
    public List<Categoria> listAll() {
        
        try {
            return context.categoria().toList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar todas as categorias" ,e.getMessage());
        }
        
        return null;
    }

    @Override
    public List<Categoria> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Categoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria update(Categoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
