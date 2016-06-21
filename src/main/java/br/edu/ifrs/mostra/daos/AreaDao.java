/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import br.edu.ifrs.mostra.models.Area;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author jean
 */
public class AreaDao implements Dao<Area> {

    @Override
    public List<Area> listAll() {
        try {
            return context.area().toList();
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel listar todas as areas" , e.getMessage());
        }
        
        return null;
    }

    @Override
    public List<Area> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Area findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Area entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Area update(Area entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
