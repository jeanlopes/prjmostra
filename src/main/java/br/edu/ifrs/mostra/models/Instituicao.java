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
@Table(name = "instituicao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instituicao.findAll", query = "SELECT i FROM Instituicao i"),
    @NamedQuery(name = "Instituicao.findByIdInstituicao", query = "SELECT i FROM Instituicao i WHERE i.idInstituicao = :idInstituicao"),
    @NamedQuery(name = "Instituicao.findByNome", query = "SELECT i FROM Instituicao i WHERE i.nome = :nome"),
    @NamedQuery(name = "Instituicao.findBySigla", query = "SELECT i FROM Instituicao i WHERE i.sigla = :sigla"),
    @NamedQuery(name = "Instituicao.findByCidade", query = "SELECT i FROM Instituicao i WHERE i.cidade = :cidade"),
    @NamedQuery(name = "Instituicao.findByEstado", query = "SELECT i FROM Instituicao i WHERE i.estado = :estado"),
    @NamedQuery(name = "Instituicao.findBySite", query = "SELECT i FROM Instituicao i WHERE i.site = :site"),
    @NamedQuery(name = "Instituicao.findByTipo", query = "SELECT i FROM Instituicao i WHERE i.tipo = :tipo")})
public class Instituicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instituicao")
    private int idInstituicao;
    @Basic(optional = false)
    @NotNull(message = "nome nao pode ser nulo na tabela instituicao")
    @Size(min = 1, max = 255, message = "tamanho do nome nao permitido na tabela instituicao")
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull(message = "sigla nao pode ser nula na tabela instituicao")
    @Size(min = 1, max = 255, message = "tamanho da sigla nao permitido na tabela instituicao")
    @Column(name = "sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull(message = "nome da cidade nao pode ser nulo na tabela instituicao")
    @Size(min = 1, max = 255, message = "tamanho de nome de cidade nao permitido na tabela instituicao")
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull(message = "nome de estado nao pode ser nulo na tabela instituicao")
    @Size(min = 1, max = 255, message = "tamanho do nome do estado nao permitido na tabela instituicao")
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull(message = "site nao pode ser nulo na tabela instituicao")
    @Size(min = 1, max = 255, message = "tamanho do campo site nao permitido na tabela instituicao")
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @NotNull(message = "tipo nao pode ser nulo na tabela instituicao")
    @Column(name = "tipo")
    private int tipo;
    @OneToMany(mappedBy = "fkInstituicao")
    private List<Campus> campusList;
    @OneToMany(mappedBy = "fkInstituicao")
    private List<Ouvinte> ouvinteList;

    public Instituicao() {
    }

    public Instituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public Instituicao(int idInstituicao, String nome, String sigla, String cidade, String estado, String site, int tipo) {
        this.idInstituicao = idInstituicao;
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.site = site;
        this.tipo = tipo;
    }

    public int getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(int idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Campus> getCampusList() {
        return campusList;
    }

    public void setCampusList(List<Campus> campusList) {
        this.campusList = campusList;
    }

    @XmlTransient
    public List<Ouvinte> getOuvinteList() {
        return ouvinteList;
    }

    public void setOuvinteList(List<Ouvinte> ouvinteList) {
        this.ouvinteList = ouvinteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituicao)) {
            return false;
        }
        Instituicao other = (Instituicao) object;
        if (this.idInstituicao != other.idInstituicao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Instituicao[ idInstituicao=" + idInstituicao + " ]";
    }
    
}
