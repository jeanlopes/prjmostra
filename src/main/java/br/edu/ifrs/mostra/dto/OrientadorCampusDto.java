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
public class OrientadorCampusDto {

    public OrientadorCampusDto(int idCampus, String nomeCampus, int idOrientador, String nome) {
        this.idCampus = idCampus;
        this.nomeCampus = nomeCampus;
        this.idOrientador = idOrientador;
        this.nome = nome;
    }
    
    public OrientadorCampusDto(){ };
    
    
    private int idCampus;
    private String nomeCampus;
    private int idOrientador;
    private String nome;

    public int getIdOrientador() {
        return idOrientador;
    }

    public void setIdOrientador(int idOrientador) {
        this.idOrientador = idOrientador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(int idCampus) {
        this.idCampus = idCampus;
    }

    public String getNomeCampus() {
        return nomeCampus;
    }

    public void setNomeCampus(String nomeCampus) {
        this.nomeCampus = nomeCampus;
    }
    
    
}
