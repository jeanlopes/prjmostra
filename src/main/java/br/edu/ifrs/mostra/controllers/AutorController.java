/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.controllers;

import br.edu.ifrs.mostra.models.Instituicao;
import br.edu.ifrs.mostra.models.Campus;
import br.edu.ifrs.mostra.models.Curso;
import br.edu.ifrs.mostra.services.AutorBean;
import br.edu.ifrs.mostra.services.InstituicaoBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;

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
    
    private List<SelectItem> instituicoes;
    
    private List<SelectItem> campusList;
    
    private List<SelectItem> cursoList;
    
    private Instituicao instituicao;
    
    private Campus campus;   
    
    private Curso curso;


    /**
     * Creates a new instance of AutorBean
     */
    public AutorController() {

    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<SelectItem> getCampusList() {
        return campusList;
    }

    public void setCampusList(List<SelectItem> campusList) {
        this.campusList = campusList;
    }

    public List<SelectItem> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<SelectItem> cursoList) {
        this.cursoList = cursoList;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
    
    public Instituicao getInstituicao() {
        return this.instituicao;
    }

    public void setInstituicoes(List<Instituicao> instituicoes) {
        List<SelectItem> itens;
        itens = new ArrayList<>(this.instituicoes.size());
        
        instituicoes.stream().forEach((inst) -> {
            itens.add(new SelectItem(inst.getIdInstituicao(), inst.getNome()));
        });
    }
    
    public List<SelectItem> getInstituicoes() {
        
        return this.instituicoes;
    }
    
    public void fazerInscricao() {
        
    }

    public void inscricao() {

        FacesContext context = FacesContext.getCurrentInstance();
        
        String cpf = context.getExternalContext().getRequestParameterValuesMap().get("cpf")[0];
        this.setCpf(cpf);
        try {
            if (context.getExternalContext().getRemoteUser() != null) {

                if (this.autorBean.isCurrentUserAutor()) {
                    context.addMessage("Aviso", new FacesMessage("Usuário já cadastrado como autor"));

                    context.getExternalContext().redirect("/autor/areaDoAutor.xhtml");
                } else {
                    context.getExternalContext().redirect("usuario/autor/inscricao_incremental.xhtml");
                }

            } else if (this.isValidCpf()) {

                this.setRegistered(false);
                this.setInstituicoes(this.instituicaoBean.listAll());
                
            } else {
                context.addMessage("Erro", new FacesMessage("CPF inválido ou não informado"));
                context.getExternalContext().redirect("index.xhtml");
                
            }

        } catch (IOException ex) {
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
