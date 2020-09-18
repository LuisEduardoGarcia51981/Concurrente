package TP3;

/**
 *
 * @author b h
 */
public class Surtidor {
    private ManejadorTurnos manejador;
    
    public Surtidor()
    {
        this.manejador= new ManejadorTurnos();
    }
    
    public  int obtenerTurno() 
    {          
       return manejador.obtenerTurno(); 
    }
        

    public synchronized void cargarNafta(String patente) throws InterruptedException {
        System.out.println(patente + " cargando nafta");
        Thread.sleep(700);
        System.out.println(patente + " cargó nafta");
    }
}