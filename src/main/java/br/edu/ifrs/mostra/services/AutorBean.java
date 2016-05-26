/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.services;

import br.edu.ifrs.mostra.Exceptions.UsuarioExistenteException;
import br.edu.ifrs.mostra.daos.AutorCursoDao;
import br.edu.ifrs.mostra.daos.AutorDao;
import br.edu.ifrs.mostra.daos.CursoDao;
import br.edu.ifrs.mostra.daos.DBContext;
import br.edu.ifrs.mostra.daos.UsuarioDao;
import br.edu.ifrs.mostra.models.Autor;
import br.edu.ifrs.mostra.models.AutorCurso;
import br.edu.ifrs.mostra.models.AutorCursoPK;
import br.edu.ifrs.mostra.models.Curso;
import br.edu.ifrs.mostra.models.Usuario;
import br.edu.ifrs.mostra.utils.ViolationLogger;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author jean
 */
@Stateless
public class AutorBean {

    private final DBContext context = DBContext.getInstance();
    private static final Logger log = Logger.getLogger(AutorBean.class.getName());
    @Inject
    private AutorDao autorDao;

    @Inject
    private CursoDao cursoDao;

    @Inject
    private AutorCursoDao autorCursoDao;

    @Inject
    private UsuarioDao usuarioDao;

    @Context
    private HttpServletRequest httpRequest;

    public Autor cadastrarAutor(Usuario usuario, Autor autor, int idCurso, FacesContext context) {

        EntityTransaction tx = this.context.em.getTransaction();
        if (!tx.isActive())
            tx.begin();

        try {
            Autor autorOrig = this.autorDao.findByCpf(usuario.getCpf());
            if (autorOrig != null) {
                throw new UsuarioExistenteException("já cadastrado no sistema");
            }
        } catch (UsuarioExistenteException e) {
            context.addMessage("Erro", new FacesMessage("Este usuário já está cadastrado no sistema"));
        }

        try {
            //TODO: descobrir como fazer o spring security ler senha com criptografia
            
            autor.setUsuario(usuario);
            autor.setFkUsuario(null);
            Curso curso = this.cursoDao.findOneById(idCurso);
            
            
            usuario = this.usuarioDao.save(usuario);
            this.context.em.flush();
            autor.setFkUsuario(usuario.getIdUsuario());
            autor.setUsuario(usuario);
            autor = this.autorDao.save(autor);
            
            this.context.em.flush();
            AutorCurso autorCurso = new AutorCurso();
            autorCurso.setCurso(curso);
            autorCurso.setAutor(autor);
            autorCurso.setAutorCursoPK(new AutorCursoPK(autor.getFkUsuario(), curso.getIdCurso()));
            
            
            this.context.em.flush();
            this.autorCursoDao.save(autorCurso);
            tx.commit();
            return autor;
        } catch (ConstraintViolationException | PersistenceException e) {
            
            log.log(Level.SEVERE, e.getMessage());
            ViolationLogger.log(e, log);
            context.addMessage("Erro", new FacesMessage("Não foi possível cadastrar o autor: contate o administrador do site"));
        }
        

        //TODO: enviar e-mail depois de cadastrar o autor
        return null;
    }
    
    public Autor fazerCadastroIncremental(int idCurso, FacesContext context) {
        EntityTransaction tx = this.context.em.getTransaction();
        
        try {
            
            Principal user = context.getExternalContext().getUserPrincipal();
            Autor autor = this.autorDao.findByCpf(user.getName());
            Usuario usuario = this.usuarioDao.findUserByCpf(user.getName());
            
            if (autor != null) {
                context.addMessage("Erro", new FacesMessage("Este usuário já está cadastrado no sistema como autor"));
                throw new UsuarioExistenteException("Esse autor já existe");
            }
            
            autor = new Autor();
            autor.setUsuario(usuario);
            
            Curso curso = this.cursoDao.findOneById(idCurso);
            
            AutorCurso autorCurso = new AutorCurso();
            autorCurso.setAutor(autor);
            autorCurso.setCurso(curso);
            
            this.context.em.persist(autorCurso);
            
            tx.commit();
            return autor;
            
        } catch(Exception e) {
            log.log(Level.SEVERE, "nao foi possivel fazer o cadastro incremental do autor", e);
            context.addMessage("Erro", new FacesMessage("Não foi possivel fazer o cadastro incremental do autor"));
        }
        
        return null;
    }

    public boolean isCurrentUserAutor() {

        if (httpRequest.isUserInRole("autor")) {
            return true;
        }

        return false;
    }
}
