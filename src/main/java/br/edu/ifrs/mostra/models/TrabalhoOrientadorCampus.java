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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "trabalho_orientador_campus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabalhoOrientadorCampus.findAll", query = "SELECT t FROM TrabalhoOrientadorCampus t"),
    @NamedQuery(name = "TrabalhoOrientadorCampus.findByFkTrabalho", query = "SELECT t FROM TrabalhoOrientadorCampus t WHERE t.trabalhoOrientadorCampusPK.fkTrabalho = :fkTrabalho"),
    @NamedQuery(name = "TrabalhoOrientadorCampus.findByFkOrientador", query = "SELECT t FROM TrabalhoOrientadorCampus t WHERE t.trabalhoOrientadorCampusPK.fkOrientador = :fkOrientador"),
    @NamedQuery(name = "TrabalhoOrientadorCampus.findByFkCampus", query = "SELECT t FROM TrabalhoOrientadorCampus t WHERE t.trabalhoOrientadorCampusPK.fkCampus = :fkCampus"),
    @NamedQuery(name = "TrabalhoOrientadorCampus.findBySeq", query = "SELECT t FROM TrabalhoOrientadorCampus t WHERE t.seq = :seq"),
    @NamedQuery(name = "TrabalhoOrientadorCampus.findByEmailTrabalho", query = "SELECT t FROM TrabalhoOrientadorCampus t WHERE t.emailTrabalho = :emailTrabalho")})
public class TrabalhoOrientadorCampus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabalhoOrientadorCampusPK trabalhoOrientadorCampusPK;
    @Basic(optional = false)
    @NotNull(message = "seq nao pode ser nula na tabela trabalho_orientador_campus")
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @NotNull(message = "email_trabalho nao pode ser nulo na tabela trabalho_orientador_campus")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo email_trabalho na tabela trabalho_orientador_campus")
    @Column(name = "email_trabalho")
    private String emailTrabalho;
    @JoinColumn(name = "fk_orientador", referencedColumnName = "fk_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orientador orientador;
    @JoinColumn(name = "fk_trabalho", referencedColumnName = "id_trabalho", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabalho trabalho;
    @JoinColumn(name = "fk_campus", referencedColumnName = "id_campus", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campus campus;

    public TrabalhoOrientadorCampus() {
    }

    public TrabalhoOrientadorCampus(TrabalhoOrientadorCampusPK trabalhoOrientadorCampusPK) {
        this.trabalhoOrientadorCampusPK = trabalhoOrientadorCampusPK;
    }

    public TrabalhoOrientadorCampus(TrabalhoOrientadorCampusPK trabalhoOrientadorCampusPK, int seq, String emailTrabalho) {
        this.trabalhoOrientadorCampusPK = trabalhoOrientadorCampusPK;
        this.seq = seq;
        this.emailTrabalho = emailTrabalho;
    }

    public TrabalhoOrientadorCampus(int fkTrabalho, int fkOrientador, int fkCampus) {
        this.trabalhoOrientadorCampusPK = new TrabalhoOrientadorCampusPK(fkTrabalho, fkOrientador, fkCampus);
    }

    public TrabalhoOrientadorCampusPK getTrabalhoOrientadorCampusPK() {
        return trabalhoOrientadorCampusPK;
    }

    public void setTrabalhoOrientadorCampusPK(TrabalhoOrientadorCampusPK trabalhoOrientadorCampusPK) {
        this.trabalhoOrientadorCampusPK = trabalhoOrientadorCampusPK;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getEmailTrabalho() {
        return emailTrabalho;
    }

    public void setEmailTrabalho(String emailTrabalho) {
        this.emailTrabalho = emailTrabalho;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
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
        hash += (trabalhoOrientadorCampusPK != null ? trabalhoOrientadorCampusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabalhoOrientadorCampus)) {
            return false;
        }
        TrabalhoOrientadorCampus other = (TrabalhoOrientadorCampus) object;
        if ((this.trabalhoOrientadorCampusPK == null && other.trabalhoOrientadorCampusPK != null) || (this.trabalhoOrientadorCampusPK != null && !this.trabalhoOrientadorCampusPK.equals(other.trabalhoOrientadorCampusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.TrabalhoOrientadorCampus[ trabalhoOrientadorCampusPK=" + trabalhoOrientadorCampusPK + " ]";
    }
    
}
