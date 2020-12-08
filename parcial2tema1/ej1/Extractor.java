/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2tema1.ej1;

/**
 *
 * @author tema 1 ejercicio 1 Luis Garcia
 */
public class Extractor implements Runnable {

    private RecursoCompartido rc;
    private int num_extracciones;
    
    public Extractor(RecursoCompartido el_rc, int ne) {
        this.rc = el_rc;  
        this.num_extracciones=  ne;       
    }

    public void run() 
    {           
        int i=0;
        while (i<=this.num_extracciones) 
        {           
            this.rc.extraerdeBuffer(); 
            i++;                     
        }
    }

   
}
