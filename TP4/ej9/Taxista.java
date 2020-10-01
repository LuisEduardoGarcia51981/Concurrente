package TP4.ej9;

import java.util.concurrent.Semaphore;

public class Taxista implements Runnable{
    private Semaphore semTaxista;
    
    public Semaphore getSemaforo ()
    {    
        return this.semTaxista;
    }
    
    public void llevar_Cliente(Semaphore semCliente)
    {
        int delay = (int) (Math.random() * (4-2+1)+2);
        try 
        {   
            semCliente.acquire();
            System.out.println("EL taxista desperto");
            //llevando a destino   
            System.out.println("Taxista llevando a destino al Cliente");
            Thread.sleep(delay*1000); // 1000 de segundos a milisegundos
        }
        catch (InterruptedException e){}           
        finally 
        {   
            semCliente.release();
            System.out.println("Taxista llego a destino y el Cliente se bajo del taxi");
            this.semTaxista.release();
            System.out.println("El taxista durmiendo nuevamente");
        }
        

    }
    public void run ()  
    {    
        semTaxista = new Semaphore(1); 
        System.out.println("Taxista Durmiento"); 
                   
    }
    
}
