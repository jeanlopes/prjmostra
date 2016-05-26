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
public class Curso {
     
    private Integer idCurso;
    private Integer fkCampus;
    private String nome;
    private int nivel;

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getFkCampus() {
        return fkCampus;
    }

    public void setFkCampus(Integer fkCampus) {
        this.fkCampus = fkCampus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
