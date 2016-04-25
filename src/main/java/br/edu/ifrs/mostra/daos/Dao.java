/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.daos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jean
 * @param <T>
 */
public interface Dao <T extends Serializable> {
    
    List<T> listAll();
    List<T> findById(int id);
    T findOneById(int id);
    T save(T entity);
    void remove (T entity);
    T update (T entity);
    
}
