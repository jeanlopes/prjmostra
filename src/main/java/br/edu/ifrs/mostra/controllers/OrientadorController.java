/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.controllers;

import br.edu.ifrs.mostra.models.Autor;
import br.edu.ifrs.mostra.models.Instituicao;
import br.edu.ifrs.mostra.models.Orientador;
import br.edu.ifrs.mostra.models.Usuario;
import br.edu.ifrs.mostra.services.AutorBean;
import br.edu.ifrs.mostra.services.InstituicaoBean;
import br.edu.ifrs.mostra.services.LoginBean;
import br.edu.ifrs.mostra.services.OrientadorBean;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jean
 */
@Named(value = "orientadorController")
@RequestScoped
public class OrientadorController extends UsuarioController {

    @EJB
    private InstituicaoBean instituicaoBean;

    @EJB
    private OrientadorBean orientadorBean;

    @EJB
    private LoginBean loginBean;

    private List<Instituicao> instituicoes;

    private int idInstituicao;

    private int idCampus;

    /**
     * Creates a new instance of AutorBean
     */
    public OrientadorController() {

    }

    @PostConstruct
    public void init() {
        List<Instituicao> inst = this.instituicaoBean.listAll();

        this.setInstituicoes(inst);
    }
   
    public int getIdCampus() {
        return idCampus;
    }

    public void setIdCurso(int curso) {
        this.idCampus = curso;
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
        
        String campus = context.getExternalContext().getRequestParameterMap().get("campus");
        this.setCpf(context.getExternalContext().getRequestParameterMap().get("cpf"));
        idCampus = Integer.parseInt(campus);

        Usuario usuario = new Usuario();
        usuario.setCpf(this.getCpf());
        usuario.setEmail(this.getEmail());
        usuario.setNome(this.getNome());
        usuario.setSenha(this.getSenha());

        Orientador orientador = new Orientador();
        orientador = this.orientadorBean.cadastrarOrientador(usuario, orientador, idCampus, context);
        if (orientador != null) {
            this.loginBean.login(usuario);
            context.addMessage("Sucesso", new FacesMessage("Dados cadastrados com sucesso"));
            try {
                context.getExternalContext().redirect("/area_do_orientador.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(OrientadorController.class.getName())
                        .log(Level.SEVERE, "nao foi possivel redirecionar o usuario", ex);
            }
        } else {
            context.addMessage("Erro", new FacesMessage("Não foi possível cadastrar o orientador"));
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

                if (this.orientadorBean.isCurrentUserOrientador()) {
                    context.addMessage("Aviso", new FacesMessage("Usuário já cadastrado como orientador"));

                    context.getExternalContext().redirect("/autor/area_do_orientador.xhtml");
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
            Logger.getLogger(OrientadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

