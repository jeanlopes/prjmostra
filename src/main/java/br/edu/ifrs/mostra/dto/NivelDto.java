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
public class NivelDto {

    public NivelDto(int idNivel, String nome) {
        this.idNivel = idNivel;
        this.nome = nome;
    }
    
    private int idNivel;
    private String nome;

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
