/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2tema1.ej1;

import java.util.Random;

/**
 *
 * @author tema 1 ejercicio 1 Luis Garcia
 */
public class Insertor implements Runnable {

    private RecursoCompartido rc;
    private int num_de_Inserciones;
    
    public Insertor(RecursoCompartido el_rc, int ni) {
        this.rc = el_rc;     
        this.num_de_Inserciones = ni;     
    }

    public void run() {
        int i=1;
        Random rnd = new Random();        
        int numero;
       
        while (i <= this.num_de_Inserciones) {  
            numero = (int)(rnd.nextDouble() * 100 + 1); // genera un entero entre 1 o 100         
            this.rc.insertarenBuffer(numero);           
            i++;
       }
    }

   
}
