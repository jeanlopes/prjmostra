/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "ouvinte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ouvinte.findAll", query = "SELECT o FROM Ouvinte o"),
    @NamedQuery(name = "Ouvinte.findByFkUsuario", query = "SELECT o FROM Ouvinte o WHERE o.fkUsuario = :fkUsuario"),
    @NamedQuery(name = "Ouvinte.findByTipoOuvinte", query = "SELECT o FROM Ouvinte o WHERE o.tipoOuvinte = :tipoOuvinte"),
    @NamedQuery(name = "Ouvinte.findByOutro", query = "SELECT o FROM Ouvinte o WHERE o.outro = :outro"),
    @NamedQuery(name = "Ouvinte.findByEmpresa", query = "SELECT o FROM Ouvinte o WHERE o.empresa = :empresa")})
public class Ouvinte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message = "fk_usuario nao pode ser null na tabela ouvinte")
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @Basic(optional = false)
    @NotNull(message = "tipo_ouvinte nao pode ser null na tabela ouvinte")
    @Column(name = "tipo_ouvinte")
    private int tipoOuvinte;
    @Size(max = 255, message = "tamanho nao permitido para o campo outro na tabela ouvinte")
    @Column(name = "outro")
    private String outro;
    @Size(max = 255, message = "tamanho nao permitido para o campo empresa na tabela ouvinte")
    @Column(name = "empresa")
    private String empresa;
    @JoinColumn(name = "fk_instituicao", referencedColumnName = "id_instituicao")
    @ManyToOne
    private Instituicao fkInstituicao;
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso fkCurso;
    @JoinColumn(name = "fk_campus", referencedColumnName = "id_campus")
    @ManyToOne
    private Campus fkCampus;

    public Ouvinte() {
    }

    public Ouvinte(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Ouvinte(Integer fkUsuario, int tipoOuvinte) {
        this.fkUsuario = fkUsuario;
        this.tipoOuvinte = tipoOuvinte;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getTipoOuvinte() {
        return tipoOuvinte;
    }

    public void setTipoOuvinte(int tipoOuvinte) {
        this.tipoOuvinte = tipoOuvinte;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Instituicao getFkInstituicao() {
        return fkInstituicao;
    }

    public void setFkInstituicao(Instituicao fkInstituicao) {
        this.fkInstituicao = fkInstituicao;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
        this.fkCurso = fkCurso;
    }

    public Campus getFkCampus() {
        return fkCampus;
    }

    public void setFkCampus(Campus fkCampus) {
        this.fkCampus = fkCampus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fkUsuario != null ? fkUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ouvinte)) {
            return false;
        }
        Ouvinte other = (Ouvinte) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Ouvinte[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
