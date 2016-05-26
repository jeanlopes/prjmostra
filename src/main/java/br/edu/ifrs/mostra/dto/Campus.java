/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.dto;

/**
 *
 * @author jean
 */
public class Campus {
    
    private static final long serialVersionUID = 1L;
    
    private Integer idCampus;
    private String nome;
    private String cidade;
    private int fkInstituicao;

    public Integer getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(Integer idCampus) {
        this.idCampus = idCampus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getFkInstituicao() {
        return fkInstituicao;
    }

    public void setFkInstituicao(int fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
    }
    
    
    
}
