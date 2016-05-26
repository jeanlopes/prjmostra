/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByCpf", query = "SELECT u FROM Usuario u WHERE u.cpf = :cpf"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull(message = "cpf nao pode ser nulo")
    @Size(min = 1, max = 255)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull(message = "nome nao pode ser nulo")
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull(message = "senha nao pode ser nula")
    @Size(min = 1, max = 255)
    @Column(name = "senha")
    private String senha;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="endereco de email invalido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "email nao pode ser null")
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Revisor revisor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Orientador orientador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Autor autor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Avaliador avaliador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Voluntario voluntario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Organizador organizador;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String cpf, String nome, String senha, String email) {
        this.idUsuario = idUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
