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
@Table(name = "trabalho_autor_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabalhoAutorCurso.findAll", query = "SELECT t FROM TrabalhoAutorCurso t"),
    @NamedQuery(name = "TrabalhoAutorCurso.findByFkTrabalho", query = "SELECT t FROM TrabalhoAutorCurso t WHERE t.trabalhoAutorCursoPK.fkTrabalho = :fkTrabalho"),
    @NamedQuery(name = "TrabalhoAutorCurso.findByFkAutor", query = "SELECT t FROM TrabalhoAutorCurso t WHERE t.trabalhoAutorCursoPK.fkAutor = :fkAutor"),
    @NamedQuery(name = "TrabalhoAutorCurso.findBySeq", query = "SELECT t FROM TrabalhoAutorCurso t WHERE t.seq = :seq"),
    @NamedQuery(name = "TrabalhoAutorCurso.findByEmailTrabalho", query = "SELECT t FROM TrabalhoAutorCurso t WHERE t.emailTrabalho = :emailTrabalho")})
public class TrabalhoAutorCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrabalhoAutorCursoPK trabalhoAutorCursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seq")
    private int seq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_trabalho")
    private String emailTrabalho;
    @JoinColumn(name = "fk_trabalho", referencedColumnName = "id_trabalho", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabalho trabalho;
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso fkCurso;
    @JoinColumn(name = "fk_autor", referencedColumnName = "fk_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autor autor;

    public TrabalhoAutorCurso() {
    }

    public TrabalhoAutorCurso(TrabalhoAutorCursoPK trabalhoAutorCursoPK) {
        this.trabalhoAutorCursoPK = trabalhoAutorCursoPK;
    }

    public TrabalhoAutorCurso(TrabalhoAutorCursoPK trabalhoAutorCursoPK, int seq, String emailTrabalho) {
        this.trabalhoAutorCursoPK = trabalhoAutorCursoPK;
        this.seq = seq;
        this.emailTrabalho = emailTrabalho;
    }

    public TrabalhoAutorCurso(int fkTrabalho, int fkAutor) {
        this.trabalhoAutorCursoPK = new TrabalhoAutorCursoPK(fkTrabalho, fkAutor);
    }

    public TrabalhoAutorCursoPK getTrabalhoAutorCursoPK() {
        return trabalhoAutorCursoPK;
    }

    public void setTrabalhoAutorCursoPK(TrabalhoAutorCursoPK trabalhoAutorCursoPK) {
        this.trabalhoAutorCursoPK = trabalhoAutorCursoPK;
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

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
        this.fkCurso = fkCurso;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trabalhoAutorCursoPK != null ? trabalhoAutorCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabalhoAutorCurso)) {
            return false;
        }
        TrabalhoAutorCurso other = (TrabalhoAutorCurso) object;
        if ((this.trabalhoAutorCursoPK == null && other.trabalhoAutorCursoPK != null) || (this.trabalhoAutorCursoPK != null && !this.trabalhoAutorCursoPK.equals(other.trabalhoAutorCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.TrabalhoAutorCurso[ trabalhoAutorCursoPK=" + trabalhoAutorCursoPK + " ]";
    }
    
}
