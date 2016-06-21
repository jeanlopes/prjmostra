/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.controllers;

import br.edu.ifrs.mostra.models.Autor;
import br.edu.ifrs.mostra.models.Instituicao;
import br.edu.ifrs.mostra.models.Trabalho;
import br.edu.ifrs.mostra.models.Usuario;
import br.edu.ifrs.mostra.services.AutorBean;
import br.edu.ifrs.mostra.services.InstituicaoBean;
import br.edu.ifrs.mostra.services.LoginBean;
import br.edu.ifrs.mostra.services.TrabalhoBean;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

/**
 *
 * @author jean
 */
@Named(value = "autorController")
@RequestScoped
public class AutorController extends UsuarioController {

    @EJB
    private InstituicaoBean instituicaoBean;

    @EJB
    private AutorBean autorBean;

    @EJB
    private LoginBean loginBean;
    
    @EJB
    private TrabalhoBean trabalhoBean;

    private List<Instituicao> instituicoes;
    
    private List<Trabalho> trabalhos;

    private int idInstituicao;

    private int idCurso;

    /**
     * Creates a new instance of AutorBean
     */
    public AutorController() {

    }

    @PostConstruct
    public void init() {
        List<Instituicao> inst = this.instituicaoBean.listAll();
        
        this.setInstituicoes(inst);
        
        List<Trabalho> trabs = this.trabalhoBean.listarTrabalhoPeloAutor();
        this.setTrabalhos(trabs);
    }

    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }
    
    
   
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int curso) {
        this.idCurso = curso;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public int getIdInstituicao() {
        return this.idInstituicao;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {

        this.instituicoes = instituicoes;
    }

    public List<Instituicao> getInstituicoes() {

        return this.instituicoes;
    }

    public void fazerInscricao() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (!isValidSenha()) {
            context.addMessage("Erro", new FacesMessage("As senhas não conferem!"));
            return;
        }

        if (!isValidEmail()) {
            context.addMessage("Erro", new FacesMessage("Os e-mails não conferem!"));
            return;
        }
        
        String curso = context.getExternalContext().getRequestParameterMap().get("curso");
        this.setCpf(context.getExternalContext().getRequestParameterMap().get("cpf"));
        idCurso = Integer.parseInt(curso);

        Usuario usuario = new Usuario();
        usuario.setCpf(this.getCpf());
        usuario.setEmail(this.getEmail());
        usuario.setNome(this.getNome());
        usuario.setSenha(this.getSenha());

        Autor autor = new Autor();
        autor = this.autorBean.cadastrarAutor(usuario, autor, idCurso, context);
        if (autor != null) {
            this.loginBean.login(usuario);
            context.addMessage("Sucesso", new FacesMessage("Dados cadastrados com sucesso"));
            try {
                context.getExternalContext().redirect("/area_do_autor.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(AutorController.class.getName())
                        .log(Level.SEVERE, "nao foi possivel redirecionar o usuario", ex);
            }
        } else {
            context.addMessage("Erro", new FacesMessage("Não foi possível cadastrar o autor"));
        }

    }

    public void fazerInscricaoIncremental() {

    }

    public void inscricao() {

        FacesContext context = FacesContext.getCurrentInstance();

        String cpf = context.getExternalContext().getRequestParameterValuesMap().get("cpf")[0];
        this.setCpf(cpf);
        try {
            if (context.getExternalContext().getRemoteUser() != null) {

                if (this.autorBean.isCurrentUserAutor()) {
                    context.addMessage("Aviso", new FacesMessage("Usuário já cadastrado como autor"));

                    context.getExternalContext().redirect("/autor/area_do_autor.xhtml");
                } else {
                    context.getExternalContext().redirect("usuario/autor/inscricao_incremental.xhtml");
                }

            } else if (this.isValidCpf()) {

                this.setRegistered(false);

            } else {
                context.addMessage("Erro", new FacesMessage("CPF inválido ou não informado"));
                context.getExternalContext().redirect("index.xhtml");

            }

        } catch (IOException ex) {
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
