package TP4.ej9;

import java.util.concurrent.Semaphore;

public class Cliente implements Runnable{
    private Semaphore semCliente;    
    private Taxista taxista;


    public Cliente (Taxista taxista)
    {    
        semCliente = new Semaphore(1);   
        this.taxista=taxista;
    }
    public void buscando_taxi()
    {   int delay = (int) (Math.random() * (3-2+1)+2);
        try 
        {   System.out.println("El cliente esta buscando un taxi");
            Thread.sleep(delay*1000); // 1000 de segundos a milisegundos  
            
        }
        catch (InterruptedException ex) { } 
        try 
        {   
            taxista.getSemaforo().acquire();
        }
        catch (InterruptedException e){}
        taxista.llevar_Cliente(this.semCliente);

    }
    public void run ()  
    {    
        buscando_taxi();                         
    }
    
}
