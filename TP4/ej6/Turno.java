package TP4.ej6;

import java.util.concurrent.Semaphore;

public class Turno 
{   
    private int cant_sem ;  
    private  Semaphore [] semaforos;
    
    public Turno (int total_sem)
    {    
         this.cant_sem=total_sem;                   
         this.semaforos = new Semaphore[total_sem];
         for (int i = 0; i < total_sem; i++) {
            if (i != 0)
            {
               semaforos[i] = new Semaphore(0); 
            }
            else
            {
               semaforos[i] = new Semaphore(1);
            }                        
        }                         
    }
    public  void imprimir (String letra, int posicion, int repeticiones)
    {
      try 
      {
         this.semaforos[posicion].acquire();         
      }
      catch (InterruptedException e)
      {
      }      
      for (int i=1 ; i <= repeticiones; i++ )
      {
         System.out.print(letra);
      }
      if (posicion < (this.cant_sem - 1)) 
      {
         this.semaforos[posicion+1].release();
      }
      else
      {
         this.semaforos[0].release();
      }
      
    } 
    
} 