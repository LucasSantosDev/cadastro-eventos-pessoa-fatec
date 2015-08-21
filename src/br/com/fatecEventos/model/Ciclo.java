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
public class Ciclo {

    private int num_ciclo;
    
    public Ciclo() {
        num_ciclo = 0;
    }
    
    public Ciclo(int num_ciclo) {
        this.num_ciclo = num_ciclo;
    }

    public int getNum_ciclo() {
        return num_ciclo;
    }

    public void setNum_ciclo(int num_ciclo) {
        this.num_ciclo = num_ciclo;
    }
    
}
