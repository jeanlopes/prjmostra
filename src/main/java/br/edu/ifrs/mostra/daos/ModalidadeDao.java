/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Modalidade;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class ModalidadeDao implements Dao<Modalidade>{

    @Override
    public List<Modalidade> listAll() {
        
        try {
            return context.modalidade().toList();
            
        } catch (Exception e) {
            log.log(Level.SEVERE , "nao foi possível listar as modalidades",e.getMessage());
        }
        
        return null;
    }

    @Override
    public List<Modalidade> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Modalidade findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Modalidade entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Modalidade update(Modalidade entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
