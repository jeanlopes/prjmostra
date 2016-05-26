/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByIdArea", query = "SELECT a FROM Area a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "Area.findByNome", query = "SELECT a FROM Area a WHERE a.nome = :nome")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Basic(optional = false)
    @NotNull(message = "nome da area nao pode ser nulo")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo nome na tabela area")
    @Column(name = "nome")
    private String nome;
    @JoinTable(name = "avaliador_area", joinColumns = {
        @JoinColumn(name = "fk_area", referencedColumnName = "id_area")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_avaliador", referencedColumnName = "fk_usuario")})
    @ManyToMany
    private List<Avaliador> avaliadorList;
    @OneToMany(mappedBy = "fkArea")
    private List<Trabalho> trabalhoList;

    public Area() {
    }

    public Area(Integer idArea) {
        this.idArea = idArea;
    }

    public Area(Integer idArea, String nome) {
        this.idArea = idArea;
        this.nome = nome;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Avaliador> getAvaliadorList() {
        return avaliadorList;
    }

    public void setAvaliadorList(List<Avaliador> avaliadorList) {
        this.avaliadorList = avaliadorList;
    }

    @XmlTransient
    public List<Trabalho> getTrabalhoList() {
        return trabalhoList;
    }

    public void setTrabalhoList(List<Trabalho> trabalhoList) {
        this.trabalhoList = trabalhoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Area[ idArea=" + idArea + " ]";
    }
    
}
