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
@Table(name = "modalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modalidade.findAll", query = "SELECT m FROM Modalidade m"),
    @NamedQuery(name = "Modalidade.findByIdModalidade", query = "SELECT m FROM Modalidade m WHERE m.idModalidade = :idModalidade"),
    @NamedQuery(name = "Modalidade.findByNome", query = "SELECT m FROM Modalidade m WHERE m.nome = :nome")})
public class Modalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modalidade")
    private Integer idModalidade;
    @Basic(optional = false)
    @NotNull(message = "nome nao pode ser null na tabela modalidade")
    @Size(min = 1, max = 255, message = "tamanho de campo nao permitido para o campo nome na tabela modalidade")
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "fkModalidade")
    private List<Sessao> sessaoList;
    @OneToMany(mappedBy = "fkModalidade")
    private List<Trabalho> trabalhoList;

    public Modalidade() {
    }

    public Modalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public Modalidade(Integer idModalidade, String nome) {
        this.idModalidade = idModalidade;
        this.nome = nome;
    }

    public Integer getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Sessao> getSessaoList() {
        return sessaoList;
    }

    public void setSessaoList(List<Sessao> sessaoList) {
        this.sessaoList = sessaoList;
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
        hash += (idModalidade != null ? idModalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalidade)) {
            return false;
        }
        Modalidade other = (Modalidade) object;
        if ((this.idModalidade == null && other.idModalidade != null) || (this.idModalidade != null && !this.idModalidade.equals(other.idModalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Modalidade[ idModalidade=" + idModalidade + " ]";
    }
    
}
