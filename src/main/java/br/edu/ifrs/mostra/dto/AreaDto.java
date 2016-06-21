package br.edu.ifrs.mostra.dto;

/**
 *
 * @author jean
 */
public class AreaDto {

    public AreaDto(int idArea, String nome) {
        this.idArea = idArea;
        this.nome = nome;
    }
    
    public AreaDto () {}
    
    private int idArea;
    private String nome;

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
