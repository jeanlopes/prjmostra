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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "voluntario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voluntario.findAll", query = "SELECT v FROM Voluntario v"),
    @NamedQuery(name = "Voluntario.findByFkUsuario", query = "SELECT v FROM Voluntario v WHERE v.fkUsuario = :fkUsuario"),
    @NamedQuery(name = "Voluntario.findByObservacoes", query = "SELECT v FROM Voluntario v WHERE v.observacoes = :observacoes"),
    @NamedQuery(name = "Voluntario.findByManha", query = "SELECT v FROM Voluntario v WHERE v.manha = :manha"),
    @NamedQuery(name = "Voluntario.findByTarde", query = "SELECT v FROM Voluntario v WHERE v.tarde = :tarde"),
    @NamedQuery(name = "Voluntario.findByNoite", query = "SELECT v FROM Voluntario v WHERE v.noite = :noite"),
    @NamedQuery(name = "Voluntario.findByTelefone1", query = "SELECT v FROM Voluntario v WHERE v.telefone1 = :telefone1"),
    @NamedQuery(name = "Voluntario.findByTelefone2", query = "SELECT v FROM Voluntario v WHERE v.telefone2 = :telefone2"),
    @NamedQuery(name = "Voluntario.findByTelefone3", query = "SELECT v FROM Voluntario v WHERE v.telefone3 = :telefone3"),
    @NamedQuery(name = "Voluntario.findByPresenca", query = "SELECT v FROM Voluntario v WHERE v.presenca = :presenca"),
    @NamedQuery(name = "Voluntario.findByStatus", query = "SELECT v FROM Voluntario v WHERE v.status = :status")})
public class Voluntario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_usuario")
    private Integer fkUsuario;
    @Size(max = 200)
    @Column(name = "observacoes")
    private String observacoes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "manha")
    private String manha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tarde")
    private String tarde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "noite")
    private String noite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefone1")
    private String telefone1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefone2")
    private String telefone2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telefone3")
    private String telefone3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presenca")
    private boolean presenca;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso fkCurso;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Voluntario() {
    }

    public Voluntario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Voluntario(Integer fkUsuario, String manha, String tarde, String noite, String telefone1, String telefone2, String telefone3, boolean presenca) {
        this.fkUsuario = fkUsuario;
        this.manha = manha;
        this.tarde = tarde;
        this.noite = noite;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.presenca = presenca;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getManha() {
        return manha;
    }

    public void setManha(String manha) {
        this.manha = manha;
    }

    public String getTarde() {
        return tarde;
    }

    public void setTarde(String tarde) {
        this.tarde = tarde;
    }

    public String getNoite() {
        return noite;
    }

    public void setNoite(String noite) {
        this.noite = noite;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public boolean getPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
        this.fkCurso = fkCurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Voluntario)) {
            return false;
        }
        Voluntario other = (Voluntario) object;
        if ((this.fkUsuario == null && other.fkUsuario != null) || (this.fkUsuario != null && !this.fkUsuario.equals(other.fkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Voluntario[ fkUsuario=" + fkUsuario + " ]";
    }
    
}
