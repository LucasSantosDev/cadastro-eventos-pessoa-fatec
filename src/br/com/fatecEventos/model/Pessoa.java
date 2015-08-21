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
public class Pessoa {
    
    private int codigo;
    private String nomePessoa;
    private String emailPessoa;
    private String dataPessoa;
    private String cursoPessoa;
    private String contribuicao;
    private String turnoPessoa;
    private int cicloPessoa;
    private String caminhoImagem;

    public Pessoa() {
        codigo = 0;
        nomePessoa = "";
        emailPessoa = "";
        dataPessoa = "";
        cursoPessoa = "";
        contribuicao = "";
        turnoPessoa = "";
        cicloPessoa = 0;
        caminhoImagem = "";
    }

    public Pessoa(int codigo, String nomePessoa, String emailPessoa, String dataPessoa, String cursoPessoa, String contribuicao, String turnoPessoa, int cicloPessoa, String caminhoImagem) {
        this.codigo = codigo;
        this.nomePessoa = nomePessoa;
        this.emailPessoa = emailPessoa;
        this.dataPessoa = dataPessoa;
        this.cursoPessoa = cursoPessoa;
        this.contribuicao = contribuicao;
        this.turnoPessoa = turnoPessoa;
        this.cicloPessoa = cicloPessoa;
        this.caminhoImagem = caminhoImagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }
    
    public String getDataPessoa() {
        return dataPessoa;
    }

    public void setDataPessoa(String dataPessoa) {
        this.dataPessoa = dataPessoa;
    }

    public String getCursoPessoa() {
        return cursoPessoa;
    }

    public void setCursoPessoa(String cursoPessoa) {
        this.cursoPessoa = cursoPessoa;
    }

    public String getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(String contribuicao) {
        this.contribuicao = contribuicao;
    }
    
    public String getTurnoPessoa() {
        return turnoPessoa;
    }

    public void setTurnoPessoa(String turnoPessoa) {
        this.turnoPessoa = turnoPessoa;
    }

    public int getCicloPessoa() {
        return cicloPessoa;
    }

    public void setCicloPessoa(int cicloPessoa) {
        this.cicloPessoa = cicloPessoa;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
