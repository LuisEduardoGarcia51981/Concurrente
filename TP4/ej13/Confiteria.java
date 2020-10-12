package TP4.ej13;

import java.util.concurrent.Semaphore;

public class Confiteria  { 

    Semaphore semSilla=new Semaphore(1);

    Semaphore semCocinero=new Semaphore(0);
    Semaphore semMozo=new Semaphore(0);
    Semaphore semEmpleado=new Semaphore(1);  
    Semaphore semComidalista=new Semaphore(0);  
    String nombreEmpleado;
    int sillas;
    public Confiteria () { 
                           
    }
    public void solicitarSilla ( String nombre)
    {
        try{ semSilla.acquire();      
            nombreEmpleado=nombre;                    
            System.out.println("Empleado: El empleado "+nombre+" adquirio la silla");             
        }
        catch (InterruptedException e){}        
    }   
    public void tomar_orden(String nombre) 
    {
          try{
              
            System.out.println("Empleado: El empleado "+nombre+" solicita pedido al mozo");              
            semMozo.release();   // el empleado inicio interaccio con el mozo   
            semEmpleado.acquire();    

          }                                       
            catch (InterruptedException e)
            {
            }   
    }
    
    public void esperando_empleado()   
    {   try{  
              
        semMozo.acquire();

    }
        
        catch (InterruptedException e)
        {
        }  

    }
    public void preparando_trago()
    {   
        System.out.println("Mozo: Mozo preparando trago para el Empleado "+nombreEmpleado);
        try{
        Thread.sleep(700);
        }                        
        catch (InterruptedException e) {           
            e.printStackTrace();
        }
        System.out.println("Mozo termino de preparar trago para el Empleado "+nombreEmpleado);
        //semMozo.release(); 

    }
    public void preparando_comida()
    {   
        System.out.println("Cocinero: Cocinero preparando comida para el Empleado "+nombreEmpleado);
        try{
        Thread.sleep(700);
        }                        
        catch (InterruptedException e) {           
            e.printStackTrace();
        }
        System.out.println("El cocinero termino de preparar la comida para el Empleado "+nombreEmpleado);        
        semComidalista.release();
    }
    
    public void preparando_menu()  
    {  
        try{
             System.out.println("Mozo: Preparando el menu para el Empleado "+nombreEmpleado);
            semCocinero.release(); 
            // semaforo del mozo vale 0        
            preparando_trago();
            semComidalista.acquire(); 
            System.out.println("Mozo: Entregando el pedido al Empleado "+nombreEmpleado);   
            semEmpleado.release();  
        }
                        
        catch (InterruptedException e)
        {
        }      
                          
    }
    /*
    public void entregar_menu()  
    {   try{

        semMozo.acquire();
        semCocinero.acquire();  
        
        System.out.println("Mozo: Entregando el pedido al Empleado "+nombreEmpleado);   
        semEmpleado.release();   
    }
                        
        catch (InterruptedException e)
        {
        }   
    }*/


    public void esperando_orden_decomida()  
    {   
        try{
            semCocinero.acquire();
            System.out.println("Cocinero: Orden de comida recibida para cocinarle al empleado "+nombreEmpleado);

        }
        
        catch (InterruptedException e)
        {
        }               
    }
    public void comer()  
    {   
        
        try{
            semEmpleado.acquire();
            System.out.println("Empleado: Empleado  "+nombreEmpleado+" esta comiendo");
            Thread.sleep(700);
        }                        
        catch (InterruptedException e) {           
                e.printStackTrace();
        }  
        System.out.println("Empleado  "+nombreEmpleado+" termino de comer");  
        semEmpleado.release();    
    }
    public void se_despide()  
    {   try{
        semEmpleado.acquire();
        System.out.println("Empleado: El Empleado  "+nombreEmpleado+" se levanta de la silla y se va");
        System.out.println("Mozo: Mientras espera al Empleado, inventa nuevas versiones de pollo");                   
        semEmpleado.release();        
        semSilla.release();           
        }
        catch (InterruptedException e) {  }
        
    }


    
}