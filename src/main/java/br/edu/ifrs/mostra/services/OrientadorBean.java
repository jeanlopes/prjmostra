/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.Exceptions.UsuarioExistenteException;
import br.edu.ifrs.mostra.daos.CampusDao;
import br.edu.ifrs.mostra.daos.DBContext;
import br.edu.ifrs.mostra.daos.OrientadorCampusDao;
import br.edu.ifrs.mostra.daos.OrientadorDao;
import br.edu.ifrs.mostra.daos.UsuarioDao;
import br.edu.ifrs.mostra.models.Campus;
import br.edu.ifrs.mostra.models.Orientador;
import br.edu.ifrs.mostra.models.OrientadorCampus;
import br.edu.ifrs.mostra.models.OrientadorCampusPK;
import br.edu.ifrs.mostra.models.Usuario;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;

/**
 *
 * @author jean
 */
@Stateless
public class OrientadorBean {

    private final DBContext context = DBContext.getInstance();
    private static final Logger log = Logger.getLogger(OrientadorBean.class.getName());
    
    @Inject
    private OrientadorDao orientadorDao;

    @Inject
    private CampusDao campusDao;

    @Inject
    private OrientadorCampusDao orientadorCampusDao;

    @Inject
    private UsuarioDao usuarioDao;

    @Context
    private HttpServletRequest httpRequest;

    public Orientador cadastrarOrientador(Usuario usuario, Orientador orientador, int idCampus, FacesContext context) {

        EntityTransaction tx = this.context.em.getTransaction();
        if (!tx.isActive())
            tx.begin();

        try {
            Orientador orientadorOrig = this.orientadorDao.findByCpf(usuario.getCpf());
            if (orientadorOrig != null) {
                throw new UsuarioExistenteException("já cadastrado no sistema");
            }
        } catch (UsuarioExistenteException e) {
            context.addMessage("Erro", new FacesMessage("Este usuário já está cadastrado no sistema"));
        }

        try {
            //TODO: descobrir como fazer o spring security ler senha com criptografia
            
            orientador.setUsuario(usuario);
            orientador.setFkUsuario(null);
            Campus campus = this.campusDao.findOneById(idCampus);
            
            
            usuario = this.usuarioDao.save(usuario);
            this.context.em.flush();
            orientador.setFkUsuario(usuario.getIdUsuario());
            orientador.setUsuario(usuario);
            orientador = this.orientadorDao.save(orientador);
            
            this.context.em.flush();
            OrientadorCampus orientadorCampus = new OrientadorCampus();
            orientadorCampus.setCampus(campus);
            orientadorCampus.setOrientador(orientador);
            orientadorCampus.setOrientadorCampusPK(new OrientadorCampusPK(orientador.getFkUsuario(), campus.getIdCampus()));
            
            
            this.context.em.flush();
            this.orientadorCampusDao.save(orientadorCampus);
            tx.commit();
            return orientador;
        } catch (ConstraintViolationException | PersistenceException e) {
            
            log.log(Level.SEVERE, e.getMessage());
            ViolationLogger.log(e, log);
            context.addMessage("Erro", new FacesMessage("Não foi possível cadastrar o orientador: contate o administrador do site"));
        }
        

        //TODO: enviar e-mail depois de cadastrar o orientador
        return null;
    }
    
    public Orientador fazerCadastroIncremental(int idCampus, FacesContext context) {
        EntityTransaction tx = this.context.em.getTransaction();
        
        try {
            
            Principal user = context.getExternalContext().getUserPrincipal();
            Orientador orientador = this.orientadorDao.findByCpf(user.getName());
            Usuario usuario = this.usuarioDao.findUserByCpf(user.getName());
            
            if (orientador != null) {
                context.addMessage("Erro", new FacesMessage("Este usuário já está cadastrado no sistema como orientador"));
                throw new UsuarioExistenteException("Esse orientador já existe");
            }
            
            orientador = new Orientador();
            orientador.setUsuario(usuario);
            
            Campus campus = this.campusDao.findOneById(idCampus);
            
            OrientadorCampus orientadorCampus = new OrientadorCampus();
            orientadorCampus.setOrientador(orientador);
            orientadorCampus.setCampus(campus);
            
            this.context.em.persist(orientadorCampus);
            
            tx.commit();
            return orientador;
            
        } catch(Exception e) {
            log.log(Level.SEVERE, "nao foi possivel fazer o cadastro incremental do orientador", e);
            context.addMessage("Erro", new FacesMessage("Não foi possivel fazer o cadastro incremental do orientador"));
        }
        
        return null;
    }

    public boolean isCurrentUserOrientador() {

        if (httpRequest.isUserInRole("orientador")) {
            return true;
        }

        return false;
    }
}
