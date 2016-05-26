/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campus.findAll", query = "SELECT c FROM Campus c"),
    @NamedQuery(name = "Campus.findByIdCampus", query = "SELECT c FROM Campus c WHERE c.idCampus = :idCampus"),
    @NamedQuery(name = "Campus.findByNome", query = "SELECT c FROM Campus c WHERE c.nome = :nome"),
    @NamedQuery(name = "Campus.findByCidade", query = "SELECT c FROM Campus c WHERE c.cidade = :cidade")})
public class Campus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_campus")
    private Integer idCampus;
    @Size(max = 255, message = "tamanho nao permitido para o campo nome na tabela campus")
    @Column(name = "nome")
    @NotNull(message = "nome nao pode ser null na tabela campus")
    private String nome;
    @Basic(optional = false)
    @NotNull(message = "cidade nao pode ser null na tabela campus")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo cidade na tabela campus")
    @Column(name = "cidade")
    private String cidade;
    @OneToMany(mappedBy = "fkCampus")
    private List<Revisor> revisorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campus")
    private List<TrabalhoOrientadorCampus> trabalhoOrientadorCampusList;
    @JoinColumn(name = "fk_instituicao", referencedColumnName = "id_instituicao")
    @ManyToOne
    @NotNull(message = "fkInstituicao nao pode ser null na tabela campus")
    private Instituicao fkInstituicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campus")
    private List<OrientadorCampus> orientadorCampusList;
    @OneToMany(mappedBy = "fkCampus")
    private List<Ouvinte> ouvinteList;
    @OneToMany(mappedBy = "fkCampus")
    private List<Avaliador> avaliadorList;

    public Campus() {
    }

    public Campus(Integer idCampus) {
        this.idCampus = idCampus;
    }

    public Campus(Integer idCampus, String cidade) {
        this.idCampus = idCampus;
        this.cidade = cidade;
    }

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

    @XmlTransient
    public List<Revisor> getRevisorList() {
        return revisorList;
    }

    public void setRevisorList(List<Revisor> revisorList) {
        this.revisorList = revisorList;
    }

    @XmlTransient
    public List<TrabalhoOrientadorCampus> getTrabalhoOrientadorCampusList() {
        return trabalhoOrientadorCampusList;
    }

    public void setTrabalhoOrientadorCampusList(List<TrabalhoOrientadorCampus> trabalhoOrientadorCampusList) {
        this.trabalhoOrientadorCampusList = trabalhoOrientadorCampusList;
    }

    public Instituicao getFkInstituicao() {
        return fkInstituicao;
    }

    public void setFkInstituicao(Instituicao fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
    }

    @XmlTransient
    public List<OrientadorCampus> getOrientadorCampusList() {
        return orientadorCampusList;
    }

    public void setOrientadorCampusList(List<OrientadorCampus> orientadorCampusList) {
        this.orientadorCampusList = orientadorCampusList;
    }

    @XmlTransient
    public List<Ouvinte> getOuvinteList() {
        return ouvinteList;
    }

    public void setOuvinteList(List<Ouvinte> ouvinteList) {
        this.ouvinteList = ouvinteList;
    }

    @XmlTransient
    public List<Avaliador> getAvaliadorList() {
        return avaliadorList;
    }

    public void setAvaliadorList(List<Avaliador> avaliadorList) {
        this.avaliadorList = avaliadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCampus != null ? idCampus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campus)) {
            return false;
        }
        Campus other = (Campus) object;
        if ((this.idCampus == null && other.idCampus != null) || (this.idCampus != null && !this.idCampus.equals(other.idCampus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Campus[ idCampus=" + idCampus + " ]";
    }
    
}
