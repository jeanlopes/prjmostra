/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.mostra.controllers;

import br.edu.ifrs.mostra.utils.ValidaCPF;
/**
 *
 * @author jean
 */
public abstract class UsuarioController {
    
    private String cpf;
    private String nome;
    private String email;
    private String confirmar_email;
    private String senha;
    private String confirmar_senha;
    private boolean registered;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isValidCpf() {
        
        return ValidaCPF.isCPF(this.getCpf());
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmar_email() {
        return confirmar_email;
    }

    public void setConfirmar_email(String confirmar_email) {
        this.confirmar_email = confirmar_email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmar_senha() {
        return confirmar_senha;
    }

    public void setConfirmar_senha(String confirmar_senha) {
        this.confirmar_senha = confirmar_senha;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
    
    
    
}
