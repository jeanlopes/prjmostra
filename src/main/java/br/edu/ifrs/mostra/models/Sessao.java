/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jean
 */
@Entity
@Table(name = "sessao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessao.findAll", query = "SELECT s FROM Sessao s"),
    @NamedQuery(name = "Sessao.findByIdSessao", query = "SELECT s FROM Sessao s WHERE s.idSessao = :idSessao"),
    @NamedQuery(name = "Sessao.findByNumero", query = "SELECT s FROM Sessao s WHERE s.numero = :numero"),
    @NamedQuery(name = "Sessao.findByNome", query = "SELECT s FROM Sessao s WHERE s.nome = :nome"),
    @NamedQuery(name = "Sessao.findBySala", query = "SELECT s FROM Sessao s WHERE s.sala = :sala"),
    @NamedQuery(name = "Sessao.findByNomeSala", query = "SELECT s FROM Sessao s WHERE s.nomeSala = :nomeSala"),
    @NamedQuery(name = "Sessao.findByAndar", query = "SELECT s FROM Sessao s WHERE s.andar = :andar"),
    @NamedQuery(name = "Sessao.findByNomeAndar", query = "SELECT s FROM Sessao s WHERE s.nomeAndar = :nomeAndar"),
    @NamedQuery(name = "Sessao.findByData", query = "SELECT s FROM Sessao s WHERE s.data = :data"),
    @NamedQuery(name = "Sessao.findByHoraIni", query = "SELECT s FROM Sessao s WHERE s.horaIni = :horaIni"),
    @NamedQuery(name = "Sessao.findByHoraFim", query = "SELECT s FROM Sessao s WHERE s.horaFim = :horaFim"),
    @NamedQuery(name = "Sessao.findByStatus", query = "SELECT s FROM Sessao s WHERE s.status = :status")})
public class Sessao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sessao")
    private Integer idSessao;
    @Basic(optional = false)
    @NotNull(message = "numero nao pode ser null na tabela sessao")
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull(message = "nome nao pode ser null na tabela sessao")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo nome na tabela sessao")
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull(message = "sala nao pode ser null na tabela sessao")
    @Column(name = "sala")
    private int sala;
    @Basic(optional = false)
    @NotNull(message = "nome_sala nao pode ser null na tabela sessao")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo nome_sala na tabela sessao")
    @Column(name = "nome_sala")
    private String nomeSala;
    @Basic(optional = false)
    @NotNull(message = "andar nao pode ser null na tabela sessao")
    @Column(name = "andar")
    private int andar;
    @Basic(optional = false)
    @NotNull(message = "nome_andar nao pode ser null na tabela sessao")
    @Size(min = 1, max = 255, message = "tamanho nao permitido para o campo nome_andar na tabela sessao")
    @Column(name = "nome_andar")
    private String nomeAndar;
    @Basic(optional = false)
    @NotNull(message = "data nao pode ser null na tabela sessao")
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull(message = "hora_ini nao pode ser null na tabela sessao")
    @Column(name = "hora_ini")
    @Temporal(TemporalType.TIME)
    private Date horaIni;
    @Basic(optional = false)
    @NotNull(message = "hora_fim nao pode ser null na tabela sessao")
    @Column(name = "hora_fim")
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @Basic(optional = false)
    @NotNull(message = "status nao pode ser null na tabela sessao")
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessao")
    private List<AvaliadorSessao> avaliadorSessaoList;
    @JoinColumn(name = "fk_modalidade", referencedColumnName = "id_modalidade")
    @ManyToOne
    private Modalidade fkModalidade;
    @OneToMany(mappedBy = "fkSessao")
    private List<Trabalho> trabalhoList;

    public Sessao() {
    }

    public Sessao(Integer idSessao) {
        this.idSessao = idSessao;
    }

    public Sessao(Integer idSessao, int numero, String nome, int sala, String nomeSala, int andar, String nomeAndar, Date data, Date horaIni, Date horaFim, int status) {
        this.idSessao = idSessao;
        this.numero = numero;
        this.nome = nome;
        this.sala = sala;
        this.nomeSala = nomeSala;
        this.andar = andar;
        this.nomeAndar = nomeAndar;
        this.data = data;
        this.horaIni = horaIni;
        this.horaFim = horaFim;
        this.status = status;
    }

    public Integer getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Integer idSessao) {
        this.idSessao = idSessao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getNomeAndar() {
        return nomeAndar;
    }

    public void setNomeAndar(String nomeAndar) {
        this.nomeAndar = nomeAndar;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Date horaIni) {
        this.horaIni = horaIni;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<AvaliadorSessao> getAvaliadorSessaoList() {
        return avaliadorSessaoList;
    }

    public void setAvaliadorSessaoList(List<AvaliadorSessao> avaliadorSessaoList) {
        this.avaliadorSessaoList = avaliadorSessaoList;
    }

    public Modalidade getFkModalidade() {
        return fkModalidade;
    }

    public void setFkModalidade(Modalidade fkModalidade) {
        this.fkModalidade = fkModalidade;
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
        hash += (idSessao != null ? idSessao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessao)) {
            return false;
        }
        Sessao other = (Sessao) object;
        if ((this.idSessao == null && other.idSessao != null) || (this.idSessao != null && !this.idSessao.equals(other.idSessao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifrs.mostra.models.Sessao[ idSessao=" + idSessao + " ]";
    }
    
}