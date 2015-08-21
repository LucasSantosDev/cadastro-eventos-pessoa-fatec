/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecEventos.logic;

/**
 *
 * @author lucas
 * @date   07/05/2015
 */
import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.swing.JLabel;  
/** 
* 
* @author AJFILHO 
*/  
public class AtualizadorHorario extends Thread {  
  
    private JLabel hr;  
    private boolean mostrarData, teste;
  
    public AtualizadorHorario(JLabel hora) {  
        this.hr = hora;  
    }  
  
    public void mostrarData(boolean mostrar) {  
        if (mostrar) {  
            this.mostrarData = true;  
            this.teste = false;  
        } else {  
            this.mostrarData = false;  
            this.teste = false;  
        }  
    }  
    
    public void mostrarData(boolean mostrar, boolean t) {  
        if (mostrar && t) {  
            this.mostrarData = true;
            this.teste = true;
            
        } else {  
            this.mostrarData = false;  
            this.teste = false;  
        }  
    }
  
    @Override  
    public void run() {  
        try {  
            while (true) {  
                Date d = new Date();  
                StringBuffer data = new StringBuffer();  
                if (mostrarData == true && teste == false) {  
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");  
                    data.append(sdfData.format(d));  
                    data.append(" - ");  
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
                    this.hr.setText("Hora: " + sdf.format(d));  
                }
                else if (mostrarData == true && teste == true) {  
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");  
                    data.append(sdfData.format(d));  
                    data.append(" - ");  
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
                    this.hr.setText("Data: " + data.toString().substring(0, 10));  
                }  
                Thread.sleep(1000);  
                this.hr.revalidate();  
            }  
        } catch (InterruptedException ex) {  
            System.out.println("Problema na atualização da data/hora");  
            ex.printStackTrace();  
        }  
    }  
}  
