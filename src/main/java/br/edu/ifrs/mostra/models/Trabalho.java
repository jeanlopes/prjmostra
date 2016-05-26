/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "trabalho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabalho.findAll", query = "SELECT t FROM Trabalho t"),
    @NamedQuery(name = "Trabalho.findByIdTrabalho", query = "SELECT t FROM Trabalho t WHERE t.idTrabalho = :idTrabalho"),
    @NamedQuery(name = "Trabalho.findByNivel", query = "SELECT t FROM Trabalho t WHERE t.nivel = :nivel"),
    @NamedQuery(name = "Trabalho.findByTitulo", query = "SELECT t FROM Trabalho t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "Trabalho.findByTituloOrdenar", query = "SELECT t FROM Trabalho t WHERE t.tituloOrdenar = :tituloOrdenar"),
    @NamedQuery(name = "Trabalho.findByPalavra1", query = "SELECT t FROM Trabalho t WHERE t.palavra1 = :palavra1"),
    @NamedQuery(name = "Trabalho.findByPalavra2", query = "SELECT t FROM Trabalho t WHERE t.palavra2 = :palavra2"),
    @NamedQuery(name = "Trabalho.findByPalavra3", query = "SELECT t FROM Trabalho t WHERE t.palavra3 = :palavra3"),
    @NamedQuery(name = "Trabalho.findByApoiadores", query = "SELECT t FROM Trabalho t WHERE t.apoiadores = :apoiadores"),
    @NamedQuery(name = "Trabalho.findByResumo", query = "SELECT t FROM Trabalho t WHERE t.resumo = :resumo"),
    @NamedQuery(name = "Trabalho.findByResumo2", query = "SELECT t FROM Trabalho t WHERE t.resumo2 = :resumo2"),
    @NamedQuery(name = "Trabalho.findByStatus", query = "SELECT t FROM Trabalho t WHERE t.status = :status"),
    @NamedQuery(name = "Trabalho.findByDataCadastro", query = "SELECT t FROM Trabalho t WHERE t.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Trabalho.findByDataAtualizacao", query = "SELECT t FROM Trabalho t WHERE t.dataAtualizacao = :dataAtualizacao"),
    @NamedQuery(name = "Trabalho.findByIpCadastro", query = "SELECT t FROM Trabalho t WHERE t.ipCadastro = :ipCadastro"),
    @NamedQuery(name = "Trabalho.findByIpAtualizacao", query = "SELECT t FROM Trabalho t WHERE t.ipAtualizacao = :ipAtualizacao"),
    @NamedQuery(name = "Trabalho.findByNota", query = "SELECT t FROM Trabalho t WHERE t.nota = :nota"),
    @NamedQuery(name = "Trabalho.findByPremiado", query = "SELECT t FROM Trabalho t WHERE t.premiado = :premiado"),
    @NamedQuery(name = "Trabalho.findBySeqSessao", query = "SELECT t FROM Trabalho t WHERE t.seqSessao = :seqSessao"),
    @NamedQuery(name = "Trabalho.findByTurno1", query = "SELECT t FROM Trabalho t WHERE t.turno1 = :turno1"),
    @NamedQuery(name = "Trabalho.findByTurno2", query = "SELECT t FROM Trabalho t WHERE t.turno2 = :turno2"),
    @NamedQuery(name = "Trabalho.findByTurno3", query = "SELECT t FROM Trabalho t WHERE t.turno3 = :turno3")})
public class Trabalho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabalho")
    private Integer idTrabalho;
    @Column(name = "nivel")
    private Integer nivel;
    @Size(max = 255, message = "tamanho nao permitido para o campo titulo na tabela trabalho")
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255, message = "tamanho nao permitido para o campo titulo_ordenar na tabela trabalho")
    @Column(name = "titulo_ordenar")
    private String tituloOrdenar;
    @Size(max = 255, message = "tamanho nao permitido para o campo palavra1 na tabela trabalho")
    @Column(name = "palavra1")
    private String palavra1;
    @Size(max = 255, message = "tamanho nao permitido para o campo palavra2 na tabela trabalho")
    @Column(name = "palavra2")
    private String palavra2;
    @Size(max = 255, message = "tamanho nao permitido para o campo palavra3 na tabela trabalho")
    @Column(name = "palavra3")
    private String palavra3;
    @Size(max = 255, message = "tamanho nao permitido para o campo apoiadores na tabela trabalho")
    @Column(name = "apoiadores")
    private String apoiadores;
    @Basic(optional = false)
    @NotNull(message = "resumo nao pode ser nulo na tabela trabalho")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo resumo na tabela trabalho")
    @Column(name = "resumo")
    private String resumo;
    @Basic(optional = false)
    @NotNull(message = "resumo2 nao pode ser nulo na tabela trabalho")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo resumo2 na tabela trabalho")
    @Column(name = "resumo2")
    private String resumo2;
    @Column(name = "status")
    private Integer status;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @Size(max = 255, message = "tamanho nao permitido para o campo ip_cadastro na tabela trabalho")
    @Column(name = "ip_cadastro")
    private String ipCadastro;
    @Size(max = 255, message = "tamanho nao permitido para o campo ip_atualizacao na tabela trabalho")
    @Column(name = "ip_atualizacao")
    private String ipAtualizacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @Column(name = "premiado")
    private Integer premiado;
    @Basic(optional = false)
    @NotNull(message = "nao pode ser null no campo seq_sessao na tabela trabalho")
    @Column(name = "seq_sessao")
    private int seqSessao;
    @Column(name = "turno1")
    private Character turno1;
    @Column(name = "turno2")
    private Character turno2;
    @Column(name = "turno3")
    private Character turno3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabalho")
    private List<TrabalhoOrientadorCampus> trabalhoOrientadorCampusList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabalho")
    private List<TrabalhoAutorCurso> trabalhoAutorCursoList;
    @JoinColumn(name = "fk_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria fkCategoria;
    @JoinColumn(name = "fk_area", referencedColumnName = "id_area")
    @ManyToOne
    private Area fkArea;
    @JoinColumn(name = "fk_sessao", referencedColumnName = "id_sessao")
    @ManyToOne
    private Sessao fkSessao;
    @JoinColumn(name = "fk_modalidade", referencedColumnName = "id_modalidade")
    @ManyToOne
    private Modalidade fkModalidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabalho")
    private List<ParecerTrabalho> parecerTrabalhoList;

    public Trabalho() {
    }

    public Trabalho(Integer idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public Trabalho(Integer idTrabalho, String resumo, String resumo2, int seqSessao) {
        this.idTrabalho = idTrabalho;
        this.resumo = resumo;
        this.resumo2 = resumo2;
        this.seqSessao = seqSessao;
    }

    public Integer getIdTrabalho() {
        return idTrabalho;
    }

    public void setIdTrabalho(Integer idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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

    @XmlTransient
    public List<TrabalhoOrientadorCampus> getTrabalhoOrientadorCampusList() {
        return trabalhoOrientadorCampusList;
    }

    public void setTrabalhoOrientadorCampusList(List<TrabalhoOrientadorCampus> trabalhoOrientadorCampusList) {
        this.trabalhoOrientadorCampusList = trabalhoOrientadorCampusList;
    }

    @XmlTransient
    public List<TrabalhoAutorCurso> getTrabalhoAutorCursoList() {
        return trabalhoAutorCursoList;
    }

    public void setTrabalhoAutorCursoList(List<TrabalhoAutorCurso> trabalhoAutorCursoList) {
        this.trabalhoAutorCursoList = trabalhoAutorCursoList;
    }

    public Categoria getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(Categoria fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    public Area getFkArea() {
        return fkArea;
    }

    public void setFkArea(Area fkArea) {
        this.fkArea = fkArea;
    }

    public Sessao getFkSessao() {
        return fkSessao;
    }

    public void setFkSessao(Sessao fkSessao) {
        this.fkSessao = fkSessao;
    }

    public Modalidade getFkModalidade() {
        return fkModalidade;
    }

    public void setFkModalidade(Modalidade fkModalidade) {
        this.fkModalidade = fkModalidade;
    }

    @XmlTransient
    public List<ParecerTrabalho> getParecerTrabalhoList() {
        return parecerTrabalhoList;
    }

    public void setParecerTrabalhoList(List<ParecerTrabalho> parecerTrabalhoList) {
        this.parecerTrabalhoList = parecerTrabalhoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabalho != null ? idTrabalho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabalho)) {
            return false;
        }
        Trabalho other = (Trabalho) object;
        if ((this.idTrabalho == null && other.idTrabalho != null) || (this.idTrabalho != null && !this.idTrabalho.equals(other.idTrabalho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Trabalho[ idTrabalho=" + idTrabalho + " ]";
    }
    
}
