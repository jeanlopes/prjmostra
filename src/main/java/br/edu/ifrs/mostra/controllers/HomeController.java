package br.edu.ifrs.mostra.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jean
 */
@Named(value = "homeController")
@RequestScoped
public class HomeController {

    /**
     * Creates a new instance of HomeBean
     */
    public HomeController() {
        try {
            this.env = (Context)new InitialContext().lookup("java:comp/env");
            this.etapaInscricaoAutor = (boolean)this.env.lookup("ETAPA_INSCRICAO_AUTOR");
            this.etapaInscricaoOrientador = (boolean)this.env.lookup("ETAPA_INSCRICAO_ORIENTADOR");
        } catch (NamingException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private Context env;
    private boolean etapaInscricaoAutor;
    private boolean etapaInscricaoOrientador;

    public boolean isEtapaInscricaoAutor() {
        return etapaInscricaoAutor;
    }

    public void setEtapaInscricaoAutor(boolean etapaInscricaoAutor) {
        this.etapaInscricaoAutor = etapaInscricaoAutor;
    }

    public boolean isEtapaInscricaoOrientador() {
        return etapaInscricaoOrientador;
    }

    public void setEtapaInscricaoOrientador(boolean etapaInscricaoOrientador) {
        this.etapaInscricaoOrientador = etapaInscricaoOrientador;
    }
    
    
}
