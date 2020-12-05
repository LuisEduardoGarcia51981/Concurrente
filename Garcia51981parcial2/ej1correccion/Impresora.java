/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garcia51981parcial2.ej1correccion;
import java.util.ArrayList;

import java.util.concurrent.Semaphore;
/*codigo original:
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
*/
import java.util.logging.*;
/**
 *
 * @author Garcia Carrillo 51981 - tema
 */
public class Impresora {
    //private Recurso[] bufferPrimario;
    private ArrayList<Recurso> bufferPrimario = new ArrayList<Recurso>() ; // buffer limitado
    private ArrayList<Recurso> bufferSecundario = new ArrayList<Recurso>() ; // buffer ilimitado
    int capacidadBuffer; // capacidad del buffer limitado
    int orden_escritura;// lleva el orden de los datos ingresados
    int orden_impresion; // lleva el orden del siguiente elemento a imprimir
    int num_buffer_lim; // lleva la cuenta de cuantos elementos hay actualmente en el buffer limitado
    int contar_datos; // el total actual de datos que hay para consumir 
    Semaphore semEscFin; // semaforo que correponde a los hilos que escriben datos en los buffers
    Semaphore semEscInf; // semaforo que correponde a los hilos que escriben datos en los buffers
    Semaphore semImpr; // semaforo para el hilo que imprime
    
   
   //codigo original Lock miCerrojo=new ReentrantLock();
   

    public Impresora(int capBuffer) // capBuffer es el tamaño del buffer primario
    {    
        this.capacidadBuffer=capBuffer;
        this.orden_escritura=0;
        this.num_buffer_lim=0;
        this.contar_datos=0;
        this.orden_impresion=0;        
        semEscFin= new Semaphore(1); 
        semEscInf= new Semaphore(1); 
        semImpr= new Semaphore(0); 
       
    }
    
    public void escribirenBuffer(String dato, String nombreHilo) throws InterruptedException {
        try {
            semEscFin.acquire();            
            // inicio seccion critica
            // codigo original: miCerrojo.lock();
            orden_escritura++;
            contar_datos++;

            Recurso objDato=new Recurso(dato,orden_escritura);
            if (num_buffer_lim < capacidadBuffer)// puede escribir en el buffer finito
            {
                bufferPrimario.add(objDato);
                num_buffer_lim++;
                System.out.println("\u001B[32m"+"bufferPrimario Finito: El hilo escritor "+nombreHilo+" termino de escribir el dato: "+dato+ "\u001B[0m");
                semEscFin.release();
            }
            else // buffer finito lleno, escribe en el infinito
            {   semEscFin.release();
                semEscInf.acquire();  
                bufferSecundario.add(objDato);
                System.out.println("\u001B[32m"+"bufferSecundario Infinito: El hilo escritor "+nombreHilo+" termino de escribir el dato: "+dato+ "\u001B[0m");
                semEscInf.release();
            } ; 
            
            /*codigo original: if (contar_datos>0)
            {   
                semImpr.release(); 
            } */
            semImpr.release(); // correccion nueva

            // codigo original: miCerrojo.unlock();
            // fin seccion critica                                               
            // codigo original:  semEsc.release(); 
            
        } 
        catch (InterruptedException ex)
        {            
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null , ex);
        }
    }

  public void imprimirDatoBufferInf()
  {
    Recurso objRecurso2=bufferSecundario.get(0);
    if (objRecurso2.orden == orden_impresion)
    {
        bufferSecundario.remove(0); // lo elimino del buffer ilimitado
        contar_datos--;
        System.out.println("\u001B[34m" +"buffer infinito: El hilo de escritura  imprime: "+objRecurso2.dato +"\u001B[0m");
    }
  }
    public void imprimirDato() throws InterruptedException {
        semImpr.acquire();       
        orden_impresion++;        
        if (! bufferPrimario.isEmpty())
        {   semEscFin.acquire();  //cambio nuevo: bloqueamos el buffer finito, ya que se hacen modificaciones desde la escritura
            Recurso objRecurso=bufferPrimario.get(0);

            if (objRecurso.orden == orden_impresion)
            {
                bufferPrimario.remove(0); // lo elimino del buffer limitado
                num_buffer_lim--;
                contar_datos--;
                System.out.println("\u001B[34m" +"buffer finito: El hilo de escritura  imprime: "+objRecurso.dato +"\u001B[0m");                
                semEscFin.release();  //desbloqueamos el buffer finito, ya que se hacen modificaciones desde la escritura   
            } 
            else // buscamos el dato en el buffer infinito
            {   semEscFin.release();  //desbloqueamos el buffer finito, ya que se hacen modificaciones desde la escritura   
                imprimirDatoBufferInf();
                /* codigo original:
                Recurso objRecurso2=bufferSecundario.get(0);
                if (objRecurso2.orden == orden_impresion)
                {
                    bufferSecundario.remove(0); // lo elimino del buffer ilimitado
                    contar_datos--;
                    System.out.println("\u001B[34m" +"buffer infinito1: El hilo de escritura  imprime: "+objRecurso2.dato +"\u001B[0m");
                }*/
            };
            

        }
        else // buscamos el dato en el buffer infinito
        {
            imprimirDatoBufferInf();
            /* codigo original:
            Recurso objRecurso2=bufferSecundario.get(0);
            if (objRecurso2.orden == orden_impresion)
            {
                bufferSecundario.remove(0); // lo elimino del buffer ilimitado
                contar_datos--;
                System.out.println("\u001B[34m" +"buffer infinito2: El hilo de escritura  imprime: "+objRecurso2.dato +"\u001B[0m");
            }
            */
        }
       
    }

}
