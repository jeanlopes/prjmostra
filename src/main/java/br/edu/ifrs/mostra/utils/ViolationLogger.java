/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.utils;

import java.util.logging.Level;
import javax.validation.ConstraintViolationException;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author jean
 */
public class ViolationLogger {

    public static void log(Exception e, Logger log) {
        
        Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                
                log.log(Level.SEVERE, "#################################### VIOLACOES!!!! ###############################");
                
                ((ConstraintViolationException) t).getConstraintViolations().forEach(c -> {
                    
                    log.log(Level.SEVERE, "VIOLACAO!!!!!!!! " + c.getMessage() );
                    log.log(Level.SEVERE, "VIOLACAO!!!!!!!!" + c.getMessageTemplate());
                    log.log(Level.SEVERE, "VIOLACAO!!!!!!!!" + c.getConstraintDescriptor().getMessageTemplate());
                    log.log(Level.SEVERE, "VIOLACAO!!!!!!!!" + c.getPropertyPath().toString());
                    
                });
                
                log.log(Level.SEVERE, "##################################################################################");
                log.log(Level.SEVERE, "##################################################################################");
                log.log(Level.SEVERE, "##################################################################################");
                log.log(Level.SEVERE, "##################################################################################");
                log.log(Level.SEVERE, "##################################################################################");
                log.log(Level.SEVERE, "##################################################################################");
                log.log(Level.SEVERE, "##################################################################################");
                
                
            }
        
    }
}
