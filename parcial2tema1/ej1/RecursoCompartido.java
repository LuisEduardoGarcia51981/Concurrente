/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2tema1.ej1;

import java.util.ArrayList;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author tema 1 ejercicio 1 Luis Garcia
 */
public class RecursoCompartido {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    private ArrayList<Integer> buffer1 = new ArrayList<Integer>();
    private ArrayList<Integer> buffer2 = new ArrayList<Integer>();
    private int id_buffer_insert = 1;
    private boolean no_hay_datos= true;
    Semaphore semInsertar; // semaforo que correponde a los hilos que escriben datos en los buffers, // semaforo binario
    Semaphore semExtraer; // semaforo para el hilo que imprime// semaforo binario
    Lock miCerrojo=new ReentrantLock();
    
    public RecursoCompartido()
    {

        semInsertar = new Semaphore(1);
        semExtraer = new Semaphore(0);

    }

    public void insertarenBuffer(int  dato) {

        try {
            semInsertar.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }      
        if (buffer1.isEmpty() && buffer2.isEmpty()){no_hay_datos=true;}
        else {no_hay_datos=false;}

        if (id_buffer_insert == 1) // buffer 1 de insercion
        {
            buffer1.add(dato);
            System.out.println(ANSI_BLUE+Thread.currentThread().getName()+": inserto el valor "+dato+" en el buffer 1"+ANSI_RESET );
        } else // buffer 2 de insercion
        {
            buffer2.add(dato);
            System.out.println(ANSI_BLUE+Thread.currentThread().getName()+": inserto el valor "+dato+" en el buffer 2"+ANSI_RESET);
        }        
        if (no_hay_datos){semExtraer.release(); }                
        semInsertar.release();
    }
    private void imprimirBuffer1() 
    {   miCerrojo.lock(); 
        if (! buffer1.isEmpty()) 
        {
            int dato=buffer1.get(0);
            buffer1.remove(0); // lo elimino del buffer2
            System.out.println(ANSI_GREEN+Thread.currentThread().getName()+": imprimiendo dato del buffer1: "+dato+ANSI_RESET);
        }        
        miCerrojo.unlock(); 
    }
    private  void imprimirBuffer2() 
    {   miCerrojo.lock();      
        if (! buffer2.isEmpty()) 
        {
            int dato=buffer2.get(0);
            buffer2.remove(0); // lo elimino del buffer2
            System.out.println(ANSI_GREEN+Thread.currentThread().getName()+": imprimiendo dato del buffer2: "+dato+ANSI_RESET);
        }        
        miCerrojo.unlock(); 
    }

    public void extraerdeBuffer() {        
        try {
            semExtraer.acquire();
        } catch (InterruptedException e) {           
            e.printStackTrace();
        }          
        if (id_buffer_insert==1) // buffer 1 de insercion, por lo tanto de extraccion es el 2
        {
            if (! buffer2.isEmpty())
            {
                this.imprimirBuffer2();
            } 
            else            
            {
                // hacemos la oscilacion: insert en el buffer2 y extraccion en el buffer1
                id_buffer_insert=2; 
                this.imprimirBuffer1();
            }         
        }
        else // buffer 2 de insercion, por lo tanto de extraccion es el 1
        {
            if (! buffer1.isEmpty())
            {
                this.imprimirBuffer1();                
            }
            else            
            {// hacemos la oscilacion: insert en el buffer1 y extraccion en el buffer2
                    id_buffer_insert=1; 
                    this.imprimirBuffer2() ;
            }          
        }        
        semExtraer.release();
    }
}
