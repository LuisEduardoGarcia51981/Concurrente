package Carrillo51951;

import java.util.concurrent.Semaphore;

public class Tren  { 

    Semaphore semVendedorTickets=new Semaphore(0);
    Semaphore semPasajero=new Semaphore(1);
    Semaphore semControlTren=new Semaphore(0);
    Semaphore semTrenenMarcha=new Semaphore(0);
    Semaphore semPuedeSubir=new Semaphore(1);
    boolean tren_en_marcha;
    boolean pudo_subir_al_tren;
    String nombre_del_pasajero;
    int c;// capacidad del tren
    int pasajes_vendidos;
    int pasajeros_ingresados;
    
    public Tren (int capacidad) { 
        this.c=capacidad;
        this.pasajes_vendidos=0;
        this.pasajeros_ingresados=0;
        this.tren_en_marcha = false;
        this.pudo_subir_al_tren=false;
    }

    public void comprar_pasaje(String nombrePasajero)
    {
        try
        { semPasajero.acquire();  
        }
        catch (InterruptedException e){}   
            
            this.nombre_del_pasajero=nombrePasajero;    
            System.out.println("El Pasajero "+nombrePasajero+" Solicito la compra de un pasaje");   
            semVendedorTickets.release();  
                        
         
    }   
    
    public void  esperando_cliente()
    {
        try
        { 
            semVendedorTickets.acquire();  
            System.out.println("Bienvenido "+nombre_del_pasajero+" a la boleteria");                                      
        }
        catch (InterruptedException e){}     
    }   
    public void  vender_pasaje()
    {
            
            pasajes_vendidos++;
            System.out.println("Pasaje vendido a "+nombre_del_pasajero);  

            //semPasajero.release(); 

       
    }   
    
    public void  subirme_al_tren()
    {    try
        { 
         semPuedeSubir.acquire();
         semControlTren.release();   
         
        }  
        catch (InterruptedException e){}       
    }   
    public void  esperando_controlar()
    {
               
        try
        { 
            semControlTren.acquire();  
            System.out.println("Bienvenido "+nombre_del_pasajero+" al control del Tren");
            if (pasajeros_ingresados<c)  
            {   
                pasajeros_ingresados++;
                System.out.println("Pasajero "+nombre_del_pasajero+" usted puede entrar al tren");
                pudo_subir_al_tren=true;
                if (pasajeros_ingresados== c)
                {  semTrenenMarcha.release(); }else {semPuedeSubir.release();}
                
                

            }
            else // se ocupo la capacidad maxima "c" del tren
            {   
                System.out.println("Pasajero "+nombre_del_pasajero+" usted no puede entrar al tren. Tren Lleno"); 

                if (tren_en_marcha)
                {
                    
                }else
                {
                    semTrenenMarcha.release();

                }
                
            }
            
        }
        catch (InterruptedException e){}   
        semPasajero.release();   
       
    }
    public void  esperando_comenzar_recorrido()
    {
        try
        { 
            semTrenenMarcha.acquire();  
            System.out.println("El tren comenzo su recorrido con "+pasajeros_ingresados+" pasajeros");  
            try
            {
                Thread.sleep(700);
            }                        
            catch (InterruptedException e) 
            {           
                    e.printStackTrace();
            }   
            System.out.println("El tren Ya termino su recorrido. Listo para nuevo que ingresen Nuevos pasajeros");
            tren_en_marcha=false;
            pasajeros_ingresados=0;
            semPuedeSubir.release();
            
            
        }
        catch (InterruptedException e){}     
    } 

}