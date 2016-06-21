/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import static br.edu.ifrs.mostra.daos.Dao.context;
import static br.edu.ifrs.mostra.daos.Dao.log;
import br.edu.ifrs.mostra.models.Orientador;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.jinq.jpa.JPQL;

/**
 *
 * @author jean
 */
public class OrientadorDao implements Dao<Orientador> {

    public List<Orientador> findByName(String name) {
        
        try {
            List<Orientador> orientadores = context.orientador().where(a -> JPQL.like(a.getUsuario().getNome(), name)).toList();
            return orientadores;
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar o orientador pelo nome", e);
        }
        return null;
    }
        
    @Override
    public List<Orientador> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Orientador> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orientador findOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Orientador entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orientador update(Orientador entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Orientador findByCpf(String cpf) {
        
        try {
            
            Optional<Orientador> orientador = context.orientador()
                    .where(o -> o.getUsuario().getCpf().equals(cpf)).findOne();
            
            return orientador.orElse(null);
            
        } catch (Exception e) {
            log.log(Level.SEVERE, "nao foi possivel buscar o orientador pelo cpf", e);
        }
        return null;
    }
    
}
