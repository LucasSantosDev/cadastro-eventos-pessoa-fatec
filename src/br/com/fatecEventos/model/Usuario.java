/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecEventos.model;

/**
 *
 * @author lucas
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String senha;
    private String email;
    private String caminhoImagem_usuario;

    public Usuario() {
        this.id = 0;
        this.nome = "";
        this.senha = "";
        this.email = "";
        this.caminhoImagem_usuario = "";
    }
    
    public Usuario(int id, String nome, String senha, String email, String caminhoImagem_usuario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.caminhoImagem_usuario = caminhoImagem_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCaminhoImagem_usuario() {
        return caminhoImagem_usuario;
    }

    public void setCaminhoImagem_usuario(String caminhoImagem_usuario) {
        this.caminhoImagem_usuario = caminhoImagem_usuario;
    }
    
    
}
