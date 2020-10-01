package TP4.ej8;

//import java.util.Random;
import java.util.concurrent.Semaphore;

public class Testigo 
{       
    private  Semaphore testigo;
    public  long tiempo_total_carrera;
    private  long tiempo_inicial_carrera;
    public Testigo ()
    {    
      testigo = new Semaphore(1); 
      tiempo_total_carrera=0;        
    }
    public  void correr (String nombre_corredor)
    { 
      try 
      {
         this.testigo.acquire();         
      }
      catch (InterruptedException e)
      {
      }  
      tiempo_inicial_carrera=System.currentTimeMillis();

      int delay = (int) (Math.random() * (11-9+1)+9);

      System.out.println("El corredor "+nombre_corredor+" tomo el testigo y Empezo a Correr");                        
      try 
      {
         Thread.sleep(delay*1000); // 1000 de segundos a milisegundos  
      }
      catch (InterruptedException ex) 
      {         
      } 
      tiempo_total_carrera= tiempo_total_carrera + ( (System.currentTimeMillis() / 1000 ) - tiempo_inicial_carrera);
      System.out.println("El corredor "+nombre_corredor+" termino de correr. Tardo "+delay+" segundos");    
      System.out.println();
      this.testigo.release();            
    }     
}