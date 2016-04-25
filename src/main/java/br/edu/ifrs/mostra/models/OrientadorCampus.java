/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "orientador_campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrientadorCampus.findAll", query = "SELECT o FROM OrientadorCampus o"),
    @NamedQuery(name = "OrientadorCampus.findBySeq", query = "SELECT o FROM OrientadorCampus o WHERE o.seq = :seq"),
    @NamedQuery(name = "OrientadorCampus.findByFkOrientador", query = "SELECT o FROM OrientadorCampus o WHERE o.orientadorCampusPK.fkOrientador = :fkOrientador"),
    @NamedQuery(name = "OrientadorCampus.findByFkCampus", query = "SELECT o FROM OrientadorCampus o WHERE o.orientadorCampusPK.fkCampus = :fkCampus"),
    @NamedQuery(name = "OrientadorCampus.findByStatus", query = "SELECT o FROM OrientadorCampus o WHERE o.status = :status")})
public class OrientadorCampus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrientadorCampusPK orientadorCampusPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "fk_orientador", referencedColumnName = "fk_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orientador orientador;
    @JoinColumn(name = "fk_campus", referencedColumnName = "id_campus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campus campus;

    public OrientadorCampus() {
    }

    public OrientadorCampus(OrientadorCampusPK orientadorCampusPK) {
        this.orientadorCampusPK = orientadorCampusPK;
    }

    public OrientadorCampus(OrientadorCampusPK orientadorCampusPK, int seq, int status) {
        this.orientadorCampusPK = orientadorCampusPK;
        this.seq = seq;
        this.status = status;
    }

    public OrientadorCampus(int fkOrientador, int fkCampus) {
        this.orientadorCampusPK = new OrientadorCampusPK(fkOrientador, fkCampus);
    }

    public OrientadorCampusPK getOrientadorCampusPK() {
        return orientadorCampusPK;
    }

    public void setOrientadorCampusPK(OrientadorCampusPK orientadorCampusPK) {
        this.orientadorCampusPK = orientadorCampusPK;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orientadorCampusPK != null ? orientadorCampusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrientadorCampus)) {
            return false;
        }
        OrientadorCampus other = (OrientadorCampus) object;
        if ((this.orientadorCampusPK == null && other.orientadorCampusPK != null) || (this.orientadorCampusPK != null && !this.orientadorCampusPK.equals(other.orientadorCampusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.OrientadorCampus[ orientadorCampusPK=" + orientadorCampusPK + " ]";
    }
    
}
