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
public class ModalidadeDto {

    public ModalidadeDto(int idModalidade, String nome) {
        this.idModalidade = idModalidade;
        this.nome = nome;
    }
    
    public ModalidadeDto() {}
    
    private int idModalidade;
    private String nome;

    public int getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(int idModalidade) {
        this.idModalidade = idModalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
