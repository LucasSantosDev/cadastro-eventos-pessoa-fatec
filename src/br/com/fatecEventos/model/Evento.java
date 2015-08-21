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
public class Evento {

    private int codigo;
    private String nomeEvento;
    private String dataEvento;

    public Evento() {
        codigo = 0;
        nomeEvento = "";
        dataEvento = "";
    }

    public Evento(int codigo, String nomeEvento, String dataEvento) {
        this.codigo = codigo;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }
    
    
    
}
