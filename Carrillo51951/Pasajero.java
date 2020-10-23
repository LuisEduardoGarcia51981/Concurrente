package Carrillo51951;

public class Pasajero implements Runnable { 
    Tren el_tren;  
    String nombrePasajero;
    

    public Pasajero (Tren un_tren,String nombre) {
        this.el_tren=un_tren;
        this.nombrePasajero=nombre;
        
    }
    
    public void run() 
        {
        el_tren.comprar_pasaje(nombrePasajero);
        el_tren.subirme_al_tren();
        
    }

}