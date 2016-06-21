/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.dto;

import br.edu.ifrs.mostra.models.Modalidade;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jean
 */
public class TrabalhoDto {
    
    private Integer idTrabalho;
    
    private String titulo;
    
    private String tituloOrdenar;
    
    private String palavra1;
    
    private String palavra2;
    
    private String palavra3;
    
    private String apoiadores;
    
    private String resumo;
    
    private String resumo2;
    
    private Integer status;
    
    private Date dataCadastro;
    
    private Date dataAtualizacao;
    
    private String ipCadastro;
    
    private String ipAtualizacao;
    
    private Double nota;
    
    private Integer premiado;
    
    private int seqSessao;
    
    private Character turno1;
    
    private Character turno2;
    
    private Character turno3;
    
    private CategoriaDto categoria;
    
    private AreaDto area;
    
    private int fkSessao;
    
    private ModalidadeDto modalidade;
    
    private NivelDto nivel;
    
    List<AutorCursoDto> listaAutores;
    List<OrientadorCampusDto> listaOrientadores;

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public ModalidadeDto getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeDto modalidade) {
        this.modalidade = modalidade;
    }

    public NivelDto getNivel() {
        return nivel;
    }

    public void setNivel(NivelDto nivel) {
        this.nivel = nivel;
    }

    public List<AutorCursoDto> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<AutorCursoDto> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public List<OrientadorCampusDto> getListaOrientadores() {
        return listaOrientadores;
    }

    public void setListaOrientadores(List<OrientadorCampusDto> listaOrientadores) {
        this.listaOrientadores = listaOrientadores;
    }

    public Integer getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(Integer idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloOrdenar() {
        return tituloOrdenar;
    }

    public void setTituloOrdenar(String tituloOrdenar) {
        this.tituloOrdenar = tituloOrdenar;
    }

    public String getPalavra1() {
        return palavra1;
    }

    public void setPalavra1(String palavra1) {
        this.palavra1 = palavra1;
    }

    public String getPalavra2() {
        return palavra2;
    }

    public void setPalavra2(String palavra2) {
        this.palavra2 = palavra2;
    }

    public String getPalavra3() {
        return palavra3;
    }

    public void setPalavra3(String palavra3) {
        this.palavra3 = palavra3;
    }

    public String getApoiadores() {
        return apoiadores;
    }

    public void setApoiadores(String apoiadores) {
        this.apoiadores = apoiadores;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getResumo2() {
        return resumo2;
    }

    public void setResumo2(String resumo2) {
        this.resumo2 = resumo2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getIpCadastro() {
        return ipCadastro;
    }

    public void setIpCadastro(String ipCadastro) {
        this.ipCadastro = ipCadastro;
    }

    public String getIpAtualizacao() {
        return ipAtualizacao;
    }

    public void setIpAtualizacao(String ipAtualizacao) {
        this.ipAtualizacao = ipAtualizacao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getPremiado() {
        return premiado;
    }

    public void setPremiado(Integer premiado) {
        this.premiado = premiado;
    }

    public int getSeqSessao() {
        return seqSessao;
    }

    public void setSeqSessao(int seqSessao) {
        this.seqSessao = seqSessao;
    }

    public Character getTurno1() {
        return turno1;
    }

    public void setTurno1(Character turno1) {
        this.turno1 = turno1;
    }

    public Character getTurno2() {
        return turno2;
    }

    public void setTurno2(Character turno2) {
        this.turno2 = turno2;
    }

    public Character getTurno3() {
        return turno3;
    }

    public void setTurno3(Character turno3) {
        this.turno3 = turno3;
    }

    public int getFkSessao() {
        return fkSessao;
    }

    public void setFkSessao(int fkSessao) {
        this.fkSessao = fkSessao;
    }
    
    
    
}
