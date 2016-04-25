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
@Table(name = "autor_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorCurso.findAll", query = "SELECT a FROM AutorCurso a"),
    @NamedQuery(name = "AutorCurso.findByFkAutor", query = "SELECT a FROM AutorCurso a WHERE a.autorCursoPK.fkAutor = :fkAutor"),
    @NamedQuery(name = "AutorCurso.findByFkCurso", query = "SELECT a FROM AutorCurso a WHERE a.autorCursoPK.fkCurso = :fkCurso"),
    @NamedQuery(name = "AutorCurso.findBySeq", query = "SELECT a FROM AutorCurso a WHERE a.seq = :seq"),
    @NamedQuery(name = "AutorCurso.findByStatus", query = "SELECT a FROM AutorCurso a WHERE a.status = :status")})
public class AutorCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorCursoPK autorCursoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "seq")
    private String seq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "fk_curso", referencedColumnName = "id_curso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "fk_autor", referencedColumnName = "fk_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autor autor;

    public AutorCurso() {
    }

    public AutorCurso(AutorCursoPK autorCursoPK) {
        this.autorCursoPK = autorCursoPK;
    }

    public AutorCurso(AutorCursoPK autorCursoPK, String seq, String status) {
        this.autorCursoPK = autorCursoPK;
        this.seq = seq;
        this.status = status;
    }

    public AutorCurso(int fkAutor, int fkCurso) {
        this.autorCursoPK = new AutorCursoPK(fkAutor, fkCurso);
    }

    public AutorCursoPK getAutorCursoPK() {
        return autorCursoPK;
    }

    public void setAutorCursoPK(AutorCursoPK autorCursoPK) {
        this.autorCursoPK = autorCursoPK;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        hash += (autorCursoPK != null ? autorCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorCurso)) {
            return false;
        }
        AutorCurso other = (AutorCurso) object;
        if ((this.autorCursoPK == null && other.autorCursoPK != null) || (this.autorCursoPK != null && !this.autorCursoPK.equals(other.autorCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.AutorCurso[ autorCursoPK=" + autorCursoPK + " ]";
    }
    
}
