package Carrillo51951;

public class EjecutarTren
 {
    public static void main (String[] args) 
    {
        
        int capacidad_tren=4;
        int cantidad_de_pasajeros=6;
        Pasajero[] pasajeros = new Pasajero[cantidad_de_pasajeros];
        
        
        Tren el_tren= new Tren(capacidad_tren);
        VendedorTickets vendedor = new VendedorTickets(el_tren);    
        ControlTren el_control = new ControlTren(el_tren);  
        TrenenMarcha el_tren_en_marcha = new TrenenMarcha(el_tren);    
        

        for (int i = 0; i < cantidad_de_pasajeros; i++) {
            pasajeros[i] = new Pasajero(el_tren,"Pasajero"+i);             
        }

        Thread[] hilos_pasajeros = new Thread[cantidad_de_pasajeros];

        for (int i = 0; i < cantidad_de_pasajeros; i++) {
            hilos_pasajeros[i] = new Thread(pasajeros[i]);
            hilos_pasajeros[i].start();
        }
        
        
        
        Thread hilo_vendedor= new Thread(vendedor);
        hilo_vendedor.start();

        Thread hilo_control= new Thread(el_control);
        hilo_control.start();

        Thread hilo_trenmarcha= new Thread(el_tren_en_marcha);
        hilo_trenmarcha.start();


        
}
}