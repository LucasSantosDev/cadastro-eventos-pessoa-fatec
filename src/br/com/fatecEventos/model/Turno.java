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
public class Turno {

    private String nm_turno;
    
    public Turno() {
        nm_turno = "";
    }
    
    public Turno(String nm_turno) {
        this.nm_turno = nm_turno;
    }

    public String getNm_turno() {
        return nm_turno;
    }

    public void setNm_turno(String nm_turno) {
        this.nm_turno = nm_turno;
    }
    
}
