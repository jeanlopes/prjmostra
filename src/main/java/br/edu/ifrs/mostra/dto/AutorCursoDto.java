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
public class AutorCursoDto {

    public AutorCursoDto(String nome, int idAutor, int idCurso, String nomeCurso) {
        this.nome = nome;
        this.idAutor = idAutor;
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
    }
    
    public AutorCursoDto () {}
    
    private String nome;
    private int idAutor;
    private int idCurso;
    private String nomeCurso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    
    
}
